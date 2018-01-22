var http = require ('http');
  url = require ('url');

function parseTimeJSON (date) {
  return {
    "hour" : date.getHours(),
    "minute" : date.getMinutes(),
    "second" : date.getSeconds()
  }
}

var server = http.createServer((req,res) => {
  if (req.method != 'GET')
    return res.end("NOT GET!\n");

  var url_parts = url.parse(req.url,true);
  var date = new Date (url_parts.query.iso);

  res.writeHead(200, {'content-type':'application/json'});

  if (url_parts.pathname === "/api/parsetime") {
    res.write(JSON.stringify(parseTimeJSON(date)));
  }
  if (url_parts.pathname === "/api/unixtime") {
    res.write(JSON.stringify({"unixtime" : date.getTime()}));
  }
  res.end();


});

server.listen(process.argv[2]);
