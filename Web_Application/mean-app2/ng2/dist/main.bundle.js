webpackJsonp(["main"],{

/***/ "../../../../../src/$$_gendir lazy recursive":
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "../../../../../src/$$_gendir lazy recursive";

/***/ }),

/***/ "../../../../../src/app/app-routing.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppRoutingModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__control_component__ = __webpack_require__("../../../../../src/app/control.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__home_component__ = __webpack_require__("../../../../../src/app/home.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__feed_component__ = __webpack_require__("../../../../../src/app/feed.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__info_component__ = __webpack_require__("../../../../../src/app/info.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__update_component__ = __webpack_require__("../../../../../src/app/update.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};







var routes = [
    { path: 'home', component: __WEBPACK_IMPORTED_MODULE_3__home_component__["a" /* HomeComponent */] },
    { path: 'control', component: __WEBPACK_IMPORTED_MODULE_2__control_component__["a" /* ControlComponent */] },
    { path: 'feed', component: __WEBPACK_IMPORTED_MODULE_4__feed_component__["a" /* FeedComponent */] },
    { path: 'info', component: __WEBPACK_IMPORTED_MODULE_5__info_component__["a" /* InfoComponent */] },
    { path: 'update', component: __WEBPACK_IMPORTED_MODULE_6__update_component__["a" /* UpdateComponent */] },
    { path: '**', redirectTo: '/home', pathMatch: 'full' },
];
var AppRoutingModule = (function () {
    function AppRoutingModule() {
    }
    return AppRoutingModule;
}());
AppRoutingModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["M" /* NgModule */])({
        imports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["a" /* RouterModule */].forRoot(routes)],
        exports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["a" /* RouterModule */]]
    })
], AppRoutingModule);

//# sourceMappingURL=app-routing.module.js.map

/***/ }),

/***/ "../../../../../src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<nav class=\"navbar fixed-top navbar-toggleable-sm navbar-inverse\" style=\"background-color: #191816;\">\r\n    <button type=\"button\" class=\"navbar-toggler navbar-toggler-right\" data-toggle=\"collapse\" data-target=\"#Navbar\" aria-controls=\"Navbar\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n        <span class=\"navbar-toggler-icon\"></span>\r\n    </button>\r\n    <a class=\"navbar-brand\" routerLink=\"/home\"><img alt=\"Brand\" src=\"../favicon.ico\" width=\"26\"></a>\r\n\r\n\r\n    <div class=\"collapse navbar-collapse\" id=\"Navbar\">\r\n        <ul class=\"navbar-nav mr-auto\">\r\n            <li class=\"nav-item\"><a class=\"nav-link\" routerLink=\"/home\">Home</a></li>\r\n            <li class=\"nav-item\"><a class=\"nav-link\" routerLink=\"/feed\">Fütterung</a></li>\r\n            <li class=\"nav-item\"><a class=\"nav-link\" routerLink=\"/control\">Steuerung</a></li>\r\n            <li class=\"nav-item dropdown\">\r\n                <a class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" id=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">Einstellungen</a>\r\n                <div class=\"dropdown-menu\" aria-labelledby=\"dropdown\">\r\n                    <a class=\"dropdown-item\" routerLink=\"/info\">Geräteinfo</a>\r\n                    <a class=\"dropdown-item\" routerLink=\"/update\">Update</a>\r\n                </div>\r\n            </li>\r\n        </ul>\r\n        <span class=\"nav-link\" style=\"color:#c6bfb9\">{{Time}}</span>\r\n    </div>\r\n</nav>\r\n<p><br><br></p>\r\n<router-outlet></router-outlet>"

/***/ }),

/***/ "../../../../../src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var AppComponent = (function () {
    function AppComponent() {
        this.intervalID = setInterval(this.refreshTime.bind(this), 100);
    }
    AppComponent.prototype.refreshTime = function () {
        this.Time = new Date().toLocaleTimeString();
    };
    return AppComponent;
}());
AppComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'app-root',
        template: __webpack_require__("../../../../../src/app/app.component.html")
    }),
    __metadata("design:paramtypes", [])
], AppComponent);

//# sourceMappingURL=app.component.js.map

/***/ }),

