<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	if(session.getAttribute("name")==null)
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must re-validate");
		response.sendRedirect("/loginPage.jsp");
	}
	response.setHeader("Cache-Control", "no-cache, no-store, must re-validate");
	out.println("<p id=\"sess\" style='text-align:right;'>"+"User name="+request.getSession().getAttribute("name")+"</p>");	
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>

<body id="webpage">
<h2 id="head">Home</h2>

<input type="button" value="Create " id="create" onclick="loadPage(this.id)" /> <br><br>
<input type="button" value=" Read  " id="read" onclick="loadPage(this.id)" /><br><br>
<input type="button" value="Delete " id="delete" onclick="loadPage(this.id)" /><br><br>
<input type="button" value="Update" id="update" onclick="loadPage(this.id)" /> <br><br>
<input type="button" value="Logout " id="logout" onclick="loadPage(this.id)" /><br>

</body>

<script>
	function loadPage(buttonid) {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
					document.getElementById("webpage").innerHTML = xhttp.responseText;
			}

		};	
		
	    if (buttonid == "create")
			xhttp.open("GET", "/create.jsp", true);
		else if (buttonid == "read")
			xhttp.open("GET", "/login/readStudent", true);
		else if (buttonid == "delete")
			xhttp.open("GET","/delete.jsp",true);
		else if(buttonid == "update")
			xhttp.open("GET","/login/updateStudent",true);
		else if(buttonid == "logout")
			window.location="/login/logoutServlet";			

			xhttp.send();
	}

	function createfunc() {
		var id = document.getElementById("idnumber").value;
		var name = document.getElementById("nameid").value;
		var dept = document.getElementById("deptid").value;
		var xhttpreq = new XMLHttpRequest();
		var url = "/login/createStudent?id=" + id + "&name=" + name
				+ "&department=" + dept + "";
		xhttpreq.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var response = JSON.parse(xhttpreq.responseText);
				document.getElementById("response").innerHTML = response.message;
			}
		};

		xhttpreq.open("POST", url, true);
		xhttpreq.send();
	}
	
	function updatefunc()
	{
	var id = document.getElementById("id").value;
	var value = document.getElementById("Value").value;
	var respectiveinput = document.getElementById("respectiveinput").value;
	document.getElementById("response").innerHTML=respectiveinput;
	var xhttpreq = new XMLHttpRequest();	
	var url="/login/updateStudent?id="+id+"&value="+value+"&respectiveinput="+respectiveinput;
	 xhttpreq.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	var response = JSON.parse(xhttpreq.responseText);
		    	document.getElementById("response").innerHTML=response;
		    }
		  };	  
		  
		  xhttpreq.open("POST",url,true);
		  xhttpreq.send();
	}
	
	function deletefunc()
	{
	var id = document.getElementById("studentid").value;

	var xhttpreq = new XMLHttpRequest();	
	var url="/login/deleteStudent?id="+id;
	 xhttpreq.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	var response = JSON.parse(xhttpreq.responseText);
		    	document.getElementById("response").innerHTML=response.message;
		    }
		  };	  
		  
		  xhttpreq.open("POST",url,true);
		  xhttpreq.send();
	}
	
	function login()
	{
		
	var name = document.getElementById("loginid").value;
	var password = document.getElementById("password").value;
	var url="/loginPage?name="+name+"&password="+password+"";
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
</script>

</html>