import * as debugsx from 'debug-sx';

import { Server } from './server';

process.env['DEBUG'] = '*';
process.env['DEBUG_COLORS'] = 'true';
process.env['DEBUG_STREAM'] = 'stdout';
const date = new Date().toISOString();
const debug: debugsx.IFullLogger = debugsx.createFullLogger('main');
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
debugsx.addHandler(consolelogger, filelogger);

const server = new Server();
server.start(17325)
  .catch(err => {
    debug.severe(err);
  });