/***/ "../../../../../src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__("../../../http/@angular/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_platform_browser__ = __webpack_require__("../../../platform-browser/@angular/platform-browser.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__app_routing_module__ = __webpack_require__("../../../../../src/app/app-routing.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__app_component__ = __webpack_require__("../../../../../src/app/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__control_component__ = __webpack_require__("../../../../../src/app/control.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__feed_component__ = __webpack_require__("../../../../../src/app/feed.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__home_component__ = __webpack_require__("../../../../../src/app/home.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__info_component__ = __webpack_require__("../../../../../src/app/info.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__times_service__ = __webpack_require__("../../../../../src/app/times.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__update_component__ = __webpack_require__("../../../../../src/app/update.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};











var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["M" /* NgModule */])({
        declarations: [
            __WEBPACK_IMPORTED_MODULE_4__app_component__["a" /* AppComponent */],
            __WEBPACK_IMPORTED_MODULE_5__control_component__["a" /* ControlComponent */],
            __WEBPACK_IMPORTED_MODULE_7__home_component__["a" /* HomeComponent */],
            __WEBPACK_IMPORTED_MODULE_6__feed_component__["a" /* FeedComponent */],
            __WEBPACK_IMPORTED_MODULE_8__info_component__["a" /* InfoComponent */],
            __WEBPACK_IMPORTED_MODULE_10__update_component__["a" /* UpdateComponent */]
        ],
        imports: [__WEBPACK_IMPORTED_MODULE_2__angular_platform_browser__["a" /* BrowserModule */], __WEBPACK_IMPORTED_MODULE_3__app_routing_module__["a" /* AppRoutingModule */], __WEBPACK_IMPORTED_MODULE_1__angular_http__["b" /* HttpModule */]],
        providers: [__WEBPACK_IMPORTED_MODULE_9__times_service__["a" /* TimesService */]],
        bootstrap: [__WEBPACK_IMPORTED_MODULE_4__app_component__["a" /* AppComponent */]]
    })
], AppModule);

//# sourceMappingURL=app.module.js.map

/***/ }),

/***/ "../../../../../src/app/control.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n    <h1>Steuerung</h1>\r\n    <!-- <label>Click me: <input type=\"checkbox\" ng-model=\"checked\" ng-init=\"checked=true\" /></label><br/> Show when checked:\r\n    <span ng-if=\"checked\">\r\n      This is removed when the checkbox is unchecked.\r\n    </span> -->\r\n    <div class=\"form-check container-fluid\">\r\n        <label class=\"form-check-label\">\r\n    <input type=\"checkbox\" ng-model=\"button-on\" ng-init=\"button-on=true\" class=\"form-check-input\"> manuelle Steuerung\r\n  </label>\r\n    </div>\r\n    <div class=\"container-fluid\">\r\n        <div class=\"row\">\r\n            <div class=\"col-lg-4\">\r\n                <div class=\"container-fluid\">\r\n                    <h3>Zylinder</h3>\r\n                    <button class=\"btn-success\" ng-if=\"button-on\">einfahren</button>\r\n                    <button class=\"btn-danger\">ausfahren</button>\r\n                    <br>\r\n                    <br>\r\n                    <br>\r\n                </div>\r\n                <div class=\"container-fluid\">\r\n                    <h3>Förderband</h3>\r\n                    <button class=\"btn-success\">ein</button>\r\n                    <button class=\"btn-danger\">aus</button>\r\n                    <br>\r\n                    <br>\r\n                    <br>\r\n                </div>\r\n                <div class=\"container-fluid\">\r\n                    <h3>Motor</h3>\r\n                    <button class=\"btn-primary\">links</button>\r\n                    <button class=\"btn-warning\">rechts</button>\r\n                    <br>\r\n                    <br>\r\n                    <br>\r\n                </div>\r\n            </div>\r\n            <div class=\"col-lg-8\">\r\n                <h3>Positions-info</h3>\r\n            </div>\r\n        </div>\r\n    </div>\r\n</div>"

/***/ }),

/***/ "../../../../../src/app/control.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ControlComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var ControlComponent = (function () {
    function ControlComponent() {
    }
    return ControlComponent;
}());
ControlComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'app-control',
        template: __webpack_require__("../../../../../src/app/control.component.html"),
    })
], ControlComponent);

//# sourceMappingURL=control.component.js.map

/***/ }),

/***/ "../../../../../src/app/feed.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n    <button class=\"btn btn-primary btn-lg\"> Hallo</button>\r\n</div>"

/***/ }),

/***/ "../../../../../src/app/feed.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return FeedComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var FeedComponent = (function () {
    function FeedComponent() {
    }
    return FeedComponent;
}());
FeedComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'app-feed',
        template: __webpack_require__("../../../../../src/app/feed.component.html"),
    })
], FeedComponent);

//# sourceMappingURL=feed.component.js.map

/***/ }),

