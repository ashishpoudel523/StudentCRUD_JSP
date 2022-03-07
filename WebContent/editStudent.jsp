<%@page import="com.dao.StudentDao"%>
<jsp:useBean id="u" class="com.bean.Student"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
int i=StudentDao.update(u);
response.sendRedirect("viewStudents.jsp");
%>