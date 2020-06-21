const http = require('http');
const url  = require('url');
const fs   = require('fs');
const path = require('path');


const serverUrl  = 'http://localhost:8080/';
const serverPort = 8080;

http.createServer(function(req, res) {

    console.log("nueva petición:");

    let request_url = new URL(req.url, serverUrl);
    let filename = path.join('.', request_url.pathname);
    console.log(filename);

    fs.readFile(filename, 'utf-8', function(err, data) {
        if(err){
            res.setHeader('Content-Type', 'application/json');
            res.statusCode = 404;
            let message = {
                code: "404: Not Found",
                message: "No se encuentra el archivo " + filename
            }
            res.end(JSON.stringify(message));
        }
        else {
            res.end(data);
        }
    });

}).listen(serverPort);
