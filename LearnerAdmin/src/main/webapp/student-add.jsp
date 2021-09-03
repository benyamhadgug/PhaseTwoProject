<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.simplilearn.dao.ClassRoomDAO"%>
<%@page import="com.simplilearn.entity.ClassRoom"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
<link rel="stylesheet" href="style.css">

</head>
<body>
<%
	List<ClassRoom> classRooms = ClassRoomDAO.list();
	request.setAttribute("classRooms", classRooms);
%>
	<nav>
		<a href="index.jsp">Home</a> <a href="student-list.jsp"
			class="chosen">Student</a> <a href="teacher-list.jsp">Teacher</a> <a
			href="subject-list.jsp">Subject</a> <a href="classroom-list.jsp">
			Class</a> <a href="report.jsp">Report</a>
	</nav>
	</br>
	</br>
	<h1>Add Student</h1>
	
	<form method="post" action= "AddStudent">
		<fieldset>
			<legend>Add Student Form</legend>
			
			First Name : <input type="text" name="firstname" id="firstname" /> <br/>
			Last Name : <input type="text" name="lastname" id="lastname" /> <br/>
			Class: <select name="class">
		    <c:forEach items="${classRooms}" var="cls">
		    	
		        <option value="${cls.getId()}">${cls.getDisplayString()}</option>
		    </c:forEach>
			</select><br/>
			<input type="submit" value = "Add"	/>
				
		</fieldset>
		
	</form></body>
</html>