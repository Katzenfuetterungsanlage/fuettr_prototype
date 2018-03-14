import * as fs from 'fs';
import * as path from 'path';

enum Color {Red, Green, Blue}

fs.writeFileSync(path.join(__dirname, '../test.json'), JSON.stringify(Color));
