
// import of additional modules (npm install ...)
import * as nconf from 'nconf';
import * as path from 'path';

// import of Node.js modules
import * as fs from 'fs';

process.env['DEBUG'] = '*::*';
import { Server } from './server';

// logging with debug-sx/debug
import * as debugsx from 'debug-sx';
const debug: debugsx.ISimpleLogger = debugsx.createSimpleLogger('main');

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

// start of application
const server = new Server();
server.start(8080)
  .catch( (err) => {
    debug.warn(err);
  });



