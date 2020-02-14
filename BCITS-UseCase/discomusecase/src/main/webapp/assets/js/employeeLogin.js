function validation() {
    var  empId = document.getElementById("empId").value;
    var password = document.getElementById("password").value;


    var employeeIdValid = false;
    var passwordValid  = false;

     

    if(empId == ""){
        document.getElementById("employeeId").innerHTML= "Please fill the Employee ID First*";
        return false;
    }else{
        document.getElementById("employeeId").style.display= 'none';
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

    if(employeeIdValid && passwordValid){
        document.body.appendChild(form);
        form.submit();
        return true;
    }
}