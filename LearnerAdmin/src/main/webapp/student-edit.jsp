<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.simplilearn.entity.Student"%>
<%@page import="com.simplilearn.dao.ClassRoomDAO"%>
<%@page import="com.simplilearn.entity.ClassRoom"%>
<%@page import="java.util.List"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>
<link rel="stylesheet" href="style.css">

</head>
<body>
<%
	Student student= (Student)request.getAttribute("student");
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
	<h1>Edit Student</h1>
	
	<form method="post" action= "UpdateStudent">
		<fieldset>
			<legend>Edit Student Form</legend>
			
			<input type="hidden" name="id" id="id" value="<%= student.getId() %>" /> <br/>
			First Name : <input type="text" name="firstname" id="firstname" value="<%= student.getFirstName()%>" /> <br/>
			Last Name : <input type="text" name="lastname" id="lastname" value="<%= student.getLastName()%>" /> <br/>
			Class: <select name="class">
		    <c:forEach items="${classRooms}" var="cls">
		    	
		        <option value="${cls.getId()}">${cls.getDisplayString()}</option>
		    </c:forEach>
			</select><br/>
			<input type="submit" value = "Update"	/>
				
		</fieldset>
		
	</form></body>
</html>