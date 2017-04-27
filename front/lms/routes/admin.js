var express = require('express');
var router = express.Router();

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
        res.render('admin/dashboard',{title:'LMS-student'})
    }
    else{
        console.log('[Sending data to AA]')
        postLoginRequest(req, res,'loginServer');
    }
});

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
        // res.render('student/showBooks',{title:'Introduction to Algorithms, 3rd Edition', cover:'https://images-na.ssl-images-amazon.com/images/I/41-1VkO%2B1lL._SX359_BO1,204,203,200_.jpg',
        // id:'HK_2018_into_3rd_123',author:"Thomas H. Cormen  (Author), Charles E. Leiserson  (Author), Ronald L. Rivest  (Author), Clifford Stein  (Author)",isbn10:'0262033844',
        //publisher:"MIT Press",ava:'available'});
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
