/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

errorFlag1 = true;
errorFlag2 = true;
errorFlag3 = true;
errorFlag4 = true;
function getErrorMsg(id, ErrorType,type) {

            var nameProductUp= document.getElementById("nameProductUp").value;
           var quantityProductUp = document.getElementById("quantityProductUp").value;
           var priceProductUp = document.getElementById("priceProductUp").value;
      
    var categoryProductUp = document.getElementById("categoryProductUp").value;
    var categoryList =document.getElementById("categoryProductUp");       
    switch (ErrorType) {
        case 'string':
        var reg=/^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/;
        if(!reg.test(nameProductUp)){
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
         if (!reg.test(quantityProductUp)) 
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
          
          if (!reg.test(priceProductUp)) 
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
            if(categoryProductUp=='choose')
            {
            document.getElementById(id).innerHTML=type;
            errorFlag4=false;
            }
        
           else{
          document.getElementById(id).innerHTML="";
          
            for (var i=0; i<categoryList.length; i++){
            if (categoryList.options[i].value == categoryProductUp )
               categoryList.remove(categoryList.options[i]);
            }
            errorFlag4=true;
          
       }
       break;
        

    }
    }
   
   function changeCategory()
   {
       var categoryProductUp = document.getElementById("categoryProductUp").value;
    //var categoryList =document.getElementById("categoryProductUp"); 
    var currentCategory=document.getElementById("currentCategory");
    
    if(categoryProductUp!="choose the category")
    {
        currentCategory.value=categoryProductUp;
        
    }
    
   }
      
   
    
 function valid()
  {
      if(errorFlag1 && errorFlag2 && errorFlag3 && errorFlag4)
      return true;
    else
        return false;
  }







