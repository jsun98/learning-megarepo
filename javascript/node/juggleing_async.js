var http = require ('http');
var bl = require ('bl');
var result = [];

function printResult() {
	result.forEach((elem) => {
		console.log(elem);
	});
}


function getRequest (count) {
http.get(process.argv[count+2],(res) => {
	res.setEncoding('utf8');
	res.pipe(bl((err,data) => {
		result[count]=data.toString();
		if (count == 2) printResult();
	}));		
});
}

for (var i = 0; i < 3; i++) {
	getRequest(i);
}



