<%@page import="com.dao.StudentDao"%>
<jsp:useBean id="u" class="com.bean.Student"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
StudentDao.delete(u);
response.sendRedirect("viewStudents.jsp");
%>