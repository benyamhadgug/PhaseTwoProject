<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Class</title>
<link rel="stylesheet" href="style.css">

</head>
<body>
	<nav>
		<a href="index.jsp">Home</a> <a href="student-list.jsp"
			>Student</a> <a href="teacher-list.jsp">Teacher</a> <a
			href="subject-list.jsp">Subject</a> <a href="classroom-list.jsp" class="chosen">Class</a> <a href="report.jsp">Report</a>
	</nav>
	</br>
	</br>
	<h1>Add Class</h1>
	
	<form method="post" action= "AddClassRoom">
		<fieldset>
			<legend>Add Class Form</legend>
			
			Name : <input type="text" name="name" id="name" /> <br/>
			
			<input type="submit" value = "Add"	/>
				
		</fieldset>
		
	</form></body>
</html>