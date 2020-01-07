function validateForm() {
    var loginForm = document.forms['loginForm']
    var userMail = loginForm['userEmail'].value
    var password = loginForm['userPwd'].value
    // console.log(loginForm);
    // console.log('User Mail',userMail);
    // console.log('User Password',password);
    if(userMail.trim().length>10) {
        document.getElementById('emailErr').style.display='none'
        console.log('User mail is valid');   
    }else{
        document.getElementById('emailErr').style.display='block'
        console.log("User mail is invalid");    
    }
    if(password.trim().length>5) {
        document.getElementById('pwdErr').style.display='none'
        console.log('User Password is valid');   
    }else{
        document.getElementById('pwdErr').style.display='block'
        console.log("User Password is invalid");   
    }      
}