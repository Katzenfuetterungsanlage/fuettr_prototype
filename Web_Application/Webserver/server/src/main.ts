import * as express from 'express';
import * as path from 'path';
import * as bodyparser from 'body-parser';
import * as debugsx from 'debug-sx';

import * as http from 'http';
import * as https from 'https';
import * as child from 'child_process';
import * as fs from 'fs';

process.env['DEBUG'] = '*';
process.env['DEBUG_COLORS'] = 'true';
process.env['DEBUG_STREAM'] = 'stdout';
const date = new Date().toISOString();
const debug: debugsx.IFullLogger = debugsx.createFullLogger('main');
const consolelogger: debugsx.IHandler = debugsx.createConsoleHandler('stdout', '*', '-*', [
  { level: /INFO*/, color: 'cyan', inverse: true },
  { level: /FINE*/, color: 'white', inverse: true },
  { level: /SEVERE*/, color: 'red', inverse: true },
  { level: 'ERR', color: 'red', inverse: true },
  { level: 'WARN', color: 'magenta', inverse: true }
]);
const filelogger: debugsx.IHandler = debugsx.createFileHandler('/var/log/fuettr/' + date + '.log', '*', '-*', [
  { level: /INFO*/, color: 'cyan', inverse: true },
  { level: /FINE*/, color: 'white', inverse: true },
  { level: /SEVERE*/, color: 'red', inverse: true },
  { level: 'ERR', color: 'red', inverse: true },
  { level: 'WARN', color: 'magenta', inverse: true }
]);
debugsx.addHandler(consolelogger, filelogger);

const app = express();
app.use(bodyparser.json());
app.use(bodyparser.urlencoded({ extended: true }));
app.set('views', path.join(__dirname, '/views'));
const pugEngine = app.set('view engine', 'pug');
pugEngine.locals.pretty = true;

app.use(logger);
app.use(express.static(path.join(__dirname, '../public')));
app.use('/assets', express.static(path.join(__dirname, '../../ng2/dist/assets')));
app.use('/ng2', express.static(path.join(__dirname, '../../ng2/dist')));
app.use('/node_modules', express.static(path.join(__dirname, '../node_modules')));
app.post('/api/putMeHere', putMeHere);
app.post('/login', login);
app.get('/api/callMeMaybe', callMeMaybe);
app.get('/api/getUpdate', update);
app.get('/api/shutdown', shutdown);
app.get('/api/ip', getIp);
app.get('/api/extensions', (req, res) => {
  res.sendFile(path.join(__dirname, 'views/README.html'));
});
app.get('/api/version', (req, res) => {
  res.sendFile(path.join(__dirname, '../../../../version.json'));
});
app.get('/api/face', (req, res) => {
  res.sendFile(path.join(__dirname, 'views/face.html'));
});
app.get('/bootstrap', (req, res) => {
  res.sendFile(path.join(__dirname, '../../ng2/src/bootstrap.css'));
});
app.get('/login', isLoggedIn);
app.get('**', isLoggedIn);
app.use(error404Handler);
app.use(errorHandler);

const port = 17325;
const server = http.createServer(app).listen(port, () => {
  debug.info('Server running on port ' + port);
  server.on('close', () => {
    debug.fine('Server stopped.');
  });
  server.on('err', err => {
    debug.severe(err);
  });
});
const storedpass = 'enter';
const storeduser = 'enter';
let jsonToken = true;

function isLoggedIn(req: express.Request, res: express.Response, next: express.NextFunction) {
  // jsonToken = true;
  // if (jsonToken) {
  //   app.get('**', (reqg, resg) => {
      res.sendFile(path.join(__dirname, 'views/index.html'));
  //   });
  // }
  // res.sendFile(path.join(__dirname, 'views/login-form.html'));
}

function login(req: express.Request, res: express.Response, next: express.NextFunction) {
  const userpass = req.body.password;
  const username = req.body.user;
  if (userpass === storedpass && username === storeduser) {
    jsonToken = true;
    setTimeout(() => {
      jsonToken = false;
      debug.fine('User logged out.');
    }, 60000);
    res.sendFile(path.join(__dirname, 'views/index.html'));
  } else {
    res.status(401).sendFile(path.join(__dirname, 'views/login-form-error.html'));
  }
}

function error404Handler(req: express.Request, res: express.Response, next: express.NextFunction) {
  const clientSocket = req.socket.remoteAddress + ':' + req.socket.remotePort;
  debug.warn('Error 404 for %s %s from %s', req.method, req.url, clientSocket);
  res.status(404).sendFile(path.join(__dirname, 'views/error404.html'));
}

