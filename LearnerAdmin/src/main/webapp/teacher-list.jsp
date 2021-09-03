<%@page import="com.simplilearn.dao.TeacherDAO"%>
<%@page import="com.simplilearn.entity.Teacher"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher list</title>
<link rel="stylesheet" href="style.css">

</head>
<body>

<%
	List<Teacher> students = TeacherDAO.list();
	request.setAttribute("students", students);
%>

	<nav>
		<a href="index.jsp">Home</a> <a href="student-list.jsp"
			>Student</a> <a href="teacher-list.jsp" class="chosen">Teacher</a> <a
			href="subject-list.jsp">Subject</a> <a href="classroom-list.jsp">
			Class</a> <a href="report.jsp">Report</a>
	</nav>
	</br>
	</br>
	<h1> Teachers </h1>
	<h4><a href="teacher-add.jsp" >Add New </></a></h4>
	<table style="border: 1px solid black;">
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>#</th>
		</tr>


		<core:forEach items="${students}" var="stud">
			<tr>
				<td>${stud.getId()}</td>
				<td>${stud.getFirstName()}</td>
				<td>${stud.getLastName()}</td>
				<td><a href="EditTeacher?id=${stud.getId()}"> Edit &nbsp; |&nbsp; </a> <a
					href="DeleteTeacher?id=${stud.getId()}"> Delete </a></td>
			</tr>
		</core:forEach>
	</table>
</body>
</html>