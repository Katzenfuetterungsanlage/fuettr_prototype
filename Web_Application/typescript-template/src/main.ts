process.on('unhandledRejection', (reason, p) => {
    console.log(reason);
    console.log(p);
});

import { sprintf } from 'sprintf-js';
import * as fs from 'fs';

class Main {
    calculate(n: number): Promise<number> {
        if (n < 1) {
            return Promise.reject(new Error('wert kleiner 1'));
        }
        return new Promise<number>((resolve, reject) => {
            let rv = 1;
            while (n >= 1) {
                rv = rv * n;
                n--;
            }
            resolve(rv);
        });
    }

    async doSomething(n: number): Promise<number> {
        const x = await this.calculate(n);
        await this.delay(2000);
        return x + 3;
    }

    async delay(n: number): Promise<void> {
        new Promise<void>((resolve, reject) => { setTimeout(() => { resolve() }, n) });
    }
}

const main = new Main();


// calback
fs.writeFile('test.dat', 'servus', (err) => {
    if (err) {
        throw err;
    }
    console.log('Erfolgreich geschrieben');
});

// Promise

const p: Promise<number> = new Promise<number>((resolve, reject) => {
    // throw new Error('I nned attention too');
    try {
        // throw new Error('I need attention');
        resolve(42);
    } catch (err) {
        reject(err)
    }
});

p.then((txt) => {
    console.log(txt);
})
    .catch((err) => {
        console.log(err);
    });

const p1: Promise<string> = new Promise<string>((resolve, reject) => {
    try {
        // throw new Error('HALLO');
        resolve('Hallo 1!');
    } catch (err) {
        reject(err)
    }
})
// .then((txt) => { console.log(txt); }).catch((err) => { console.log(err); });

const p2: Promise<string> = new Promise<string>((resolve, reject) => {
    try {
        // throw new Error('TSCHÜSS');
        resolve('Hallo 2!');
    } catch (err) {
        reject(err)
    }
})
// .then((txt) => { console.log(txt); }).catch((err) => { console.log(err); });

Promise.all([p1, p2]).then((results) => { console.log(results); }).catch((err) => { console.log(err); });
p1.catch((err) => { console.log(err); });
p2.catch((err) => { console.log(err); });

main.calculate(10).then((result) => { console.log(result); }).catch((err) => { console.log(err); });

async function f(): Promise<void> {
    const y = await main.doSomething(5);
    console.log(y);
}

f().catch((err) => { console.log(err); });



