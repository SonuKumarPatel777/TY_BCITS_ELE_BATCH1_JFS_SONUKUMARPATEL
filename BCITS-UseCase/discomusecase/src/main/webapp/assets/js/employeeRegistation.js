function validation() {
    var name = document.getElementById("employeeName").value;
    var empId = document.getElementById("empId").value;
    var region = document.getElementById("empRegion").value;
    var designation = document.getElementById("empDesignation").value;
    var password = document.getElementById("empPassword").value;
    var confPassword = document.getElementById("empConfPassword").value;


    var nameValid = false;
    var empIdValid  = false;
    var regionValid = false;
    var designatonValid  = false;
    var passwordValid = false;
    var confPasswordValid  = false;
    

    if(name == ""){
        document.getElementById("empName").innerHTML= "Please fill the Name First*";
        return false;
    }else{
        document.getElementById("empName").style.display= 'none';
        var nameValid = true;
    }
    
    if(empId == ""){
        document.getElementById("empId").innerHTML= "Please fill the Employee ID First*";
        return false;
    }else{
        document.getElementById(" empId").style.display= 'none';
        var empIdValid = true;
    }
    
    if(region == ""){
        document.getElementById("reg").innerHTML= "Please fill the Region First*";
        return false;
    }else{
        document.getElementById("reg").style.display= 'none';
        var regionValid = true;
    }
    if(designation == ""){
        document.getElementById("deg").innerHTML= "Please fill the Designation First*";
        return false;
    }else{
        document.getElementById("deg").style.display= 'none';
        var designatonValid = true;
    }

    if(password == ""){
        document.getElementById("pwd").innerHTML= "Please fill the Password ";
        return false;
    }else if(password.length >8 && password.length<20){
        document.getElementById("pwd").innerHTML= "Please Enter Valid  Password";
        return false;
    }else{
        document.getElementById("pwd").style.display= 'none';
         passwordValid  = true; 
    }
    
    if(confPassword == ""){
        document.getElementById("confPwd").innerHTML= "Please fill the Password ";
        return false;
    }else if(confPassword.length >8 && confPassword.length<20){
        document.getElementById("confPwd").innerHTML= "Please Enter Valid  Password";
        return false;
    }else{
        document.getElementById("confPwd").style.display= 'none';
        confPasswordValid  = true; 
    }
    
    if(nameValid && empIdValid &&regionValid
    		&& designatonValid &&passwordValid && confPasswordValid){
        document.body.appendChild(form);
        form.submit();
        return true;
    }
    
}