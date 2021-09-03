<%@page import="com.simplilearn.dao.StudentDAO"%>
<%@page import="com.simplilearn.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student list</title>
<link rel="stylesheet" href="style.css">

</head>
<body>

<%
	List<Student> students = StudentDAO.list();
	request.setAttribute("students", students);
%>

	<nav>
		<a href="index.jsp">Home</a> <a href="student-list.jsp"
			class="chosen">Student</a> <a href="teacher-list.jsp">Teacher</a> <a
			href="subject-list.jsp">Subject</a> <a href="classroom-list.jsp">
			Class</a> <a href="report.jsp">Report</a>
	</nav>
	</br>
	</br>
	<h1> Students </h1>
	<h4><a href="student-add.jsp" >Add New </></a></h4>
	<table style="border: 1px solid black;">
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Class Detail</th>
			<th>#</th>
		</tr>


		<core:forEach items="${students}" var="stud">
			<tr>
				<td>${stud.getId()}</td>
				<td>${stud.getFirstName()}</td>
				<td>${stud.getLastName()}</td>
				<td>${stud.getClassRoom().getDisplayString()}</td>
				<td><a href="EditStudent?id=${stud.getId()}"> Edit &nbsp; |&nbsp; </a> <a
					href="DeleteStudent?id=${stud.getId()}"> Delete </a></td>
			</tr>
		</core:forEach>
	</table>
</body>
</html>