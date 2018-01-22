var http = require ('http');
var bl = require ('bl');

http.get(process.argv[2], (res) => {
	res.setEncoding('utf8');
	res.pipe(bl((err,data)=> {
		console.log(data.length);
		console.log(data);	
	}));
}).on('error',(err)=>{
	console.log(err);
});
