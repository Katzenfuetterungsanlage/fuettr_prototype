"use strict";
exports.__esModule = true;
var express = require("express");
var path = require("path");
var http = require("http");
process.env['DEBUG'] = '*';
process.env['DEBUG_COLORS'] = "true";
process.env['DEBUG_STREAM'] = "stdout";
var debugsx = require("debug-sx");
var debug = debugsx.createFullLogger('main');
var consolelogger = debugsx.createConsoleHandler('stdout', "*");
var date = new Date();
var filelogger = debugsx.createFileHandler('logs/' + date.getFullYear() + '-' + date.getUTCMonth() + '-' + date.getUTCDay() + '_' + date.getUTCHours() + '-' + date.getUTCMinutes() + '-' + date.getUTCSeconds() + '.log');
debugsx.addHandler(consolelogger, filelogger);
var serverApp = express();
serverApp.set('views', path.join(__dirname, '/views'));
var pugEngine = serverApp.set('view engine', 'pug');
pugEngine.locals.pretty = true;
serverApp.use(logger);
serverApp.get('/api/callMeMaybe', callMeMaybe);
serverApp.get('**', function (req, res) { res.redirect('/api/callMeMaybe'); });
serverApp.use(error404Handler);
serverApp.use(errorHandler);
var port = 80;
var server = http.createServer(serverApp).listen(port);
debug.info('Server running on port ' + port);
function error404Handler(req, res, next) {
    var clientSocket = req.socket.remoteAddress + ':' + req.socket.remotePort;
    debug.warn('Error 404 for %s %s from %s', req.method, req.url, clientSocket);
    res.status(404).sendFile(path.join(__dirname, 'views/error404.html'));
}
function errorHandler(err, req, res, next) {
    var ts = new Date().toLocaleString();
    debug.severe('Error %s\n%e', ts, err);
    res.status(500).render('error500.pug', {
        time: ts,
        href: 'mailto:greflm13@htl-kaindorf.ac.at?subject=Füttr server failed ' + ts,
        serveradmin: 'Florian Greistorfer'
    });
}
function getFromJava(res, path) {
    http.get({ port: 666, host: 'localhost', path: '/' + path }, function (resp) {
        var data = '';
        resp.on('data', function (chunk) {
            data += chunk;
        });
        resp.on('end', function () {
            try {
                res.json(JSON.parse(data));
            }
            catch (err) {
                debug.severe(err);
            }
        });
    }).on("error", function (err) {
        debug.severe(err);
    });
}
function callMeMaybe(req, res, next) {
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
        default: {
            error404Handler(req, res, next);
        }
    }
}
function logger(req, res, next) {
    var clientSocket = req.socket.remoteAddress + ':' + req.socket.remotePort;
    debug.info(req.method, req.url, clientSocket);
    next();
}

//# sourceMappingURL=main.js.map
