var request = require('request');
var ApplicationServer = require('../config/config').service.ApplicationServer;
var service = require('../config/config').service;

function postRequest(req, res,mark) {

	var dataBody = req.body;
    var msg = dataBody ? dataBody: "";
	var account = dataBody.account?dataBody.account:'';
	var password = dataBody.password?dataBody.password:'';
	var session = req.session;

	var opt = {
		headers: {
			'Connection': 'close',
			'Content-Type': 'application/json;charset=utf-8',
			'node': 'open'
		},
		method: 'POST',
        baseUrl: ApplicationServer.baseUrl,
        url: req.originalUrl,
		body: JSON.stringify(msg),
		//qs:{sid:session.id}
	}


	var callBack = function(error, response, body, data) {
		
		console.log('---------- post login request url -----------',ApplicationServer.baseUrl+req.url);
		console.log('---------- post login request param -----------',msg);
		console.log('---------- post login request response body -----------',body);
		
		if (!error) {
			if (response.statusCode == 200 || response.statusCode == 400) {
                var ans;
				if(body == undefined){
                    res.send({
                        status: 'false',
                        content: 'Error in inner server'
                    });
				}else{
					ans = JSON.parse(body);
				}
				console.log('[Get Request:]: '+ans);
				if(mark == 'loginServer') {//if this is login save the email to session
					if (ans.status == 'true') {
						req.session.email = account;
						req.session.UserId = ans.firstName;
						req.session.save();
                        res.send({title:'pass',content:''});
					}else{
                        res.send({title:'error',content:'Password or account not exist'});
					}
				}else{
					res.set('Content-Type','application/json;charset=utf-8');
					res.send(body);
				}
			}else{
				res.send({
                    status: 'false',
                    content: 'Error in inner server'
				});
			}
		} else {
			
			res.send({
                status: 'false',
                content: 'Error in inner server'
			});
			
		}
	};
	
	request(opt, callBack);
	console.log("request send");
	
}

module.exports = postRequest;