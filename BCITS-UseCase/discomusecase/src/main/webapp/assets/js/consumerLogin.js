function validation() {
    var meterNum = document.getElementById("meterNum").value;
    var password = document.getElementById("password").value;


    var meterNumValid = false;
    var passwordValid  = false;

    var meterNumFormat = /[!@#$%&*()_+=|<>?{}\\[\\]~a-z]/;

    if(meterNum == ""){
        document.getElementById("meter").innerHTML= "Please fill the Meter/RR Number";
        return false;
    }else if(meterNumFormat.test(meterNum)){
        document.getElementById("meter").innerHTML= "Please Enter Valid  Meter/RR Number";
        return false;
    }else{
        document.getElementById("meter").style.display= 'none';
        var meterNumValid = true;
    }

    if(password == ""){
        document.getElementById("pass").innerHTML= "Please fill the Password ";
        return false;
    }else if(password.length >8 && password.length<20){
        document.getElementById("pass").innerHTML= "Please Enter Valid  Password";
        return false;
    }else{
        document.getElementById("pass").style.display= 'none';
         passwordValid  = true;
     
    }

    if(meterNumValid && passwordValid){
        document.body.appendChild(form);
        form.submit();
        return true;
    }
}