"use strict";
exports.__esModule = true;
var fs = require("fs");
var path = require("path");
var Color;
(function (Color) {
    Color[Color["Red"] = 0] = "Red";
    Color[Color["Green"] = 1] = "Green";
    Color[Color["Blue"] = 2] = "Blue";
})(Color || (Color = {}));
fs.writeFileSync(path.join(__dirname, '../test.json'), JSON.stringify(Color));

//# sourceMappingURL=test.js.map
