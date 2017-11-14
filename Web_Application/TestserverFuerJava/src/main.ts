import * as express from 'express';
import * as path from 'path';

import * as http from 'http';
import * as fs from 'fs';



process.env['DEBUG'] = '*';
process.env['DEBUG_COLORS'] = "true";
process.env['DEBUG_STREAM'] = "stdout";
import * as debugsx from 'debug-sx';
const debug: debugsx.IFullLogger = debugsx.createFullLogger('main');
let consolelogger: debugsx.IHandler = debugsx.createConsoleHandler('stdout', "*");
let date = new Date();
let filelogger: debugsx.IHandler = debugsx.createFileHandler(
  'logs/' + date.getFullYear() + '-' + date.getUTCMonth() + '-' + date.getUTCDay() + '_' + date.getUTCHours() + '-' + date.getUTCMinutes() + '-' + date.getUTCSeconds() + '.log', );

debugsx.addHandler(consolelogger, filelogger);

const serverApp = express();
serverApp.set('views', path.join(__dirname, '/views'));
const pugEngine = serverApp.set('view engine', 'pug');
pugEngine.locals.pretty = true;

serverApp.use(logger);
serverApp.get('/api/callMeMaybe', callMeMaybe);
serverApp.get('**', (req, res) => { res.redirect('/api/callMeMaybe') });
serverApp.use(error404Handler);
serverApp.use(errorHandler);

const port = 80;
const server = http.createServer(serverApp).listen(port);
debug.info('Server running on port ' + port);



function error404Handler(req: express.Request, res: express.Response, next: express.NextFunction) {
  const clientSocket = req.socket.remoteAddress + ':' + req.socket.remotePort;
  debug.warn('Error 404 for %s %s from %s', req.method, req.url, clientSocket);
  res.status(404).sendFile(path.join(__dirname, 'views/error404.html'));
}


function errorHandler(err: express.Errback, req: express.Request, res: express.Response, next: express.NextFunction) {
  const ts = new Date().toLocaleString();
  debug.severe('Error %s\n%e', ts, err);
  res.status(500).render('error500.pug',
    {
      time: ts,
      href: 'mailto:greflm13@htl-kaindorf.ac.at?subject=Füttr server failed ' + ts,
      serveradmin: 'Florian Greistorfer',
    });
}


function getFromJava(res: express.Response, path: string) {
  http.get({ port: 666, host: 'localhost', path: '/' + path }, (resp) => {
    let data = '';

    resp.on('data', (chunk) => {
      data += chunk;
    });

    resp.on('end', () => {
      try {
        res.json(JSON.parse(data));
      } catch (err) {
        debug.severe(err);
      }
    });

  }).on("error", (err) => {
    debug.severe(err);
  });
}


function callMeMaybe(req: express.Request, res: express.Response, next: express.NextFunction) {
  switch (req.query.q) {
    case 'warnings': {
      getFromJava(res, 'warnings');
      break;
    }

    case 'errors': {
      getFromJava(res, 'errors');
      break;
    }

    case 'times': {
      getFromJava(res, 'times');
      break;
    }

    case 'status': {
      getFromJava(res, 'status');
      break;
    }

    case 'info': {
      getFromJava(res, 'info');
      break;
    }

    case 'positions': {
      getFromJava(res, 'positions');
      break;
    }

    default: { error404Handler(req, res, next); }
  }
}

function logger(req: express.Request, res: express.Response, next: express.NextFunction) {
  const clientSocket = req.socket.remoteAddress + ':' + req.socket.remotePort;
  debug.info(req.method, req.url, clientSocket);
  next();
}