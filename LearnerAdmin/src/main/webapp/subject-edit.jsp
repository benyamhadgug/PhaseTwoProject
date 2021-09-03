<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.simplilearn.entity.Subject"%>
<%@page import="com.simplilearn.dao.TeacherDAO"%>
<%@page import="com.simplilearn.entity.Teacher"%>
<%@page import="java.util.List"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Subject</title>
<link rel="stylesheet" href="style.css">

</head>
<body>
	<%
		Subject classroom= (Subject)request.getAttribute("subject");
		List<Teacher> teachers = TeacherDAO.list();
		out.println("teachers : " + teachers.size());
		request.setAttribute("teachers", teachers);
	%>
		<nav>
		<a href="index.jsp">Home</a> <a href="student-list.jsp"
			>Student</a> <a href="teacher-list.jsp">Teacher</a> <a
			href="subject-list.jsp" class="chosen">Subject</a> <a href="classroom-list.jsp">Class</a> <a href="report.jsp">Report</a>
	</nav>
	</br>
	</br>
	<h1>Edit Subject</h1>
	
	<form method="post" action= "UpdateSubject">
		<fieldset>
			<legend>Edit Subject Form</legend>
			
			<input type="hidden" name="id" id="id" value="<%= classroom.getId() %>" /> <br/>
			Name : <input type="text" name="name" id="name" value="<%= classroom.getName() %>" /> <br/>
						Teacher: <select name="teacher">
		    <c:forEach items="${teachers}" var="tchr">
		    	
		        <option value="${tchr.getId()}">${tchr.getDisplayString()}</option>
		    </c:forEach>
			</select><br/>
			<input type="submit" value = "Update"	/>
				
		</fieldset>
		
	</form></body>
</html>