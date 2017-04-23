var express = require('express');
var http = require('http');
var router = express.Router();
var io = require('socket.io');
var request = require('request');
var validator = require('validator');
var postLoginRequest = require('../modules/postLoginRequest');
var postRequest = require('../modules/postRequest');
var getRequestRender = require('../modules/getRequestRender')
var config = require("../config/config");
io = io.listen(this.server);

/* GET home page. */
router.get('/', function(req, res, next) {
    sess=req.session;
    if(sess.email)
    {
        res.redirect('/dashboard');
    }
    else{
        res.render('student/login', { title: 'LMS-login' });
    }
});

router.post('/login', function(req, res, next) {
    console.log(req.body);
    // if(!validator.isEmail(req.body.param.account) || validator.isEmpty(req.body.param.account)){
    //     msg.title = 'error';
    //     msg.content = 'the input is illegal!'
    //     console.log('[ERROR]'+JSON.stringify(msg));
    //     res.send(msg);
    // }else{// ask authorization for server
        console.log('[Sending data to AA]')
        postLoginRequest(req, res,'loginServer');
    // }
});

router.get('/dashboard',function (req,res,next){
    res.render('student/dashboard');
});

router.get('/logout',function (req,res,next) {
    req.session.destroy(function(err){
        if(err){
            console.log(err);
        }
        else
        {
            res.redirect('/');
        }
    });
});

router.get('/getUserName', function(req,res, next){
    sess=req.session;
    if(sess.email)
    {
        res.send({username:req.session.userName});
    }
    else{
        res.render('student/login', { title: 'LMS-login' });
    }
});

router.post('/searchBooks*', function(req, res,next){
    console.log(req.body);
    sess=req.session;
    if(sess.email)
    {
        postRequest(req, res, "");
    }
    else{
        res.render('student/login', { title: 'LMS-login' });
    }
});

router.post('/checkCap', function(req, res,next){
    console.log(req.body);
    sess=req.session;
    if(sess.email)
    {
        req.body = {userId:sess.userId};
        postRequest(req, res, "");
    }
    else{
        res.render('student/login', { title: 'LMS-login' });
    }
});

router.post('/checkRent', function(req, res,next){
    console.log(req.body);
    sess=req.session;
    if(sess.email)
    {
        req.body = {userId:sess.userId};
        postRequest(req, res, "");
    }
    else{
        res.render('student/login', { title: 'LMS-login' });
    }
});

router.post('/checkDue', function(req, res,next){
    console.log(req.body);
    sess=req.session;
    if(sess.email)
    {
        req.body = {userId:sess.userId};
        postRequest(req, res, "");
    }
    else{
        res.render('student/login', { title: 'LMS-login' });
    }
});

router.get('/showBooks',function(req,res,next){
    console.log(req.body);
    sess=req.session;
    if(sess.email)
    {
        req.body = {userId:sess.userId};
        // res.render('student/showBooks',{title:'Introduction to Algorithms, 3rd Edition', cover:'https://images-na.ssl-images-amazon.com/images/I/41-1VkO%2B1lL._SX359_BO1,204,203,200_.jpg',
        // id:'HK_2018_into_3rd_123',author:"Thomas H. Cormen  (Author), Charles E. Leiserson  (Author), Ronald L. Rivest  (Author), Clifford Stein  (Author)",isbn10:'0262033844',
        //publisher:"MIT Press",ava:'available'});
        getRequestRender(req, res, {param:"bookId="+req.query.bookid},'student/showBooks');
    }
    else{
        res.render('student/login', { title: 'LMS-login' });
    }
});

router.get('/allnew',function (req,res,next) {
    res.render('student/allnew');
});
router.post('/reci', function (req,res,next) {
    var msg = JSON.parse(req.data);
    console.log('hello');
    console.log('Get msg'+msg);
    var user = {
        'id':'A10234',
        'name':'matthewxfz'
    }

    response.send(JSON.stringify(user));
});


module.exports = router;