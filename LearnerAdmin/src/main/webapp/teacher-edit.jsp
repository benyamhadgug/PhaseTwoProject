<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.simplilearn.entity.Teacher"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Teacher</title>
<link rel="stylesheet" href="style.css">

</head>
<body>
<%
	Teacher student= (Teacher)request.getAttribute("teacher");
%>
	<nav>
		<a href="index.jsp">Home</a> <a href="student-list.jsp"
			>Student</a> <a href="teacher-list.jsp" class="chosen">Teacher</a> <a
			href="subject-list.jsp">Subject</a> <a href="classroom-list.jsp">
			Class</a> <a href="report.jsp">Report</a>
	</nav>
	</br>
	</br>
	<h1>Edit Teacher</h1>
	
	<form method="post" action= "UpdateTeacher">
		<fieldset>
			<legend>Edit Teacher Form</legend>
			
			<input type="hidden" name="id" id="id" value="<%= student.getId() %>" /> <br/>
			First Name : <input type="text" name="firstname" id="firstname" value="<%= student.getFirstName()%>" /> <br/>
			Last Name : <input type="text" name="lastname" id="lastname" value="<%= student.getLastName()%>" /> <br/>

			<input type="submit" value = "Update"	/>
				
		</fieldset>
		
	</form></body>
</html>