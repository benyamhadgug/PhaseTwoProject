<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.simplilearn.dao.TeacherDAO"%>
<%@page import="com.simplilearn.entity.Teacher"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Subject</title>
<link rel="stylesheet" href="style.css">

</head>
<body>
<%
	List<Teacher> classRooms = TeacherDAO.list();
	request.setAttribute("classRooms", classRooms);
%>
	<nav>
		<a href="index.jsp">Home</a> <a href="student-list.jsp"
			>Student</a> <a href="teacher-list.jsp">Teacher</a> <a
			href="subject-list.jsp" class="chosen">Subject</a> <a href="classroom-list.jsp">Class</a> <a href="report.jsp">Report</a>
	</nav>
	</br>
	</br>
	<h1>Add Subject</h1>
	
	<form method="post" action= "AddSubject">
		<fieldset>
			<legend>Add Subject Form</legend>
			
			Name : <input type="text" name="name" id="name" /> <br/>
			Teacher: <select name="teacher">
		    <c:forEach items="${classRooms}" var="cls">
		    	
		        <option value="${cls.getId()}">${cls.getDisplayString()}</option>
		    </c:forEach>
			</select><br/>
			<input type="submit" value = "Add"	/>
				
		</fieldset>
		
	</form></body>
</html>