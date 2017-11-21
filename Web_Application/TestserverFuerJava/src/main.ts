import * as express from 'express';
import * as path from 'path';
import * as bodyparser from 'body-parser';

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
serverApp.use(bodyparser.json());
serverApp.set('views', path.join(__dirname, '/views'));
const pugEngine = serverApp.set('view engine', 'pug');
pugEngine.locals.pretty = true;

serverApp.use(logger);
serverApp.use('/node_modules', express.static(path.join(__dirname, '../node_modules')));
serverApp.get('/put', (req, res) => { res.sendFile(path.join(__dirname, '../src/views/put.html')); });
serverApp.get('/api/callMeMaybe', callMeMaybe);
serverApp.post('/api/putMeHere', putMeHere);
serverApp.get('**', (req, res) => { res.redirect('/api/callMeMaybe') });
serverApp.use(error404Handler);
serverApp.use(errorHandler);

const port = 80;
const server = http.createServer(serverApp).listen(port);
debug.info('Server running on port ' + port);



function error404Handler(req: express.Request, res: express.Response, next: express.NextFunction) {
  const clientSocket = req.socket.remoteAddress + ':' + req.socket.remotePort;
  debug.warn('Error 404 for %s %s from %s', req.method, req.url, clientSocket);
  res.status(404).sendFile(path.join(__dirname, '../src/views/error404.html'));
}


function errorHandler(err: express.Errback, req: express.Request, res: express.Response, next: express.NextFunction) {
  const ts = Date.now().toLocaleString();
  debug.severe('Error %s\n%e', ts, err);
  res.status(500).render('error500.pug',
    {
      time: ts,
      href: 'mailto:greflm13@htl-kaindorf.ac.at?subject=TestserverFuerJava failed ' + ts,
      serveradmin: 'Florian Greistorfer',
    });
}


function getToJava(path: string, data: string) {
  const options = {
    host: 'localhost',
    port: 666,
    path: path,
    method: 'PUT'
  };

  const req = http.request(options, function (res) { res.on('data', function () { }); });

  req.on('error', function (err) {
    debug.severe(err);
  });

  req.write(data);
  req.end();
}


function putMeHere(req: express.Request, res: express.Response, next: express.NextFunction) {
  switch (req.query.q) {
    case 'times': {
      getToJava('/putTimes', '{"time1":"11:11","time2":"12:12","time3":"13:13","time4":"","time1_active":true,"time2_active":true,"time3_active":true,"time4_active":false}');
      break;
    }

    case 'ackErr': {
      getToJava('/ackErr', '{"id":12}');
      break;
    }

    case 'ackWarn': {
      getToJava('/ackWarn', '{"id":13}');
      break;
    }

    default: { error404Handler(req, res, next); }
  }
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