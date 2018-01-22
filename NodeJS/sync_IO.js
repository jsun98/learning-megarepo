var fs = require ('fs');

var buf = fs.readFileSync(process.argv[2]);

var text = buf.toString();

console.log(text.split("\n").length-1);


