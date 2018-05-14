<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%

	if (session.getAttribute("name")!= null) {		
		response.sendRedirect("/home.jsp");
	}
	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<P id="errors"></P>
<p>Login Details</p>

    <table>
        <tr>
            <td> Login ID :</td>
            <td><input type="number" id="loginid" min="1" max="200" style="width:169px;"/></td>
        </tr>
        <tr>
        	<td> Passowrd :</td>
        	<td><input type="password" id="password"/></td>
        <tr>
       
    </table>
    <input  type="button" id="loginB" onclick="login()" value="submit"/>
</body>
<script src="login.js"></script>
</html>    
