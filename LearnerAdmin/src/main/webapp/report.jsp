<%@page import="com.simplilearn.dao.ClassRoomDAO"%>
<%@page import="com.simplilearn.entity.ClassRoom"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Report</title>
<link rel="stylesheet" href="style.css">

</head>
<body>

<%
	List<ClassRoom> classrooms = ClassRoomDAO.list();
	request.setAttribute("classrooms", classrooms);
%>

	<nav>
		<a href="index.jsp">Home</a> <a href="student-list.jsp"
			>Student</a> <a href="teacher-list.jsp">Teacher</a> <a
			href="subject-list.jsp">Subject</a> <a href="classroom-list.jsp">
			Class</a> <a href="report.jsp" class="chosen">Report</a>
	</nav>
	</br>
	
	<table style="border: 1px solid black;">
		<tr>
			<th>Class Name</th>
			<th>Number of Students</th>
			<th>Number of Subjects </th>
		</tr>


		<core:forEach items="${classrooms}" var="cls">
			<tr>
				<td>${cls.getName()}</td>
				<td class="centerme">${cls.getStudents().size()}</td>
				<td class="centerme">${cls.getClassRooms().size()}</td>

			</tr>
		</core:forEach>
	</table>
</body>
</html>