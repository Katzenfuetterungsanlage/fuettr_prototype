import * as express from 'express';
import * as fs from 'fs';
import * as path from 'path';
import * as bodyparser from 'body-parser';
import * as http from 'http';

let serialnumber: number;
const app = express();
app.use(bodyparser.json());
app.post('/serialnumber', (req, res) => {
  console.log(req.body.mac);
  let numbers = fs.readFileSync(path.join(__dirname, '../serialnumbers.num'));
  let number = numbers.findIndex(req.body.mac);
});
