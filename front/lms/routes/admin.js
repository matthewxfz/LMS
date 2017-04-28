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
        res.render('admin/login', { title: 'LMS-login' });
    }
});

router.post('/login', function(req, res, next) {
    sess=req.session;
    if(sess.email)
    {
        res.render('admin/dashboard',{title:'LMS-Admin'})
    }
    else{
        console.log('[Sending data to AA]')
        postLoginRequest(req, res,'loginServer');
    }
});

// router.get('/try',function(req,res,next){
//     res.render('student2/dashboard');
// });

router.get('/dashboard',function (req,res,next){
    sess=req.session;
    if(sess.email)
    {
        res.render('admin/dashboard',{title:'LMS-student'})
    }
    else{
        res.render('admin/login', { title: 'LMS-login' });
    }

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
        res.render('admin/login', { title: 'LMS-login' });
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
        res.render('admin/login', { title: 'LMS-login' });
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
        res.render('admin/login', { title: 'LMS-login' });
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
        res.render('admin/login', { title: 'LMS-login' });
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
        res.render('admin/login', { title: 'LMS-login' });
    }
});

router.get('/showBooks',function(req,res,next){
    console.log(req.body);
    sess=req.session;
    if(sess.email)
    {
        req.body = {userId:sess.userId};
        getRequestRender(req, res, {param:"bookId="+req.query.bookid},'admin/showBooks');
    }
    else{
        res.render('admin/login', { title: 'LMS-login' });
    }
});

router.get('/profile',function(req,res,next){
    console.log(req.body);
    sess=req.session;
    if(sess.email)
    {
        req.body = {userId:sess.userId};
        res.render('admin/profile');
    }
    else{
        res.render('admin/login', { title: 'LMS-login' });
    }
});

module.exports = router;
