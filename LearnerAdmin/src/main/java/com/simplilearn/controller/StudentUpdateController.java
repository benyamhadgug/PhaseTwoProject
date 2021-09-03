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
@WebServlet("/UpdateStudent")
public class StudentUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student= new Student();
		student.setId(Integer.valueOf(request.getParameter("id")));
		student.setFirstName(request.getParameter("firstname"));
		student.setLastName(request.getParameter("lastname"));
		String classroom= request.getParameter("class");
		ClassRoom classRoomObj= ClassRoomDAO.get(Integer.valueOf(classroom));
		student.setClassRoom(classRoomObj);
		StudentDAO.update(student);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("student-list.jsp");
		requestDispatcher.forward(request, response);
	}

}
