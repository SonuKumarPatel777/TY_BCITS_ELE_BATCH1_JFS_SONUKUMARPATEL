function validation () {
    var meterNum = document.getElementById("meterNum").value;
    var password = document.getElementById("password").value;


    var meterNumValid = false;
    var passwordValid  = false;

    var format = /[!@#$%^&*()_+\-=\[\]{};':'\\|,.<>\/?a-zA-Z]+/;

    if(meterNum == ""){
        document.getElementById("meterNum").innerHTML= "Please fill the Meter/RR Number";
        return false;
    }else if(format.test(meterNum)){
        document.getElementById("meterNum").innerHTML= "Please Enter Valid  Meter/RR Number";
        return false;
    }else{
        document.getElementById("meterNum").innerHTML= 'none';
        var meterNumValid = true;
    }

    if(password == ""){
        document.getElementById("password").innerHTML= "Please fill the Password ";
        return false;
    }else if(password.length >8){
        document.getElementById("password").innerHTML= "Please Enter Valid  Password";
        return false;
    }else{
        document.getElementById("password").innerHTML= 'none';
         passwordValid  = true;
     
    }

    if(meterNumValid && passwordValid){
        document.body.appendChild(form);
        form.submit();
        return true;
    }
}