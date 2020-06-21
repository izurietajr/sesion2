const bodyParser = require('body-parser');
const http = require('http');
const https = require('https');
const fs = require('fs');


const hostname = '127.0.0.1';
const http_port = 8080;
const https_port = 8443;


var app = express();

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

var httpServer = http.createServer(app);
var httpsServer = https.createServer(credentials, app);

httpServer.listen(http_port);
httpsServer.listen(https_port);
