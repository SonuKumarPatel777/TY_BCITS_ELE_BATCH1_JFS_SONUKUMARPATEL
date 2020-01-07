function validateForm() {
    var loginForm = document.forms['loginForm']
    var userMail = loginForm['userEmail'].value
    var password = loginForm['userPwd'].value
    console.log(loginForm);
    console.log('User Mail',userMail);
    console.log('User Password',password);
    
    
    
}