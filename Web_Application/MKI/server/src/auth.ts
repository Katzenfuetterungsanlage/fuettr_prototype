// import of additional modules (npm install ...)
import * as nconf from 'nconf';
import * as path from 'path';
import * as express from 'express';
import * as passport from 'passport';
import * as jwt from 'jsonwebtoken';
import * as expressJwt from 'express-jwt';
import { Strategy, IVerifyOptions, IStrategyOptionsWithRequest } from 'passport-local';

// import of Node.js modules
import * as fs from 'fs';

// import modules of this project
import { DbUser } from './db/db-user';
import { User } from './db/document/user';

import * as debugsx from 'debug-sx';
const debug: debugsx.IFullLogger = debugsx.createFullLogger('auth');


export class Auth {
  private static _instance: Auth;

  public static get Instance() {
    if (!this._instance) {
      this._instance = new this();
      Object.seal(this._instance);
      Object.seal(this._instance.constructor);
    }
    return this._instance;
  }

  public static get expressMiddleware (): express.RequestHandler [] {
    const inst = Auth.Instance;
    return [ inst.passportInit.bind(inst) ];
  }

  public static get expressMiddlewareAuthenticate (): express.RequestHandler [] {
    const inst = Auth.Instance;
    return [ inst.generateAccessToken.bind(inst) ];
  }

  public static get expressMiddlewareLogin (): express.RequestHandler [] {
    const inst = Auth.Instance;
    return [ inst.authenticate.bind(inst), inst.generateRemoteToken.bind(inst) ];
  }

  public static get expressMiddleWareCheckToken (): express.RequestHandler [] {
    const inst = Auth.Instance;
    return [ inst.checkToken.bind(inst), inst.deserialize.bind(inst) ];
  }


  // ****************************************************************

  private _privateKey: Buffer ;
  private _publicKey: Buffer;
  private _passport: MyPassport;
  private _expressJwt: express.RequestHandler;

  private constructor () {
    const authConfig: {
       privatekey: string,
       publickey?: string,
       authorization_uri?: string,
       accessTokenTimeout?: string,
       remoteTokenTimeout?: string,
       remoteTokenMinimumSeconds?: number
    } = nconf.get('auth') || {};

    try {
      let privFileName = authConfig.privatekey;
      if (!privFileName.startsWith('/')) {
        privFileName = path.join(__dirname, '../', privFileName);
      }
      let pubFileName = authConfig.publickey;
      if (pubFileName && !pubFileName.startsWith('/')) {
        pubFileName = path.join(__dirname, '../', pubFileName);
      }
      this._privateKey = fs.readFileSync(privFileName);
      if (pubFileName) {
        this._publicKey = fs.readFileSync(pubFileName);
      } else {
        this._publicKey = this._privateKey;
      }
      this._expressJwt = expressJwt({secret: this._publicKey});
    } catch (err) {
      console.log('Error: missing private key for authentification');
      process.exit(1);
    }
    this._passport = new MyPassport(this._privateKey, authConfig.accessTokenTimeout,
                                    authConfig.remoteTokenTimeout, authConfig.remoteTokenMinimumSeconds);
  }

  // Passport methods

  private passportInit (req: express.Request, res: express.Response, next: express.NextFunction) {
    debug.fine('passportInit()');
    this._passport.init(req, res, next);
  }

  private authenticate (req: express.Request, res: express.Response, next: express.NextFunction) {
    debug.fine('authenticate()');
    this._passport.authenticate(req, res, next);
  }

  private generateRemoteToken(req: express.Request, res: express.Response, next: express.NextFunction) {
    debug.fine('generateRemoteToken()');
    this._passport.generateRemoteToken(req, res, next);
  }

  private generateAccessToken(req: express.Request, res: express.Response, next: express.NextFunction) {
    debug.fine('generateAccessToken()');
    this._passport.generateAccessToken(req, res, next);
  }

  private checkToken (req: express.Request, res: express.Response, next: express.NextFunction) {
    debug.fine('checkToken()');
    this._expressJwt(req, res, next);
  }

  private deserialize (req: express.Request, res: express.Response, next: express.NextFunction) {
    debug.fine('deserialize()');
    if (req.user.htlid) {
      req.user.model = DbUser.Instance.getCachedUser(req.user.htlid);
    }
    next();
  }

}


class MyPassport {
  private _privateKey: Buffer;
  private _accessTokenTimeout: string;
  private _remoteTokenTimeout: string;
  private _remoteTokenMinimumSeconds: number;
  private _init: express.Handler;
  private _authenticate: express.Handler;

