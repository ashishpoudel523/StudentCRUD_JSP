<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Students</title>
</head>
<body>
	<%@page import="com.dao.StudentDao,com.bean.*,java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<h1>Students List</h1>

	<%
	List<Student> list = StudentDao.getAllRecords();
			request.setAttribute("Students", list);
	%>

	<table border="1" width="90%">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Password</th>
			<th>Email</th>
			<th>Sex</th>
			<th>Country</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${Students}" var="u">
			<tr>
				<td>${u.getId()}</td>
				<td>${u.getName()}</td>
				<td>${u.getPassword()}</td>
				<td>${u.getEmail()}</td>
				<td>${u.getSex()}</td>
				<td>${u.getCountry()}</td>
				<td><a href="editform.jsp?id=${u.getId()}">Edit</a></td>
				<td><a href="deleteStudent.jsp?id=${u.getId()}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="addStudentform.jsp">Add New Student</a>

</body>
</html>