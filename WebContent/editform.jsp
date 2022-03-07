<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Form</title>
</head>
<body>
<%@page import="com.dao.StudentDao,com.bean.Student"%>

<%
String id=request.getParameter("id");
Student u=StudentDao.getRecordById(Integer.parseInt(id));
%>

<h1>Edit Form</h1>
<form action="editStudent.jsp" method="post">
	<input type="hidden" name="id" value="<%=u.getId() %>"/>
	<table>
		<tr><td>Name:</td><td><input type="text" name="name" value="<%= u.getName()%>"/></td></tr>
		<tr><td>Password:</td><td><input type="password" name="password" value="<%= u.getPassword()%>"/></td></tr>
		<tr><td>Email:</td><td><input type="email" name="email" value="<%= u.getEmail()%>"/></td></tr>
		<tr><td>Country:</td><td>
		<select name="country">
		<option>Nepal</option>
		<option>Other</option>
		</select>
		</td></tr>
		<tr><td colspan="2"><input type="submit" value="Edit Student"/></td></tr>
	</table>
</form>

</body>
</html>