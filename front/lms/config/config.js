var express = require('express');
var app = express();

if (app.get('env') == 'development') {
	module.exports = {
		node: {
			port: '8081'//port for web server
		},
		service:{
			ApplicationServer:{
				host:"localhost",
				baseUrl:"http://127.0.0.1:8080/web2",
				port:"8080",
				authUrl:'/auth',
			},
		},
	};
}else{
	module.exports = {
		node: {
			port: '8081'//port for this web
		},
		service:{
			httpApi:{
				url:"http://localhost:8080/web2" //port for application server
			},
		},
	};
}