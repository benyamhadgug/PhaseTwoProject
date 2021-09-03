<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.simplilearn.entity.ClassRoom"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Class</title>
<link rel="stylesheet" href="style.css">

</head>
<body>
<%
	ClassRoom classroom= (ClassRoom)request.getAttribute("classroom");
%>
	<nav>
		<a href="index.jsp">Home</a> <a href="student-list.jsp"
			>Student</a> <a href="teacher-list.jsp">Teacher</a> <a
			href="subject-list.jsp">Subject</a> <a href="classroom-list.jsp" class="chosen">Class</a> <a href="report.jsp">Report</a>
	</nav>
	</br>
	</br>
	<h1>Edit Class</h1>
	
	<form method="post" action= "UpdateClassRoom">
		<fieldset>
			<legend>Edit Class Form</legend>
			
			<input type="hidden" name="id" id="id" value="<%= classroom.getId() %>" /> <br/>
			Name : <input type="text" name="name" id="name" value="<%= classroom.getName() %>" /> <br/>
			<input type="submit" value = "Update"	/>
				
		</fieldset>
		
	</form></body>
</html>