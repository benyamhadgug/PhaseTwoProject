package com.simplilearn.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.StudentDAO;
import com.simplilearn.dao.TeacherDAO;
import com.simplilearn.entity.Student;
import com.simplilearn.entity.Teacher;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet(description = "Adds new Student to DB.", urlPatterns = { "/AddTeacher" })
public class TeacherAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherAddController() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Teacher teacher= new Teacher();
		teacher.setFirstName(request.getParameter("firstname"));
		teacher.setLastName(request.getParameter("lastname"));
		TeacherDAO.add(teacher);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("teacher-list.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