/***/ "../../../../../src/app/home.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n    <div class=\"row\">\r\n        <div class=\"col-lg-8\">\r\n            <div class=\"container-fluid\">\r\n                <div class=\"jumbotron\">\r\n                    <p>\r\n                        {{statusmessage}}\r\n                    </p>\r\n                </div>\r\n                <div class=\"alert alert-warning alert-dismissable fade show\" role=\"alert\">\r\n                    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\r\n            <span aria-hidden=\"true\">&times;</span>\r\n          </button>\r\n                    <strong>Warning! </strong>{{warning_message}}\r\n                </div>\r\n                <div class=\"alert alert-danger alert-dismissable fade show\" role=\"alert\">\r\n                    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\r\n            <span aria-hidden=\"true\">&times;</span>\r\n          </button>\r\n                    <strong>Error! </strong>{{error_message}}\r\n                </div>\r\n            </div>\r\n        </div>\r\n        <div class=\"col-lg-4\">\r\n            <h2 class=\"text-center\">Fütterungszeiten</h2>\r\n            <div class=\"container-fluid\">\r\n                <table class=\"table\">\r\n                    <tbody>\r\n                        <tr>\r\n                            <td class=\"text-right\">\r\n                                <h4>Zeit 1:</h4>\r\n                            </td>\r\n                            <td>\r\n                                <span class=\"btn btn-secondary\">{{time1}}</span>\r\n                            </td>\r\n                        </tr>\r\n                        <tr>\r\n                            <td class=\"text-right\">\r\n                                <h4>Zeit 2:</h4>\r\n                            </td>\r\n                            <td>\r\n                                <span class=\"btn btn-secondary\">{{time2}}</span>\r\n                            </td>\r\n                        </tr>\r\n                        <tr>\r\n                            <td class=\"text-right\">\r\n                                <h4>Zeit 3:</h4>\r\n                            </td>\r\n                            <td>\r\n                                <span class=\"btn btn-secondary\">{{time3}}</span>\r\n                            </td>\r\n                        </tr>\r\n                        <tr>\r\n                            <td class=\"text-right\">\r\n                                <h4>Zeit 4:</h4>\r\n                            </td>\r\n                            <td>\r\n                                <span class=\"btn btn-secondary\">{{time4}}</span>\r\n                            </td>\r\n                        </tr>\r\n                    </tbody>\r\n                </table>\r\n            </div>\r\n        </div>\r\n    </div>\r\n</div>"

/***/ }),

/***/ "../../../../../src/app/home.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return HomeComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__("../../../http/@angular/http.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var HomeComponent = (function () {
    function HomeComponent(http) {
        this.http = http;
        this.statusmessage = "Dummytext: Sunt enim minim cupidatat deserunt ullamco dolore eiusmod\n      fugiat eu quis aliquip mollit labore. Aute fugiat fugiat veniam cupidatat minim est irure\n      est ipsum. Duis exercitation qui quis proident ut exercitation. Ad labore sint ullamco est\n      in proident labore consectetur ea et in nisi. Ullamco magna tempor ipsum occaecat do eu\n      adipisicing. Cillum consequat mollit dolore proident commodo.";
        this.error_message = "This is an errormessage with a very long text, so I can see, that it\n      automatically breaks the line, if it is too long.";
        this.warning_message = 'Some warnings may occure.';
    }
    HomeComponent.prototype.ngOnInit = function () {
        this.time1 = '10:10';
        this.time2 = '11:11';
        this.time3 = '12:12';
        this.time4 = '13:13';
        this.http.get('localhost:8080/info').toPromise()
            .then(function (response) {
            console.log('Super');
        })
            .catch(function (error) {
            if (error instanceof Error) {
                console.log(error);
            }
            else {
                console.log('?');
            }
        });
    };
    return HomeComponent;
}());
HomeComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'app-home',
        template: __webpack_require__("../../../../../src/app/home.component.html"),
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__angular_http__["a" /* Http */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__angular_http__["a" /* Http */]) === "function" && _a || Object])
], HomeComponent);

var _a;
//# sourceMappingURL=home.component.js.map

/***/ }),

/***/ "../../../../../src/app/info.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n    <h1>Geräteinformation</h1>\r\n</div>\r\n<div class=\"jumbotron container-fluid\">\r\n    <div class=\"col-xs-4\">\r\n        <table class=\"table table-hover\">\r\n            <tbody>\r\n                <tr>\r\n                    <td class=\"text-right\">Seriennummer:</td>\r\n                    <td>{{serialnumber}}</td>\r\n                </tr>\r\n                <tr>\r\n                    <td class=\"text-right\">Interner Rechner:</td>\r\n                    <td>{{processor}}</td>\r\n                </tr>\r\n                <tr>\r\n                    <td class=\"text-right\">WLAN Status:</td>\r\n                    <td>{{wlanstate}}</td>\r\n                </tr>\r\n                <tr>\r\n                    <td class=\"text-right\">IP Adresse:</td>\r\n                    <td>{{ipadress}}</td>\r\n                </tr>\r\n                <tr>\r\n                    <td class=\"text-right\">Softwareversion:</td>\r\n                    <td>{{version}}</td>\r\n                </tr>\r\n            </tbody>\r\n        </table>\r\n    </div>\r\n    <div class=\"col-xs-8\">\r\n\r\n    </div>\r\n</div>"

