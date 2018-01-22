var map = require('through2-map');
  http = require('http');

var server = http.createServer((req,res)=> {
  if (req.method=='POST') {
    res.writeHead(200, { 'Content-Type': 'text/plain' });
    req.pipe(map((chunk)=>{
      return chunk.toString().toUpperCase();
    })).pipe(res);
  } else {
    return res.end("GG NO POST\n");
  }
});

server.listen(process.argv[2]);
