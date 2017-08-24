var express = require('express');
var app = express();

if (app.get('env') == 'development') {
	module.exports = {
		node: {
			port: '8080'//port for web server
		},
		service:{
			ApplicationServer:{
				host:"localhost",
				baseUrl:"http://127.0.0.1:8081/lms",
				port:"8081",
				authUrl:'/auth',
			},
		},
	};
}else{
	module.exports = {
		node: {
			port: '8080'//port for this web
		},
		service:{
			httpApi:{
				url:"http://localhost:8081/lms" //port for application server
			},
		},
	};
}