/***/ }),

/***/ "../../../../../src/app/info.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return InfoComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var InfoComponent = (function () {
    function InfoComponent() {
        this.serialnumber = '#000000';
        this.processor = 'Raspberry Pi 3 Model B';
        this.wlanstate = '@TODO';
        this.ipadress = '@TODO';
        this.version = 'alpha@0.0.1';
    }
    return InfoComponent;
}());
InfoComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'app-info',
        template: __webpack_require__("../../../../../src/app/info.component.html")
    })
], InfoComponent);

//# sourceMappingURL=info.component.js.map

/***/ }),

/***/ "../../../../../src/app/times.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TimesService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_rxjs_add_operator_toPromise__ = __webpack_require__("../../../../rxjs/add/operator/toPromise.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_rxjs_add_operator_toPromise___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_rxjs_add_operator_toPromise__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_http__ = __webpack_require__("../../../http/@angular/http.es5.js");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var TimesService = (function () {
    function TimesService(http) {
        this.http = http;
    }
    TimesService.prototype.progress = function () {
        var err = new MyError('test', 100);
        console.log(err);
        this.http.get('localhost:8080/info').toPromise()
            .then(function (response) {
            console.log('Super');
        })
            .catch(function (error) {
            if (error instanceof Error) {
                console.log(error);
            }
            else {
                console.log('?');
            }
        });
        return 0;
    };
    Object.defineProperty(TimesService.prototype, "x", {
        get: function () {
            return this._x;
        },
        set: function (value) {
            this._x = value;
        },
        enumerable: true,
        configurable: true
    });
    return TimesService;
}());
TimesService = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["C" /* Injectable */])(),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_2__angular_http__["a" /* Http */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_http__["a" /* Http */]) === "function" && _a || Object])
], TimesService);

var MyError = (function (_super) {
    __extends(MyError, _super);
    function MyError(message, x) {
        var _this = _super.call(this, message) || this;
        _this.x = x;
        return _this;
    }
    MyError.prototype.toString = function () {
        return this.message + ', x=' + this.x;
    };
    return MyError;
}(Error));
var _a;
//# sourceMappingURL=times.service.js.map

/***/ }),

/***/ "../../../../../src/app/update.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n    <h1>Update</h1>\r\n</div>\r\n<div class=\"container-fluid\">\r\n    <h4>Klick the button to check for updates:</h4><br>\r\n    <button type=\"button\" class=\"btn btn-secondary btn-lg\" data-toggle=\"modal\" data-target=\"#myModal\">Check for updates</button>\r\n</div>\r\n<div id=\"myModal\" class=\"modal fade\" role=\"dialog\">\r\n    <div class=\"modal-dialog\">\r\n\r\n        <div class=\"modal-content\">\r\n            <div class=\"modal-header\">\r\n                <h4 class=\"modal-title\">Update</h4>\r\n                <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n            </div>\r\n            <div class=\"modal-body\">\r\n                <p>Checking for updates...</p>\r\n            </div>\r\n        </div>\r\n\r\n    </div>\r\n</div>"

/***/ }),

/***/ "../../../../../src/app/update.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return UpdateComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var UpdateComponent = (function () {
    function UpdateComponent() {
    }
    return UpdateComponent;
}());
UpdateComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'app-update',
        template: __webpack_require__("../../../../../src/app/update.component.html"),
    })
], UpdateComponent);

//# sourceMappingURL=update.component.js.map

/***/ }),

/***/ "../../../../../src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
// The file contents for the current environment will overwrite these during build.
var environment = {
    production: false
};
//# sourceMappingURL=environment.js.map

/***/ }),

/***/ "../../../../../src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("../../../platform-browser-dynamic/@angular/platform-browser-dynamic.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_app_module__ = __webpack_require__("../../../../../src/app/app.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("../../../../../src/environments/environment.ts");




if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_23" /* enableProdMode */])();
}
Object(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_2__app_app_module__["a" /* AppModule */]);
//# sourceMappingURL=main.js.map

/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("../../../../../src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map