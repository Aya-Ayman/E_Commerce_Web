function validName()
    {
        
        var name= document.getElementById("editname").value;
            
         var reg=/^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/;
        if(!reg.test(name)){
            document.getElementById("ename").innerHTML="Enter valid name";
          return false;}
       else{
          document.getElementById("ename").innerHTML=""; 
           return true;
       }
       } 
    
   
    
    
                               
    function validCredit()
        {
          var credit=document.getElementById("editcredit").value;
        var reg = /^[0-9]*$/;
         if (!reg.test(credit)) 
        {
            document.getElementById('ecredit').innerHTML="Enter valid credit limit";
            return false;
        }

      else{
          document.getElementById('ecredit').innerHTML=""; 
          return true;
       }   
            
        }
                               
 
                               
     function validJob()
    {
        
        var job= document.getElementById("editjob").value;
            
         var reg=/^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/;
        if(!reg.test(job)){
            document.getElementById("ejob").innerHTML="Enter valid job";
          return false;}
       else{
          document.getElementById("ejob").innerHTML=""; 
           return true;
       }
       }
                               
        function validDate()
           {
             var date=document.getElementById("editdate").value;
             var reg=/^\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])$/;
              if(!reg.test(date)){
            document.getElementById("ebdate").innerHTML="Enter valid date(ex:yyyy-mm-dd)";
           
          return false;}
       else{
          document.getElementById("ebdate").innerHTML=""; 
           return true;
       } 
           
                               }

function validForm()
{
    if(validName()&& validJob() && validDate() )
        return true;
    else
        return false;
}


                                      