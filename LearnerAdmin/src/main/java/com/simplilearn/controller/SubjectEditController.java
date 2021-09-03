package com.simplilearn.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.ClassRoomDAO;
import com.simplilearn.dao.StudentDAO;
import com.simplilearn.dao.SubjectDAO;
import com.simplilearn.entity.ClassRoom;
import com.simplilearn.entity.Student;
import com.simplilearn.entity.Subject;

/**
 * Servlet implementation class EditStudent
 */
@WebServlet(description = "Edits existing student and persist to database.", urlPatterns = { "/EditSubject" })
public class SubjectEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.valueOf(request.getParameter("id"));
		Subject classroom= SubjectDAO.get(id);
		request.setAttribute("subject", classroom);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("subject-edit.jsp");
		requestDispatcher.forward(request, response);
//		response.sendRedirect("student-edit.jsp");
	}

}
