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
 * Servlet implementation class EditStudent
 */
@WebServlet(description = "Edits existing student and persist to database.", urlPatterns = { "/EditTeacher" })
public class TeacherEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.valueOf(request.getParameter("id"));
		Teacher student= TeacherDAO.get(id);
		request.setAttribute("teacher", student);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("teacher-edit.jsp");
		requestDispatcher.forward(request, response);
//		response.sendRedirect("student-edit.jsp");
	}

}
