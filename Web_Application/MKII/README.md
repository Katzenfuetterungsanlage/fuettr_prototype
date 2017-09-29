# Server logging and OOP

## Goals

* How to use the logger module [morgan][npm-morgan].
* How to implement the server as object.
* How to use config files with the module [nconf][npm-nconf]
* How to filter [debug-sx][npm-debug-sx] messages.

## Prerequisites

Install the module **morgan** and **nconf**

```
cd server
npm install --save morgan @types/morgan
npm install --save nconf @types/nconf
cd ..
```
Make sure, that the Angular 2+ application bundles are available in subdirectory [ng2/dist](ng2/dist). Use the following command (or keyboard shortcut *CTRL + N* ) to build them:

```
cd ng2
ng build
cd ..
```

## New files

* [server/src/server.ts](server/src/server.ts)
* [server/config.json](server/config.json)

## Modified source files

* [server/src/main.ts](server/src/main.ts)

## Additional infos

* [Node.js File System][nodejs-fs]
* [Node.js Events][nodejs-events]
* [Node.js Networking][nodejs-net]

[npm-morgan]: https://www.npmjs.com/package/morgan
[npm-nconf]: https://www.npmjs.com/package/nconf
[npm-debug-sx]: https://www.npmjs.com/package/debug-sx
[nodejs-fs]: https://nodejs.org/api/fs.html 
[nodejs-events]: https://nodejs.org/api/events.html
[nodejs-net]: https://nodejs.org/api/net.html