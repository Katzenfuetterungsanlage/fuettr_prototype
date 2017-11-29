import * as express from 'express';
import * as path from 'path';
import * as bodyparser from 'body-parser';
import * as debugsx from 'debug-sx';

import * as http from 'http';
import * as child from 'child_process';
import * as fs from 'fs';

process.env['DEBUG'] = '*';
process.env['DEBUG_COLORS'] = "true";
process.env['DEBUG_STREAM'] = "stdout";
let date = new Date();
const debug: debugsx.IFullLogger = debugsx.createFullLogger('main');
let consolelogger: debugsx.IHandler = debugsx.createConsoleHandler('stdout', "*", "-*", [
  { level: /INFO*/, color: "cyan", inverse: true },
  { level: /FINE*/, color: 'white', inverse: true },
  { level: /SEVERE*/, color: 'red', inverse: true },
  { level: "ERR", color: "red", inverse: true },
  { level: 'WARN', color: 'magenta', inverse: true },
]);
let filelogger: debugsx.IHandler = debugsx.createFileHandler(
  '/var/log/fuettr/' + date.getFullYear() + '-' + date.getUTCMonth() + '-' + date.getUTCDay() + '_' + date.getUTCHours() + '-' + date.getUTCMinutes() + '-' + date.getUTCSeconds() + '.log',
  "*",
  "-*",
  [
    { level: /INFO*/, color: "cyan", inverse: true },
    { level: /FINE*/, color: 'white', inverse: true },
    { level: /SEVERE*/, color: 'red', inverse: true },
    { level: "ERR", color: "red", inverse: true },
    { level: 'WARN', color: 'magenta', inverse: true },
  ]);

debugsx.addHandler(consolelogger, filelogger);

const app = express();
app.use(bodyparser.json());
app.use(bodyparser.urlencoded());
app.set('views', path.join(__dirname, '/views'));
const pugEngine = app.set('view engine', 'pug');
pugEngine.locals.pretty = true;

app.use(logger);
app.use(express.static(path.join(__dirname, '../public')));
app.use('/assets', express.static(path.join(__dirname, '../../ng2/dist/assets')));
app.use('/ng2', express.static(path.join(__dirname, '../../ng2')));
app.use('/node_modules', express.static(path.join(__dirname, '../node_modules')));
app.get('/inline.bundle.js', (req, res) => { res.sendFile(path.join(__dirname, '../../ng2/dist/inline.bundle.js')); });
app.get('/main.bundle.js', (req, res) => { res.sendFile(path.join(__dirname, '../../ng2/dist/main.bundle.js')); });
app.get('/polyfills.bundle.js', (req, res) => { res.sendFile(path.join(__dirname, '../../ng2/dist/polyfills.bundle.js')); });
app.get('/styles.bundle.js', (req, res) => { res.sendFile(path.join(__dirname, '../../ng2/dist/styles.bundle.js')); });
app.get('/vendor.bundle.js', (req, res) => { res.sendFile(path.join(__dirname, '../../ng2/dist/vendor.bundle.js')); });
app.get('/styles.css', (req, res) => { res.sendFile(path.join(__dirname, '../../ng2/src/styles.css')); });
app.get('/bootstrap.css', (req, res) => { res.sendFile(path.join(__dirname, '../../ng2/src/bootstrap.css')); });
app.put('/api/putMeHere', putMeHere);
app.post('/login', login);
app.get('/api/callMeMaybe', callMeMaybe);
app.get('/api/getUpdate', update);
app.get('/api/shutdown', shutdown);
app.get('/api/ip', getIp);
app.get('/api/extensions', (req, res) => { res.sendFile(path.join(__dirname, 'views/README.html')); });
app.get('/api/version', (req, res) => { res.sendFile(path.join(__dirname, '../../../../version.json')); });
app.get('/api/face', (req, res) => { res.sendFile(path.join(__dirname, 'views/face.html')); });
app.get('/login', isLoggedIn);
app.get('**', (req, res) => { res.redirect('/login'); });
app.use(error404Handler);
app.use(errorHandler);

const port = 17325;
const server = http.createServer(app).listen(port);
debug.info('Server running on port ' + port);
const storedpass = '0812';
const storeduser = 'mona';
let jsonToken = false;


function isLoggedIn(req: express.Request, res: express.Response, next: express.NextFunction) {
  if (jsonToken) {
    app.get('**', (req, res) => { res.sendFile(path.join(__dirname, '../../ng2/dist/index.html')); });
  }
  res.sendFile(path.join(__dirname, 'views/login-form.html'));
}


function login(req: express.Request, res: express.Response, next: express.NextFunction) {
  const userpass = req.body.password;
  const username = req.body.user;
  if (userpass === storedpass && username === storeduser) {
    jsonToken = true;
    setTimeout(() => { jsonToken = false; debug.fine('User logged out.') }, 60000);
    res.sendFile(path.join(__dirname, '../../ng2/dist/index.html'));
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

    default: { error404Handler(req, res, next); }
  }
}

function getToJava(path: string, data: string) {
  const options = {
    host: 'localhost',
    port: 666,
    path: path,
    method: 'PUT'
  };

  const req = http.request(options, function (res) { res.on('data', function () { }); });

  req.on('error', function (error) {
    debug.warn(error.message);
  });

  req.write(data);
  req.end();
}


function putMeHere(req: express.Request, res: express.Response, next: express.NextFunction) {
  switch (req.query.q) {
    case 'times': {
      getToJava('/putTimes', JSON.stringify(req.body));

      fs.writeFileSync('testfiles/times.json', JSON.stringify(req.body));
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

    default: { error404Handler(req, res, next); }
  }
}


function update(req: express.Request, res: express.Response, next: express.NextFunction) {
  res.sendFile(path.join(__dirname, 'views/update.html'))
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
  http.get({ port: 80, host: 'api.ipify.org', path: '/?format=json' }, (resp) => {
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


function logger(req: express.Request, res: express.Response, next: express.NextFunction) {
  const clientSocket = req.socket.remoteAddress + ':' + req.socket.remotePort;
  debug.info(req.method, req.url, clientSocket);
  next();
}