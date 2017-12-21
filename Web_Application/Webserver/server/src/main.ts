process.env['DEBUG'] = '*::INFO, *::WARN, *::ERR, *::SEVERE, *::';
process.env['DEBUG_COLORS'] = 'true';
process.env['DEBUG_STREAM'] = 'stdout';

import * as express from 'express';
import * as path from 'path';
import * as bodyparser from 'body-parser';
import * as debugsx from 'debug-sx';

import * as http from 'http';
import * as https from 'https';
import * as child from 'child_process';
import * as fs from 'fs';
import { Server } from './server';

const date = new Date();
export const log: debugsx.IFullLogger = debugsx.createFullLogger('main');
const consolelogger: debugsx.IHandler = debugsx.createConsoleHandler('stdout', '*', '-*', [
  { level: /INFO*/, color: 'cyan', inverse: true },
  { level: /FINE*/, color: 'white', inverse: true },
  { level: /SEVERE*/, color: 'red', inverse: true },
  { level: /ERR*/, color: 'red', inverse: true },
  { level: /WARN*/, color: 'magenta', inverse: true },
]);
const filelogger: debugsx.IHandler = debugsx.createFileHandler(path.join(__dirname, '../log/') + date.toLocaleDateString() + '_' + date.getHours() + '.' + date.getMinutes() + '.' + date.getSeconds() + '.log', '*', '-*', [
  { level: /INFO*/, color: 'cyan', inverse: true },
  { level: /FINE*/, color: 'white', inverse: true },
  { level: /SEVERE*/, color: 'red', inverse: true },
  { level: 'ERR', color: 'red', inverse: true },
  { level: 'WARN', color: 'magenta', inverse: true }
]);
debugsx.addHandler(consolelogger, filelogger);

const port = 17325;

Server.Instance.start(port)
  .catch(err => {
    log.warn(err);
  });



