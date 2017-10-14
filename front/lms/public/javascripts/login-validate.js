/**
 * Created by matthewxfz on 4/14/17.
 */
function validateLoginForm(){
    var account = documnet.forms["loginForm"]["account"].value;
    var password = documnet.forms["loginForm"]["password"].value;
    if(account == ''||password == '')
        $('#msg').text("passworld or account cannot be empty!")
    if(password.length < 6)
        $('#msg').text("passworld has be at least 6 number or English character")

    $('')
}