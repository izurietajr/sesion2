const http = require('http');
const url = require('url');
const fs = require('fs');



http.createServer(function (req, res) {

    res.writeHead(200, {'Content-Type': 'text/html'});

    var q = url.parse(req.url, true).query;
    console.log(q);
    var txt = q.year + " " + q.month;
    res.end(txt);

}).listen(8080);
