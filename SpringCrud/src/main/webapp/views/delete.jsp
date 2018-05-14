<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	if (session.getAttribute("name") == null) {
		response.sendRedirect("loginPage.jsp");
	}
	out.println("<p style='text-align:right;'>" + "User name=" + request.getSession().getAttribute("name")
			+ "</p>");
%>
<html>
<head>
    <title> Delete Student</title>
</head>
<body>
<p>Delete an existing Student</p>
<h4 id="response"></h4>
    <table>
        <tr>
            <td> User id to be deleted :</td>
            <td><input type="number" id="studentid" name="studentid"/></td>
        </tr>
       
    </table>
    <input type="button" id="submit" value="Submit"/>
    

<a href="/home.jsp"> Home </a>
</body>
<script type="text/javascript">
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
</script>
</html>