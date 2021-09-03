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
	List<Subject> classrooms = SubjectDAO.list();
	request.setAttribute("subjects", classrooms);
%>

	<nav>
		<a href="index.jsp">Home</a> <a href="student-list.jsp"
			>Student</a> <a href="teacher-list.jsp">Teacher</a> <a
			href="subject-list.jsp" class="chosen">Subject</a> <a href="classroom-list.jsp">Class</a> <a href="report.jsp">Report</a>
	</nav>
	</br>
	</br>
	<h1> Subjects </h1>
	<h4><a href="subject-add.jsp" >Add New </></a></h4>
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
				<td><a href="EditSubject?id=${sbj.getId()}"> Edit &nbsp; |&nbsp; </a> <a
					href="DeleteSubject?id=${sbj.getId()}"> Delete </a></td>
			</tr>
		</core:forEach>
	</table>
</body>
</html>