1. Lösung: callback Funktionen:
            () => {}
setTimeout(f.bind(this)1000ms),

const f = Function () {}

setTimeout(() => {
    ....
    ....
    ....
    ....
}, 1000);