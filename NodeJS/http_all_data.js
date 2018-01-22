var http = require('http');
var url = process.argv[2];
http.request(url,function(res) {
	var charCount = 0;
	var chunk = "";
	res.setEncoding('utf8');
		res.on('data',function(data) {
			charCount += data.length;
			chunk += data;	
		});
		res.on('end',() => {
			console.log(charCount);
			console.log(chunk);	
		});
}).on('error',() => {
	console.error(err);
}).end();