function errorHandler(err: express.Errback, req: express.Request, res: express.Response, next: express.NextFunction) {
  const ts = new Date().toLocaleString();
  debug.severe('Error %s\n%e', ts, err);
  res.status(500).render('error500.pug', {
    time: ts,
    err: err,
    href: 'mailto:greflm13@htl-kaindorf.ac.at?subject=Füttr server failed ' + ts,
    serveradmin: 'Florian Greistorfer'
  });
}

function getFromJava(res: express.Response, path: string) {
  http
    .get({ port: 666, host: 'localhost', path: '/' + path }, resp => {
      let data = '';

      resp.on('data', chunk => {
        data += chunk;
      });

      resp.on('end', () => {
        try {
          res.json(JSON.parse(data));
        } catch (err) {
          debug.severe(err);
        }
      });
    })
    .on('error', err => {
      debug.severe(err);
    });
}

function callMeMaybe(req: express.Request, res: express.Response, next: express.NextFunction) {
  switch (req.query.q) {
    case 'warnings': {
      res.sendFile(path.join(__dirname, '../testfiles/warnings.json'));
      // getFromJava(res, 'warnings');
      break;
    }

    case 'errors': {
      res.sendFile(path.join(__dirname, '../testfiles/errors.json'));
      // getFromJava(res, 'errors');
      break;
    }

    case 'times': {
      res.sendFile(path.join(__dirname, '../testfiles/times.json'));
      // getFromJava(res, 'times');
      break;
    }

    case 'status': {
      res.sendFile(path.join(__dirname, '../testfiles/status.json'));
      // getFromJava(res, 'status');
      break;
    }

    case 'info': {
      res.sendFile(path.join(__dirname, '../testfiles/info.json'));
      // getFromJava(res, 'info');
      break;
    }

    case 'positions': {
      res.sendFile(path.join(__dirname, '../testfiles/positions.json'));
      // getFromJava(res, 'positions');
      break;
    }

    default: {
      error404Handler(req, res, next);
    }
  }
}

function getToJava(path: string, data: string): string {
  const options = {
    host: 'localhost',
    port: 666,
    path: path,
    method: 'PUT'
  };

  let back: string;

  const req = http.request(options, res => {
    res.on('data', chunk => {
      back += chunk;
    });
  });

  req.on('error', error => {
    debug.warn(error.message);
  });

  req.write(data);
  req.end();
  return back;
}

function putMeHere(req: express.Request, res: express.Response, next: express.NextFunction) {
  const OK = {
    ok: 'ok'
  };
  switch (req.query.q) {
    case 'times': {
      // getToJava('/putTimes', JSON.stringify(req.body));

      fs.writeFileSync(path.join(__dirname, '../testfiles/times.json'), JSON.stringify(req.body));
      res.sendFile(path.join(__dirname, '../testfiles/times.json'));
      break;
    }

    case 'ackErr': {
      getToJava('/ackErr', JSON.stringify(req.body));
      break;
    }

    case 'ackWarn': {
      getToJava('/ackWarn', JSON.stringify(req.body));
      break;
    }

    default: {
      error404Handler(req, res, next);
    }
  }
}

function update(req: express.Request, res: express.Response, next: express.NextFunction) {
  res.sendFile(path.join(__dirname, 'views/update.html'));
  child.exec(`cd .. && git reset --hard && git pull && sudo npm-install-missing`, (error, stdout, stderr) => {
    if (stdout !== '') {
      debug.info(stdout);
    }
    if (error !== null) {
      debug.warn(error);
    }
    child.exec(`cd ../ng2 && sudo npm-install-missing`, (error, stdout, stderr) => {
      if (stdout !== '') {
        debug.info(stdout);
      }
      if (error !== null) {
        debug.warn(error);
      }
      child.exec(`sudo reboot`, (error, stdout, stderr) => {
        if (stdout !== '') {
          debug.info(stdout);
        }
        if (error !== null) {
          debug.warn(error);
        }
      });
    });
  });
}

function shutdown() {
  child.exec('sudo poweroff', error => {
    debug.warn(error);
  });
}

function getIp(req: express.Request, res: express.Response, next: express.NextFunction) {
  http
    .get({ port: 80, host: 'api.ipify.org', path: '/?format=json' }, resp => {
      let data = '';

      resp.on('data', chunk => {
        data += chunk;
      });

      resp.on('end', () => {
        try {
          res.json(JSON.parse(data));
        } catch (err) {
          debug.severe(err);
        }
      });
    })
    .on('error', err => {
      debug.severe(err);
    });
}

function logger(req: express.Request, res: express.Response, next: express.NextFunction) {
  const clientSocket = req.socket.remoteAddress + ':' + req.socket.remotePort;
  debug.info(req.method, req.url, clientSocket);
  next();
}
