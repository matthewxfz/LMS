/**
 * Created by chenjiajun on 2016/11/15.
 */
var request = require('request');
var ApplicationServer = require('../config/config').service.ApplicationServer;
var wechat = require('../config/config').wechat;

function getRequestRender(req, res, dataBody,renderUrl) {

	var param = dataBody.param ? dataBody.param : {};
	//var session = req.session;

	var opt = {
		headers: {
			'Connection': 'close',
			'Content-Type': 'application/json; charset=utf-8',
			'node': 'open'
		},
		method: 'GET',
        baseUrl: ApplicationServer.baseUrl,
        url: req.originalUrl,
		qs: param
	};

	var callBack = function(error, response, body) {
		
		console.log('---------- get request url -----------', ApplicationServer.baseUrl+req.originalUrl);
		console.log('---------- get request param -----------',param);
		console.log('---------- get request response body -----------',body);
		
		if (!error) {
			if (response.statusCode == 200 || response.statusCode == 400) {
				var bodyData = JSON.parse(body);
				if(bodyData.status == "true"){
					//if this is show books
					content = (bodyData.content)[0];
                    res.render(renderUrl,content);

					//res.render(renderUrl,{title:content.title,generatedId:content.generatedId, author:content.author, publisher:content.publisher,isbn10:content.isbn10,status:content.status, cover:content.generatedId});
                	//res.render(renderUrl,{title:"hello"})
				}else{
                    res.render(renderUrl,{
                        title: 'Error in inner server',
                        content: 'Error in inner server'
                    });
                }
            }else{
                res.render(renderUrl,{
                    title: 'Error in inner server',
                    content: 'Error in inner server'
                });
      	  }
    	} else {

            res.render(renderUrl,{
                title: 'Error in inner server',
                content: 'Error in inner server'
            });
    	}
};
	
	request(opt, callBack);
}

module.exports = getRequestRender;