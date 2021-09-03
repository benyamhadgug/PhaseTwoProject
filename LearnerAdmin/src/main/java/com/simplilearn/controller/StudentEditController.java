package com.simplilearn.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.StudentDAO;
import com.simplilearn.entity.Student;

/**
 * Servlet implementation class EditStudent
 */
@WebServlet(description = "Edits existing student and persist to database.", urlPatterns = { "/EditStudent" })
public class StudentEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.valueOf(request.getParameter("id"));
		System.out.println("id string = " + id);
		Student student= StudentDAO.get(id);

		request.setAttribute("student", student);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("student-edit.jsp");
		requestDispatcher.forward(request, response);
//		response.sendRedirect("student-edit.jsp");
	}

}
