
// import of additional modules (npm install ...)
import * as nconf from 'nconf';
import * as path from 'path';

// import of Node.js modules
import * as fs from 'fs';


// configuration
nconf.argv().env();
const configFilename = path.join(__dirname, '../config.json');
try {
  fs.accessSync(configFilename, fs.constants.R_OK);
  nconf.file(configFilename);
} catch (err) {
  console.log('Error on config file ' + configFilename + '\n' + err);
  process.exit(1);
}

let debugConfig: any = nconf.get('debug');
if (!debugConfig) {
  debugConfig = { debug: '*::*' };
}
for (const a in debugConfig) {
  if (debugConfig.hasOwnProperty(a)) {
    const name: string = (a === 'enabled') ? 'DEBUG' : 'DEBUG_' + a.toUpperCase();
    if (!process.env[name] && (debugConfig[a] !== undefined || debugConfig[a] !== undefined)) {
      process.env[name] = debugConfig[a] ? debugConfig[a] : debugConfig[a];
    }
  }
}

// logging with debug-sx/debug
import * as debugsx from 'debug-sx';
const debug: debugsx.ISimpleLogger = debugsx.createSimpleLogger('main');

debugsx.addHandler(debugsx.createConsoleHandler('stdout'));
const logfileConfig = nconf.get('logfile');
if (logfileConfig) {
  for (const att in logfileConfig) {
    if (logfileConfig.hasOwnProperty(att)) {
      const h = debugsx.createFileHandler( logfileConfig[att])
      debugsx.addHandler(h);
    }
  }
}


// ***********************************************************
// startup of application
//   ... things to do before server can be started
// ***********************************************************

import { Dbms } from './db/core/dbms';
import { MongooseDbms } from './db/core/mongoose-dbms';
import { Database } from './db/core/database';
import { DbUser } from './db/db-user';
import * as mongoose from 'mongoose';
(<any>mongoose).Promise = Promise;

const startupPromisses: Promise<void> [] = [];

startupPromisses.push(new Promise<void>( (resolve, reject) => {
  const dbms: Dbms = MongooseDbms.Instance;
  dbms.openDatabase('webserver').then( db => {
    debug.info('Database %s connected', db.name());
    const dbUser = DbUser.createInstance(db);
    dbUser.findAll().then( users => {
      debug.info('%s users found', users.length);
      const cachedUsers = dbUser.getCachedDocuments();
      const usersConfig = nconf.get('users');
      const userPromisses: Promise<any> [] = [];
      if (Array.isArray(usersConfig)) {
        for (const u of usersConfig) {
          if (!u.user) {
            debug.warn('config users: missing attribute user');
            continue;
          }
          if (!u.user.htlid) {
            debug.warn('config users: missing attribute htlid');
            continue;
          }
          const user = cachedUsers[u.user.htlid];
          switch (u.command) {
            case 'create': {
              if (!user) {
                userPromisses.push(dbUser.create(u.user).catch(err => debug.warn(err)) );
              }
              break;
            }

            case 'delete': {
              if (user) {
                userPromisses.push(dbUser.delete(user).catch(err => debug.warn(err)));
              }
              break;
            }

            case 'modify': {
              if (user) {
                user.surname = u.user.surname || user.surname;
                user.firstname = u.user.firstname || user.firstname;
                user.password = u.user.password || user.password;
                userPromisses.push(user.save().catch(err => debug.warn(err)));
              }
              break;
            }

            case undefined: case 'ignore': break;
            default: debug.warn('config users command %s not supported', u.command);
          }
        }
      }
      Promise.all(userPromisses).then( () => {
        resolve();
      }).catch(err => reject(err));
    }).catch( err => { reject(err) } );
  }).catch( err => { reject(err) } );
}));


// ***********************************************************
// start of server application
// ***********************************************************

import { Server } from './server';

Promise.all(startupPromisses).then( () => {
  const server = new Server();
  server.start(8080).then( () => {
    const shutdownMillis = +nconf.get('shutdownMillis');
    if (shutdownMillis > 0) {
      setTimeout( () => {
        debug.info('application timeout, starting shutdown ...');
        let shutDownPromisses: Promise<any> [] = [];
        shutDownPromisses.push(server.stop().catch(err => console.log(err) ));
        shutDownPromisses = shutDownPromisses.concat(MongooseDbms.Instance.shutdown());
        Promise.all(shutDownPromisses).then( (result) => {
          console.log('shutdown successful');
          process.exit(0);
        }).catch( err => {
          console.log(err);
          console.log('shutdown fails');
          process.exit(1);
        })
      }, shutdownMillis);
    }
  }).catch(err => {
      console.log(err);
      console.log('Error: Start of server fails');
      process.exit(1);
    });
}).catch( err => {
  console.log(err);
  console.log('Error: Startup fails');
  process.exit(1);
});
