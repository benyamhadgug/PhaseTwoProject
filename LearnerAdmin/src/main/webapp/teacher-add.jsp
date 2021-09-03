<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Teacher</title>
<link rel="stylesheet" href="style.css">

</head>
<body>
	<nav>
		<a href="index.jsp">Home</a> <a href="student-list.jsp"
			>Student</a> <a href="teacher-list.jsp" class="chosen">Teacher</a> <a
			href="subject-list.jsp">Subject</a> <a href="classroom-list.jsp">
			Class</a> <a href="report.jsp">Report</a>
	</nav>
	</br>
	</br>
	<h1>Add Teacher</h1>
	
	<form method="post" action= "AddTeacher">
		<fieldset>
			<legend>Add Teacher Form</legend>
			
			First Name : <input type="text" name="firstname" id="firstname" /> <br/>
			Last Name : <input type="text" name="lastname" id="lastname" /> <br/>
			
			<input type="submit" value = "Add"	/>
				
		</fieldset>
		
	</form></body>
</html>