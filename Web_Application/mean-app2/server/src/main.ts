
// import of additional modules (npm install ...)
import * as express from 'express';
import * as path from 'path';

// import of Node.js modules
import * as http from 'http';
import * as child from 'child_process';

// logging with debug-sx/debug
process.env['DEBUG'] = '*';
import * as debugsx from 'debug-sx';
const debug: debugsx.ISimpleLogger = debugsx.createSimpleLogger('main');

// web-server
const serverApp = express();
serverApp.set('views', path.join(__dirname, '/views'));
const pugEngine = serverApp.set('view engine', 'pug');
pugEngine.locals.pretty = true;

// middleware for web-server
serverApp.use(requestHandler);
serverApp.use(express.static(path.join(__dirname, '../public')));
serverApp.use('/node_modules', express.static(path.join(__dirname, '../../ng2/node_modules')));
serverApp.use(express.static(path.join(__dirname, '../../ng2/dist')));
serverApp.get('/error', handleGetError);
serverApp.get('/api/getUpdate', update);
serverApp.get('/api/version', (req, res) => {
  res.sendFile(path.join(__dirname, '../../../../version.json'))
});
serverApp.get('/api/extensions', (req, res) => {
  res.sendFile(path.join(__dirname, 'views/README.html'))
});
serverApp.get('*', (req, res) => {
  res.sendFile(path.join(__dirname, '../../ng2/dist/index.html'));
});
serverApp.use(error404Handler);
serverApp.use(errorHandler);

// start of application
const port = 80;
const server = http.createServer(serverApp).listen(port);
debug.info('Server running on port ' + port);


// ***************************************************************************
// Functions
// ***************************************************************************

function requestHandler(req: express.Request, res: express.Response, next: express.NextFunction) {
  const clientSocket = req.socket.remoteAddress + ':' + req.socket.remotePort;
  debug.info('%s %s from %s', req.method, req.url, clientSocket);
  if (req.method === 'GET' && req.url === '/') {
    res.sendFile(path.join(__dirname, '../../ng2/dist/index.html'));
  } else {
    next();
  }
}

function handleGetError() {
  throw new Error('This simulates an exception....');
}


function error404Handler(req: express.Request, res: express.Response, next: express.NextFunction) {
  const clientSocket = req.socket.remoteAddress + ':' + req.socket.remotePort;
  debug.warn('Error 404 for %s %s from %s', req.method, req.url, clientSocket);
  res.status(404).render('error404.pug');
}


function errorHandler(err: express.Errback, req: express.Request, res: express.Response, next: express.NextFunction) {
  const ts = new Date().toLocaleString();
  debug.warn('Error %s\n%e', ts, err);
  res.status(500).render('error500.pug',
    {
      time: ts,
      href: 'mailto:greflm13@htl-kaindorf.ac.at?subject=Füttr server failed ' + ts,
      serveradmin: 'Florian Greistorfer'
    });
}

function update() {
  child.exec(`cd /home/pi/git/fuettr_prototype && sudo git pull &&
  sudo rsync -aP /home/pi/git/fuettr_prototype/rc.local /etc/rc.local &&
  sudo reboot`, (error, stdout, stderr) => {
    if (stdout !== '') {
      debug.info(stdout);
    }
    if (error !== null) {
      debug.warn(error);
    }
  });
}



