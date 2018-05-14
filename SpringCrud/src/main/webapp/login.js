//document.getElementById("loginB").addEventListener("click",login);
function login()
{
	
var name = document.getElementById("loginid").value;
var password = document.getElementById("password").value;
var url="/loginPage?name="+name+"&password="+password;
var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     var responsetext=xhttp.responseText;
     var parsedresult=JSON.parse(responsetext);
     if(parsedresult.success==true)
    	 {
    	 window.location="/home.jsp";
    	 }
     else
    	 {
    	 document.getElementById("errors").innerHTML=parsedresult.message;
    	 }
    	 }
    
  };	  
  
  xhttp.open("POST",url,true);
  xhttp.send();
}