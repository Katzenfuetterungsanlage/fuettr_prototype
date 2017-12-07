import * as express from 'express';
import * as bodyparser from 'body-parser';
import * as path from 'path';
import * as http from 'http';
import * as debugsx from 'debug-sx';

import { Auth } from './auth';

const date = new Date().toISOString();
const debug: debugsx.IFullLogger = debugsx.createFullLogger('server');
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

export class Server {
    private _express: express.Application;
    private _auth: Auth;
    private _router: express.Router;
    private storedpass = 'enter';
    private storeduser = 'enter';
    private jsonToken: boolean;

    public constructor() {
        this.jsonToken = false;
        this._express = express();
        this._router = this._express;
        this._express.use(bodyparser.urlencoded({ extended: true }));
        this._express.set('views', path.join(__dirname, '/views'));
        const pugEngine = this._express.set('view engine', 'pug');
        pugEngine.locals.pretty = true;

        this._router.use(this.logger.bind(this));
        this._router.get('/favicon.ico', express.static(path.join(__dirname, '../public')));
        this._router.use('/node_modules', express.static(path.join(__dirname, '../node_modules')));
        this._router.post('/login', this.login.bind(this));
        this._router.get('/login', this.isLoggedIn.bind(this));
        this._router.get('/api/ip', this.getIp.bind(this));
        this._router.get('/api/extensions', (req, res) => { res.sendFile(path.join(__dirname, 'views/README.html')); });
        this._router.get('/api/version', (req, res) => { res.sendFile(path.join(__dirname, '../../../../version.json')); });
        this._router.get('/api/face', (req, res) => { res.sendFile(path.join(__dirname, 'views/face.html')); });
        this._router.get('/inline.bundle.js', (req, res) => { res.sendFile(path.join(__dirname, '../../ng2/dist/inline.bundle.js')); });
        this._router.get('/main.bundle.js', (req, res) => { res.sendFile(path.join(__dirname, '../../ng2/dist/main.bundle.js')); });
        this._router.get('/polyfills.bundle.js', (req, res) => { res.sendFile(path.join(__dirname, '../../ng2/dist/polyfills.bundle.js')); });
        this._router.get('/styles.bundle.js', (req, res) => { res.sendFile(path.join(__dirname, '../../ng2/dist/styles.bundle.js')); });
        this._router.get('/vendor.bundle.js', (req, res) => { res.sendFile(path.join(__dirname, '../../ng2/dist/vendor.bundle.js')); });
        this._router.get('/inline.bundle.js.map', (req, res) => { res.sendFile(path.join(__dirname, '../../ng2/dist/inline.bundle.js.map')); });
        this._router.get('/main.bundle.js.map', (req, res) => { res.sendFile(path.join(__dirname, '../../ng2/dist/main.bundle.js.map')); });
        this._router.get('/polyfills.bundle.js.map', (req, res) => { res.sendFile(path.join(__dirname, '../../ng2/dist/polyfills.bundle.js.map')); });
        this._router.get('/styles.bundle.js.map', (req, res) => { res.sendFile(path.join(__dirname, '../../ng2/dist/styles.bundle.js.map')); });
        this._router.get('/vendor.bundle.js.map', (req, res) => { res.sendFile(path.join(__dirname, '../../ng2/dist/vendor.bundle.js.map')); });
        this._router.get('/styles.css', (req, res) => { res.sendFile(path.join(__dirname, '../../ng2/src/styles.css')); });
        this._router.get('/bootstrap.css', (req, res) => { res.sendFile(path.join(__dirname, '../../ng2/src/bootstrap.css')); });
        this._router.use(this.requestHandler.bind(this));
        this._router.use(this.error404Handler.bind(this));
        this._router.use(this.errorHandler.bind(this));
    }

    public start(port: number): Promise<Server> {
        return new Promise<Server>((resolve, reject) => {
            const server = http.createServer(this._express).listen(port, () => {
                debug.info('Server running on port ' + port);
            });

            server.on('close', () => {
                debug.fine('Server stopped.');
            });

            server.on('err', err => {
                debug.severe(err);
            });
        })
    }


    private login(req: express.Request, res: express.Response, next: express.NextFunction) {
        const userpass = req.body.password;
        const username = req.body.user;
        if (userpass === this.storedpass && username === this.storeduser) {
            this.jsonToken = true;
            setTimeout(() => {
                this.jsonToken = false;
                debug.fine('User logged out.');
            }, 60000);
            res.redirect('/');
        } else {
            res.status(401).sendFile(path.join(__dirname, 'views/login-form-error.html'));
        }
    }


    private requestHandler(req: express.Request, res: express.Response, next: express.NextFunction) {
        this.jsonToken = true;
        if (this.jsonToken) {
            this._auth = new Auth(this._router);
        } else {
            res.redirect('/login');
        }
    }


    private isLoggedIn(req: express.Request, res: express.Response, next: express.NextFunction) {
        res.sendFile(path.join(__dirname, 'views/login-form.html'));
    }


    private error404Handler(req: express.Request, res: express.Response, next: express.NextFunction) {
        const clientSocket = req.socket.remoteAddress + ':' + req.socket.remotePort;
        debug.warn('Error 404 for %s %s from %s', req.method, req.url, clientSocket);
        res.status(404).sendFile(path.join(__dirname, 'views/error404.html'));
    }


    private errorHandler(err: express.Errback, req: express.Request, res: express.Response, next: express.NextFunction) {
        const ts = new Date().toLocaleString();
        debug.severe('Error %s\n%e', ts, err);
        res.status(500).render('error500.pug', {
            time: ts,
            err: err,
            href: 'mailto:greflm13@htl-kaindorf.ac.at?subject=Füttr server failed ' + ts,
            serveradmin: 'Florian Greistorfer'
        });
    }


    private getIp(req: express.Request, res: express.Response, next: express.NextFunction) {
        http.get({ port: 80, host: 'api.ipify.org', path: '/?format=json' }, resp => {
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
            .on('error', err => { debug.severe(err); });
    }


    private logger(req: express.Request, res: express.Response, next: express.NextFunction) {
        const clientSocket = req.socket.remoteAddress + ':' + req.socket.remotePort;
        debug.info(req.method, req.url, clientSocket);
        next();
    }

}