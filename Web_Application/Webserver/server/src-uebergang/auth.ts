import { Server } from './server';
import * as express from 'express';
import * as path from 'path';
import * as bodyparser from 'body-parser';
import * as debugsx from 'debug-sx';
import * as child from 'child_process';
import * as http from 'http';
import * as fs from 'fs';

const date = new Date().toISOString();
const debug: debugsx.IFullLogger = debugsx.createFullLogger('paths');
let consolelogger: debugsx.IHandler = debugsx.createConsoleHandler('stdout', '*', '-*', [
    { level: /INFO*/, color: 'cyan', inverse: true },
    { level: /FINE*/, color: 'white', inverse: true },
    { level: /SEVERE*/, color: 'red', inverse: true },
    { level: 'ERR', color: 'red', inverse: true },
    { level: 'WARN', color: 'magenta', inverse: true }
]);
let filelogger: debugsx.IHandler = debugsx.createFileHandler(
    '/var/log/fuettr/' + date + '.log',
    '*',
    '-*',
    [
        { level: /INFO*/, color: 'cyan', inverse: true },
        { level: /FINE*/, color: 'white', inverse: true },
        { level: /SEVERE*/, color: 'red', inverse: true },
        { level: 'ERR', color: 'red', inverse: true },
        { level: 'WARN', color: 'magenta', inverse: true }
    ]
);

export class Auth {

    public constructor(router: express.Router) {

        router.use('/assets', express.static(path.join(__dirname, '../../ng2/dist/assets')));
        router.use('/ng2', express.static(path.join(__dirname, '../../ng2')));
        router.post('/api/putMeHere', this.putMeHere.bind(this));
        router.get('/api/callMeMaybe', this.callMeMaybe.bind(this));
        router.get('/api/getUpdate', this.update.bind(this));
        router.get('/api/shutdown', this.shutdown.bind(this));
        router.get('**', (req, res) => { res.sendFile(path.join(__dirname, '../../ng2/dist/index.html')); });
    }


    private error404Handler(req: express.Request, res: express.Response, next: express.NextFunction) {
        const clientSocket = req.socket.remoteAddress + ':' + req.socket.remotePort;
        debug.warn('Error 404 for %s %s from %s', req.method, req.url, clientSocket);
        res.status(404).sendFile(path.join(__dirname, 'views/error404.html'));
    }


    private getFromJava(res: express.Response, path: string) {
        http.get({ port: 666, host: 'localhost', path: '/' + path }, resp => {
            let data = '';

            resp.on('data', chunk => { data += chunk; });

            resp.on('end', () => {
                try {
                    res.json(JSON.parse(data));
                } catch (err) {
                    debug.severe(err);
                }
            });
        })
            .on('error', err => {
                debug.severe(err);
            });
    }


    private callMeMaybe(req: express.Request, res: express.Response, next: express.NextFunction) {
        switch (req.query.q) {
            case 'warnings': {
                res.sendFile(path.join(__dirname, '../testfiles/warnings.json'));
                // this.getFromJava(res, 'warnings');
                break;
            }

            case 'errors': {
                res.sendFile(path.join(__dirname, '../testfiles/errors.json'));
                // this.getFromJava(res, 'errors');
                break;
            }

            case 'times': {
                res.sendFile(path.join(__dirname, '../testfiles/times.json'));
                // this.getFromJava(res, 'times');
                break;
            }

            case 'status': {
                res.sendFile(path.join(__dirname, '../testfiles/status.json'));
                // this.getFromJava(res, 'status');
                break;
            }

            case 'info': {
                res.sendFile(path.join(__dirname, '../testfiles/info.json'));
                // this.getFromJava(res, 'info');
                break;
            }

            case 'positions': {
                res.sendFile(path.join(__dirname, '../testfiles/positions.json'));
                // this.getFromJava(res, 'positions');
                break;
            }

            default: {
                this.error404Handler(req, res, next);
            }
        }
    }


    private getToJava(path: string, data: string): string {
        const options = {
            host: 'localhost',
            port: 666,
            path: path,
            method: 'PUT'
        };

        let back: string;

        const req = http.request(options, res => {
            res.on('data', chunk => {
                back += chunk;
            });
        });

        req.on('error', error => {
            debug.warn(error.message);
        });

        req.write(data);
        req.end();
        return back;
    }


    private putMeHere(req: express.Request, res: express.Response, next: express.NextFunction) {
        const OK = {
            ok: 'ok'
        };
        switch (req.query.q) {
            case 'times': {
                // getToJava('/putTimes', JSON.stringify(req.body));

                fs.writeFileSync(path.join(__dirname, '../testfiles/times.json'), JSON.stringify(req.body));
                res.sendFile(path.join(__dirname, '../testfiles/times.json'));
                break;
            }

            case 'ackErr': {
                this.getToJava('/ackErr', JSON.stringify(req.body));
                break;
            }

            case 'ackWarn': {
                this.getToJava('/ackWarn', JSON.stringify(req.body));
                break;
            }

            default: {
                this.error404Handler(req, res, next);
            }
        }
    }


    private update(req: express.Request, res: express.Response, next: express.NextFunction) {
        res.sendFile(path.join(__dirname, 'views/update.html'));
        child.exec(`cd .. && git reset --hard && git pull && sudo npm-install-missing`, (error, stdout, stderr) => {
            if (stdout !== '') {
                debug.info(stdout);
            }
            if (error !== null) {
                debug.warn(error);
            }
            child.exec(`cd ../ng2 && sudo npm-install-missing`, (error, stdout, stderr) => {
                if (stdout !== '') {
                    debug.info(stdout);
                }
                if (error !== null) {
                    debug.warn(error);
                }
                child.exec(`sudo reboot`, (error, stdout, stderr) => {
                    if (stdout !== '') {
                        debug.info(stdout);
                    }
                    if (error !== null) {
                        debug.warn(error);
                    }
                });
            });
        });
    }


    private shutdown() {
        child.exec('sudo poweroff', error => {
            debug.warn(error);
        });
    }

}