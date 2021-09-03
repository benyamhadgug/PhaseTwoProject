<%@page import="com.simplilearn.dao.SubjectDAO"%>
<%@page import="com.simplilearn.entity.Subject"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Class list</title>
<link rel="stylesheet" href="style.css">

</head>
<body>

<%
	List<Subject> subjects = SubjectDAO.list();
	request.setAttribute("subjects", subjects);
%>

	<nav>
		<a href="index.jsp">Home</a> <a href="student-list.jsp"
			>Student</a> <a href="teacher-list.jsp">Teacher</a> <a
			href="subject-list.jsp">Subject</a> <a href="classroom-list.jsp"  class="chosen">Class</a> <a href="report.jsp">Report</a>
	</nav>
	</br>
	</br>


	<div>
		<b>Name : </b> ${classroom.getName() } 
		
	</div>
	<hr>
		<h4>Add Subject to Class</h4>
	</br>

	<table style="border: 1px solid black;">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Teacher</th>
			<th>#</th>
		</tr>


		<core:forEach items="${subjects}" var="sbj">
			<tr>
				<td>${sbj.getId()}</td>
				<td>${sbj.getName()}</td>
				<td>${sbj.getTeacher().getDisplayString()}</td>
				<td><a href="addsubjecttoclassroom?class=${classroom.getId()}&subject=${sbj.getId()}"> Add</a></td>
			</tr>
		</core:forEach>
	</table>
</body>
</html>