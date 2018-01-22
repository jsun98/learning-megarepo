var express = require('express');
var app = express();

var parser = require('body-parser');

app.use(parser.urlencoded({extended:false}));

app.post('/form', function (req, res) {
  res.writehead(200,{
    'content-type' : 'application/json'
  });
  res.end(req.body.str.split('').reverse().join(''));
});

app.listen(process.argv[2]);
