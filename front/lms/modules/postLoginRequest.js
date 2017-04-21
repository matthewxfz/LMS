var request = require('request');
var ApplicationServer = require('../config/config').service.ApplicationServer;
var service = require('../config/config').service;

function postLoginRequest(req, res,mark) {
	var dataBody = req.body;
    var msg = dataBody ? dataBody: "";
	var account = dataBody.account?dataBody.account:'';
	var password = dataBody.password?dataBody.password:'';
	var session = req.session;

	console.log("inside the post " + account);
	var opt = {
		headers: {
			'Connection': 'close',
			'Content-Type': 'application/json;charset=utf-8',
			'node': 'open'
		},
		method: 'POST',
        baseUrl: 'http://localhost:8080',
        url: '/web2/auth',
		body: JSON.stringify(msg),
		//qs:{sid:session.id}
	}


	var callBack = function(error, response, body, data) {
		
		console.log('---------- post login request url -----------',ApplicationServer.baseUrl+ApplicationServer.authUrl);
		console.log('---------- post login request param -----------',account);
		console.log('---------- post login request response body -----------',body);
		
		if (!error) {
			if (response.statusCode == 200 || response.statusCode == 400) {
				var ans = JSON.parse(body);
				if(mark == 'loginServer') {//if this is login save the email to session
					if (ans.status == 'true') {
						req.session.email = account;
						req.session.userName = ans.firstName;
						req.session.userId = ans.userId;
						req.session.save();
                        res.send({title:'pass',content:''});
					}else{
                        res.send({title:'error',content:'Password or account not exist'});
					}
				}
			}else{
				res.send({
                    title: 'Error in inner server',
                    content: 'Error in inner server'
				});
			}
		} else {
			
			res.send({
                title: 'Error in inner server',
                content: 'Error in inner server'
			});
			
		}
	};
	
	request(opt, callBack);
	console.log("request send");
	
}

module.exports = postLoginRequest;