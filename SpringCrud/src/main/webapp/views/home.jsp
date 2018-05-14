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
<body>
<h2 id="head">Home</h2>

<a href='create.jsp'> Create </a><br>
<a href="/login/readStudent"> Read </a><br>
<a href='delete.jsp'> Delete </a><br>
<a href='update.jsp'> Update </a><br>
<a href="/logout"> Logout </a><br>
</body>


</html>