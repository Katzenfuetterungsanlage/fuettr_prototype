"use strict";
exports.__esModule = true;
var express = require("express");
var fs = require("fs");
var path = require("path");
var bodyparser = require("body-parser");
var http = require("http");
var serialnumber = 0;
var serialnumbers;
var app = express();
app.use(bodyparser.json());
app.post('/serialnumber', function (req, res) {
    console.log(req.body.mac);
    var file = fs.readFileSync(path.join(__dirname, '../serialnumbers.json')).toJSON();
    console.log(JSON.stringify(file));
    serialnumber++;
    console.log(serialnumber);
    res.send(serialnumber.toString());
});
var port = 2525;
var server = http.createServer(app).listen(port, function () {
    console.log('Server running on port ' + port);
    server.on('close', function () {
        console.log('Server stopped.');
    });
    server.on('err', function (err) {
        console.log(err);
    });
});

//# sourceMappingURL=main.js.map
