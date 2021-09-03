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
<title>Class list</title>
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
			href="subject-list.jsp">Subject</a> <a href="classroom-list.jsp" class="chosen">Class</a> <a href="report.jsp">Report</a>
	</nav>
	</br>
	</br>
	<h1> Classes </h1>
	<h4><a href="classroom-add.jsp" >Add New </></a></h4>
	<table style="border: 1px solid black;">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>#</th>
		</tr>


		<core:forEach items="${classrooms}" var="cls">
			<tr>
				<td>${cls.getId()}</td>
				<td>${cls.getName()}</td>
				<td><a href="EditClassRoom?id=${cls.getId()}"> Edit &nbsp; |&nbsp; </a> <a
					href="DeleteClassRoom?id=${cls.getId()}"> Delete  &nbsp; |&nbsp; </a>
					<a href="AddSubjectClassRoom?id=${cls.getId()}"> Add Subject  &nbsp; |&nbsp; </a>
				</td>
			</tr>
		</core:forEach>
	</table>
</body>
</html>