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
import com.simplilearn.entity.ClassRoom;
import com.simplilearn.entity.Student;

/**
 * Servlet implementation class StudentUpdateController
 */
@WebServlet("/UpdateClassRoom")
public class ClassRoomUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassRoomUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassRoom classroom= new ClassRoom();
		classroom.setId(Integer.valueOf(request.getParameter("id")));
		classroom.setName(request.getParameter("name"));
		ClassRoomDAO.update(classroom);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("classroom-list.jsp");
		requestDispatcher.forward(request, response);
	}

}