  constructor (privateKey: Buffer, accessTokenTimeout?: string, remoteTokenTimeout?: string, remoteTokenMinimumSeconds?: number) {
    this._privateKey = privateKey;
    this._accessTokenTimeout = accessTokenTimeout || '5min';
    this._remoteTokenTimeout = remoteTokenTimeout || '23:59:59';
    this._remoteTokenMinimumSeconds = remoteTokenMinimumSeconds || 3600;
    const strategyOptions: IStrategyOptionsWithRequest = { passReqToCallback: true, usernameField: 'htlid', passwordField: 'password'};
    passport.use(new Strategy(strategyOptions, this.verify));
    this._init = passport.initialize();
    this._authenticate = passport.authenticate('local', { session: false });
  }

  public init (req: express.Request, res: express.Response, next: express.NextFunction) {
    this._init(req, res, next);
  }

  public verify (req: express.Request, username: string, password: string,
                 done: (error: any, user?: any, options?: IVerifyOptions) => void) {
    const user = DbUser.Instance.getCachedUser(username);
    const htlid = username;
    if (! (user instanceof User)) {
      debug.warn('unknown user %s', htlid);
      done(null, 'unknown user or wrong password'); // message is sent back to client
      return;
    }
    if (htlid === 'gast') {
      debug.warn('login user gast forbidden');
      done(null, 'forbidden user ' + htlid); // message is sent back to client
      return;
    }
    if (!user.verifyPassword(password)) {
      debug.info('%s %s %s -> FAILED (password verification))', req.method, req.url, htlid);
      done(null, 'unknown user or wrong password'); // message is sent back to client
      return;
    }

    debug.fine('%s %s %s -> OK (password verification)', req.method, req.url, htlid);
    done(null, { htlid: htlid });
  }

  public authenticate (req: express.Request, res: express.Response, next: express.NextFunction) {
    if (!req.body.htlid) {
      // res.status(400).json({ 'error_type' : 'malformed_json', 'error_description' : 'missing htlid' });
      next(new DbAuthError('cannot authenticate, missing htlid', req.user));
    } else if (!req.body.password) {
      // res.status(400).json({ 'error_type' : 'malformed_json', 'error_description' : 'missing password' });
      next(new DbAuthError('cannot authenticate, missing password', req.user));
    } else {
      this._authenticate(req, res, next);
    }
  }


  public generateRemoteToken (req: express.Request, res: express.Response, next: express.NextFunction) {
     if (req.user && req.user.htlid) {
       let expiresIn: string;
       const f = this._remoteTokenTimeout.split(':');
       if (f.length !== 3) {
         expiresIn = this._remoteTokenTimeout;
       } else {
         const now = new Date();
         const expTime = new Date(now.getFullYear(), now.getMonth(), now.getDate(), +f[0], +f[1], +f[2] );
         let seconds = Math.floor((expTime.getTime() - now.getTime()) / 1000);
         if (seconds < this._remoteTokenMinimumSeconds) {
           seconds += 24 * 60 * 60; // timeout on next day
         }
         expiresIn =  seconds + 's';
       }
      (<any>req).remoteToken = jwt.sign((<any>{ htlid: req.user.htlid }), this._privateKey, { expiresIn: expiresIn, algorithm: 'RS256' });
      debug.fine('user %s found, creating remoteToken (expiresIn %s) %s', req.user.htlid, expiresIn, (<any>req).remoteToken);
      (<any>req).accessToken = jwt.sign((<any>{ htlid: req.user.htlid }), this._privateKey,
                                          { expiresIn: this._accessTokenTimeout, algorithm: 'RS256' });
      debug.fine('user %s found, creating accessToken %s', req.user.htlid, (<any>req).accessToken);
      next();
    } else {
      debug.fine('missing user --> no token created');
      next(new DbAuthError('cannot create remoteToken', req.user));
    }
  }

  public generateAccessToken (req: express.Request, res: express.Response, next: express.NextFunction) {
    if (!req.user || !req.user.htlid) {
      debug.fine('authorization fails--> no token created');
      next(new DbAuthError('cannot create accessToken', 'authorization fails')); // message sent to client
    } else if (!req.body || !req.body.htlid) {
      debug.fine('missing user --> no token created');
      next(new DbAuthError('cannot create accessToken', 'missing or wrong htlid')); // message sent to client
    } else if (req.user.htlid !== req.body.htlid) {
      debug.fine('wrong htlid (%s !== %s) --> no token created', req.user.htlid, req.body.htlid);
      next(new DbAuthError('cannot create accessToken', 'missing or wrong htlid')); // message sent to client
    } else {
      (<any>req).accessToken = jwt.sign((<any>{ htlid: req.user.htlid }), this._privateKey,
                                        { expiresIn: this._accessTokenTimeout, algorithm: 'RS256' });
      debug.fine('user %s found, creating accessToken %s', req.user.htlid, (<any>req).accessToken);
      if (req.user && req.user.exp) {
        console.log(req.user.exp - Date.now());
      }
      next();
    }
  }

}

export class DbAuthError extends Error {
  private _description: string;

  constructor(message: string, description?: string) {
    super(message);
    this._description = description;
  }

  public get description (): string {
    return this._description || 'no detail description available';
  }
}
