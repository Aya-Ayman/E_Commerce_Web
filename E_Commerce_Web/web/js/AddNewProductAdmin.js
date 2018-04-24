/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

errorFlag1 =false;
 errorFlag2 =false;
 errorFlag3 =false;
 errorFlag4=false;
function getErrorMsg(id, ErrorType,type) {

            var nameProduct= document.getElementById("nameProduct").value;
           var quantityProduct = document.getElementById("quantityProduct").value;
           var priceProduct = document.getElementById("priceProduct").value;
           var categoryProduct=document.getElementById("categoryProduct").value;
    switch (ErrorType) {
        case 'string':
        var reg=/^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/;
        if(!reg.test(nameProduct)){
            document.getElementById(id).innerHTML=type;
            errorFlag1=false;
          
    }
       else{
          document.getElementById(id).innerHTML=""; 
          errorFlag1=true;
        
       }
            break;
        case 'int' :
             
        var reg = /^[0-9]*$/;
         if (!reg.test(quantityProduct)) 
        {
            document.getElementById(id).innerHTML=type;
            errorFlag2=false;
          
        }

      else{
          document.getElementById(id).innerHTML=""; 
          errorFlag2=true;
          
       }   

            break;
        case 'float' :
        var reg=  /^[0-9]*[.]?[0-9]+$/;
          
          if (!reg.test(priceProduct)) 
        {
            document.getElementById(id).innerHTML=type;
            errorFlag3=false;
            
        }

      else{
          document.getElementById(id).innerHTML="";
          errorFlag3=true;
          
       }   
            break;
            
        case 'category':
            if(categoryProduct=='choose')
            {
            document.getElementById(id).innerHTML=type;
            errorFlag4=false;
            }
        
           else{
          document.getElementById(id).innerHTML="";
          errorFlag4=true;
          
       }
       break;
    }

}

  
  function valid()
  {
      if(errorFlag1 && errorFlag2 && errorFlag3 &&errorFlag4)
      return true;
    else
        return false;
  }
  
