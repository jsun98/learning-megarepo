var app = require('express')();

app.get('*',function(req,res,next) {
  if (req.url!='/') {
    var err = new Error();
    err.status = 403;
    next(err);
  }
  next();
});


app.get('/',function (req,res,next) {
  console.log("get request to main page!");
  next('route');
});

app.use(function (err, req, res, next) {
  if (err.status!=404) return next();
  else res.status(404).send("error");
});

app.listen(3000);

console.log("magic happens on port 3000");
