/**
 * Created by matthewxfz on 4/19/17. amdin login
 */
$('#msg-brand').hide();

//validet the form
function validateLoginForm() {
    var account = document.forms["login-form"]["account"].value;
    var password = document.forms["login-form"]["pwd"].value;
    console.log("validating...");
    if (account == '' || password == ''){
        console.log('wrong');
        $('#msg').text("passworld or account cannot be empty!");
        $('#msg-brand').show();
        return false;
    }
    if (password.length < 6){
        $('#msg').text("passworld has be at least 6 number or English character");
        $('#msg-brand').show();
        return false;
    }
    return true;
}
// this is useless
function toggleInput(swi){
    if(swi == 'on'){
        $('#pwd').add('readonly');
        $('#account').add('readonly');
    }
    if(swi == 'off'){
        $('#pwd').removeAttr('readonly');
        $('#account').removeAttr('readonly');
    }
}
console.log("before connnection");

//sent to server when click
$(function () {
    $('#submitBtn').click(function () { /*listening to the button click using Jquery listener*/
        var param = {
            /*creating a Js ojbect to be sent to the server*/
            account: $('#account').val()+"@iit.edu", /*getting the text input data      */
            pwd: $('#pwd').val()
        }

        $('#msg').text('');
        $('#msg-brand').hide();
        if(validateLoginForm()){
            toggleInput('off');
            console.log(document.location.origin);
            $.post(document.location.origin + '/admin/search/Classes',
                {account:param.account, password:param.pwd, time:"no right"},
                function (req, res, data) {
                if(data.responseJSON != undefined){
                    if (data.responseJSON.title == 'pass') {
                        window.location.href = "/dashboard";
                    }else{
                        $('#msg').text(data.responseJSON.content);
                        $('#msg-brand').show();
                    }
                }else{
                    $('#msg').text("Content Error!");
                    $('#msg-brand').show();
                }

            });
        }else{
            return false;
        }
    });
});