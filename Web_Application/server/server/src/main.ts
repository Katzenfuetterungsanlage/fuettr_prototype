import * as express from 'express';
import * as http from 'http';
import * as path from 'path';
import * as debugsx from 'debug-sx';
const debug: debugsx.ISimpleLogger = debugsx.createSimpleLogger('webserver');

const server_app = express();
server_app.set('views', path.join(__dirname, '/views'));
const pugEngine = server_app.set('view  engine', 'pug');
pugEngine.locals.pretty = true;


// middleware
server_app.use(requestHandler);
server_app.use(express.static(path.join(__dirname, 'public')));
server_app.use('/node_modules', express.static(path.join(__dirname, '../node_modules')));
server_app.use('/ng2', express.static(path.join(__dirname, '../../ng2/dist')));
server_app.use(requestHandler2);
server_app.get('/status', handleStatus);
server_app.use(error404Handler);
server_app.use(errorHandler);


// start of application
const server = http.createServer(server_app).listen(8080);
debug.info('Server on port 8080 running');

function requestHandler(req: express.Request, res: express.Response, next: express.NextFunction) {
    debug.info('%s %s', req.method, req.url);
    ( < any > req).user = {
        name: 'Mustermann'
    };
    if (req.method === 'GET' && (req.url === '/' || req.url === '/index.html')) {
        res.render('ngmain.pug');
        return;
    };
    if (req.method === 'GET' && req.url === '/user'){
        res.json((<any>req).user)
        return;
    }
    next();
}

function requestHandler2(req: express.Request, res: express.Response, next: express.NextFunction) {
    if (req.url === '/error') {
        throw new Error('Testfehler');
    }
    next();
}


function handleStatus(req: RequestWithUser, res: express.Response, next: express.NextFunction) {
    // res.status(200).send('<h1>Under construction ' + req.user.name + '</h1>');
    res.render('status.pug', {
        name: req.user.name
    });
}

interface RequestWithUser extends express.Request {
    user: {
        name: string
    };
}

function error404Handler(req: RequestWithUser, res: express.Response, next: express.NextFunction) {
    res.status(404).render('error404.pug');
}

function errorHandler(err: express.Errback, req: express.Request, res: express.Response, next: express.NextFunction) {
    const ts = new Date().toISOString();
    debug.warn('Error %s\n%e', ts, err);
    res.status(500).render('error500.pug', {
        time: ts,
        href: 'mailto:maxi@hotmail.com',
        serveradmin: 'Maxi Maier'
    });
}