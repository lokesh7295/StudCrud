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
<title> Create </title>
</head>
<body>
<h4 id="response"> </h6>
<h2>Create New User</h2>

    <table>
        <tr>
            <td> Student id:</td>
            <td><input id="idnumber" type="number" name="id" min="1" max="10000" required/></td>
        </tr>
        <tr>
            <td> Student Name:</td>
            <td><input id="nameid" type="text" name="name" pattern="[a-zA-z]{4,}" required/>Name should only contain Letters and minumum 4 characters</td> 
        </tr>
        <tr>
            <td> Student department:</td>
            <td><input id="deptid" type="text" name="department" pattern="[A-Z]{3}" required/> Department should be only 3 letters all Caps</td>
        </tr>
    </table>
    <input type="button" value="Submit" onclick="createfunc()"/>

<br><a href="/home.jsp"> Home </a>
</body>

</html>