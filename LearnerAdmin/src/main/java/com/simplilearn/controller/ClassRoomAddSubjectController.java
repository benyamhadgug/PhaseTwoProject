package com.simplilearn.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.ClassRoomDAO;
import com.simplilearn.entity.ClassRoom;

/**
 * Servlet implementation class ClassRoomAddSubjectController
 */
@WebServlet("/AddSubjectClassRoom")
public class ClassRoomAddSubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassRoomAddSubjectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.valueOf(request.getParameter("id"));
		ClassRoom classroom= ClassRoomDAO.get(id);
		request.setAttribute("classroom", classroom);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("classroom-addsubject.jsp");
		requestDispatcher.forward(request, response);
//		response.sendRedirect("student-edit.jsp");
	}

}
