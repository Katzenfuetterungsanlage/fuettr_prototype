import * as express from 'express';
import * as path from 'path';
import * as bodyparser from 'body-parser';
import * as debugsx from 'debug-sx';
import * as http from 'http';
import * as https from 'https';
import * as child from 'child_process';
import * as fs from 'fs';

import { log } from './main';
import { ApiRoutes } from './api-routes';


export class Server {

    // #region Singleton

    private static _instance: Server;

    public static get Instance(): Server {
        if (Server._instance === undefined) {
            Server._instance = new Server()
        }
        return Server._instance;
    }

    _express = express();
    _activeToken = true;

    constructor() {
        this._express.use(bodyparser.json());
        this._express.use(bodyparser.urlencoded({ extended: true }));
        this._express.set('views', path.join(__dirname, '/views'));
        const pugEngine = this._express.set('view engine', 'pug');
        pugEngine.locals.pretty = true;
        this._express.use(this.logger);

        this._express.use('/api', ApiRoutes.ApiRouter.Routes);
        // this._express.use('/', ServerRoutes.ServerRouter.Routes);


        this._express.get('**', (req, res, next) => {
            res.sendFile(path.join(__dirname, 'views/index.html'));
        });
    }
    
    public logger(req: express.Request, res: express.Response, next: express.NextFunction) {
        const clientSocket = req.socket.remoteAddress + ':' + req.socket.remotePort;
        log.info(req.method, req.url, clientSocket);
        next();
    }

    public start(port: number): Promise<Server> {
        return new Promise<Server>((resolve, reject) => {
            const server = http.createServer(this._express).listen(port, () => {
                log.info('Server running on port ' + port);
                server.on('close', () => {
                    log.fine('Server stopped.');
                });
                server.on('err', err => {
                    log.warn(err);
                });
            });
        })

    }

}