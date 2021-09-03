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
import com.simplilearn.dao.TeacherDAO;
import com.simplilearn.entity.ClassRoom;
import com.simplilearn.entity.Student;
import com.simplilearn.entity.Subject;
import com.simplilearn.entity.Teacher;

/**
 * Servlet implementation class StudentUpdateController
 */
@WebServlet("/UpdateSubject")
public class SubjectUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Subject subject= new Subject();
		subject.setId(Integer.valueOf(request.getParameter("id")));
		subject.setName(request.getParameter("name"));
		Teacher teacherObj= TeacherDAO.get(Integer.valueOf(request.getParameter("teacher")));
		subject.setTeacher(teacherObj);
		SubjectDAO.update(subject);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("subject-list.jsp");
		requestDispatcher.forward(request, response);
	}

}
