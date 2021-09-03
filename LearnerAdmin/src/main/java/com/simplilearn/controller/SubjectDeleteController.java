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
 * Servlet implementation class StudentDeleteController
 */
@WebServlet("/DeleteSubject")
public class SubjectDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Subject student= new Subject();
		student.setId(Integer.valueOf(request.getParameter("id")));
		student.setName(request.getParameter("name"));
		SubjectDAO.delete(student);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("subject-list.jsp");
		requestDispatcher.forward(request, response);
	}

}
