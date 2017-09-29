# Login and Logout improvements

This step continues **[step10-modal-dialog](../../blob/step10-modal-dialog/README.md)**.

## Goals

#### Server side (Node.js express)

* How to support /login resource with non angular page.
* How to use modal login dialog in all other cases automatically.
* How to transport remote token to the Angular application.
* How to handle logout in order to exit from Angular application.

#### Client side (Angular v4)

* How to take over remote token on startup
* How to open modal login dialog authomatically on startup


## Prerequisites

Install [mongodb software package][mongodb-install].

#### From scratch ...

Execute in shell:

```
git clone -b step11-non-ngx-login https://github.com/ManfredSteiner/webserver-template
cd webserver-template/ngx
npm install
npm run build
cd ../server
npm install
npm start
```

#### Alternative: continue from branch step10 ...

Install the module ...

```
cd ngx
npm install font-awesome --save
cd ..
```

## Usage

The [ServerService](ngx/src/app/services/server.service.ts) checks if Angular application is running 
in development mode or in production mode. The mode descides which server host is used for requests.

#### Development mode

When **ng serve** is called, the application is running in development mode. This means
that the server must be startet as seperate application on same host. All server requests
will be made to `localhost:8080` instead using the socket of the ng server (port 4200).

```
cd ngx
ng serve
```
```
cd server
npm start
```

Start client in browse with link [http://localhost:4200](http://localhost:4200).

#### Production mode

When server app should also support loading of Angular app, a build of the Angular app 
is needed every time if something changes. Angular application is build in production mode 
(see [package.json](ngx/package.json)).
```
cd ngx
npm run build
```
```
cd server
npm start
```

Start client in browse with link [http://localhost:8080](http://localhost:8080). 
You can also use another host for the client, as long as the server is reachable.



## Additional infos

Additional styles (Bootstrap V4, Font Awesome) are now imported inside [ngx/src/styles.css](ngx/src/styles.css).

The usage depends on Angular mode:

* Productive mode:  
  Content in file *ngx/dist/styles.bundle.css*, used in file [server/src/views/ngmain.pug](server/src/views/ngmain.pug)
* Development mode:  
  Content in resource *styles.bundle.js*, added automatically to file [ngx/src/index.html](ngx/src/index.html) when 
  executing `ng serve` (checkable in browser debugging mode).


[mongodb-install]: https://docs.mongodb.com/manual/tutorial/install-mongodb-on-ubuntu/
