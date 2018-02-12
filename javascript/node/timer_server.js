var net = require('net');

function fillInZeros(time) {
  return (time < 10 ? "0" : "" ) + time;
}

var server = net.createServer(function (socket) {
  var date = new Date();
  var fDate = date.getFullYear()+"-"+
    fillInZeros(date.getMonth()+1)+"-"+
    fillInZeros(date.getDate())+" "+
    fillInZeros(date.getHours())+":"+
    fillInZeros(date.getMinutes())+"\n";
  socket.write(fDate);
  socket.end();
});

server.listen(process.argv[2]);
