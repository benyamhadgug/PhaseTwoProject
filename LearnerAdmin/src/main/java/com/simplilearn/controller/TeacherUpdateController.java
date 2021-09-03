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
 * Servlet implementation class TeacherUpdateController
 */
@WebServlet("/UpdateTeacher")
public class TeacherUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Teacher student= new Teacher();
		student.setId(Integer.valueOf(request.getParameter("id")));
		student.setFirstName(request.getParameter("firstname"));
		student.setLastName(request.getParameter("lastname"));
		TeacherDAO.update(student);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("teacher-list.jsp");
		requestDispatcher.forward(request, response);
	}

}
