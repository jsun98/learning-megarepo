var fs = require('fs');
var path = require('path');
var dir = process.argv[2];
var ext = "."+process.argv[3];
fs.readdir(dir,function(err,list) {
	list.forEach(function (currElem, index, arr) {
		if (path.extname(currElem)===ext)
			console.log(currElem);
	});
});
		
