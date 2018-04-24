function validName()
    {
        
        var name= document.getElementById("name").value;
            
         var reg=/^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/;
        if(!reg.test(name)){
            document.getElementById("vname").innerHTML="Enter valid name";
          return false;}
       else{
          document.getElementById("vname").innerHTML=""; 
           return true;
       }
       } 
    
    
    function validEmail()
    {
        var email=document.getElementById("emailReg").value;
        var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})*$/;
         if (!reg.test(email)) 
        {
            document.getElementById('vemail').innerHTML="Enter valid email";
            return false;
        }

      else{
          document.getElementById("vemail").innerHTML=""; 
          return true;
       } 
    }
    
     function validEmail2()
    {
        var email=document.getElementById("emailIn").value;
        var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})*$/;
         if (!reg.test(email)) 
        {
            document.getElementById('vvemail').innerHTML="Enter valid email";
            return false;
        }

      else{
          document.getElementById("vvemail").innerHTML=""; 
          return true;
       } 
    }
                               
    function validCredit()
        {
          var credit=document.getElementById("credit").value;
        var reg = /^[0-9]*$/;
         if (!reg.test(credit)) 
        {
            document.getElementById('vcredit').innerHTML="Enter valid credit limit";
            return false;
        }

      else{
          document.getElementById('vcredit').innerHTML=""; 
          return true;
       }   
            
        }
                               
    function validPassword()
            {
            var password= document.getElementById("password").value;
            var passwordconf=document.getElementById("confirm password").value;
           
         if (password!=passwordconf) 
        {
            document.getElementById('vpass').innerHTML="passwords doesn't match";
            return false;
        }

      else{
          document.getElementById('vpass').innerHTML=""; 
          return true;
       }        
                               }
                               
     function validJob()
    {
        
        var job= document.getElementById("job").value;
            
         var reg=/^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/;
        if(!reg.test(job)){
            document.getElementById("vjob").innerHTML="Enter valid job";
          return false;}
       else{
          document.getElementById("vjob").innerHTML=""; 
           return true;
       }
       }
                               
        function validDate()
           {
             var date=document.getElementById("Birth Date").value;
             var reg=/^\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])$/;
              if(!reg.test(date)){
            document.getElementById("vbdate").innerHTML="Enter valid date(ex:yyyy-mm-dd)";
           
          return false;}
       else{
          document.getElementById("vbdate").innerHTML=""; 
           return true;
       } 
           
                               }

function validForm()
{
    if(validName()&& validEmail() && validJob() && validPassword() && validDate() && validCredit())
        return true;
    else
        return false;
}


                                      