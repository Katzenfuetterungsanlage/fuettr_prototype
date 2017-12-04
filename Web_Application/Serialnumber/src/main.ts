import * as express from 'express';
import * as fs from 'fs';
import * as path from 'path';
import * as bodyparser from 'body-parser';
import * as http from 'http';
import * as itf from './serialnumber';

let serialnumber = 0;
let serialnumbers: itf.Serialnumbers;
const app = express();
app.use(bodyparser.json());
app.post('/serialnumber', (req, res) => {
  console.log(req.body.mac);
  let file = fs.readFileSync(path.join(__dirname, '../serialnumbers.json')).toJSON();
  console.log(JSON.stringify(file));
  serialnumber++;
  console.log(serialnumber);
  res.send(serialnumber.toString());
});

const port = 2525;
const server = http.createServer(app).listen(port, () => {
  console.log('Server running on port ' + port);
  server.on('close', () => {
    console.log('Server stopped.');
  });
  server.on('err', err => {
    console.log(err);
  });
});
