import * as express from 'express';
import * as path from 'path';
import * as fs from 'fs';
import * as jwt from 'jsonwebtoken';
import * as ejwt from 'express-jwt';

import { Server } from './server';
import { log } from './main';

export class AppRoutes {

    // #region Static Methods

    private static _appRouter: AppRoutes;

    public static get AppRouter(): AppRoutes {
        if (AppRoutes._appRouter === undefined) {
            AppRoutes._appRouter = new AppRoutes
        }
        return AppRoutes._appRouter;
    }

    // #endregion

    private _routes: express.Router;
    private _publkey: Buffer;
    private _privkey: Buffer;

    public constructor() {
        this._publkey = fs.readFileSync(path.join(__dirname, '../keys/server-public.pem'));
        this._privkey = fs.readFileSync(path.join(__dirname, '../keys/server-private.pem'));
        this._routes = express();

        this._routes.get('**', (req, res, next) => {
            res.sendFile(path.join(__dirname, 'views/index.html'));
        });
    }

    public get Routes(): express.Router {
        return this._routes;
    }
}