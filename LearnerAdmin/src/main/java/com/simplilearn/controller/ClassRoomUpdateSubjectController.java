package com.simplilearn.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.ClassRoomDAO;
import com.simplilearn.dao.SubjectClassDAO;
import com.simplilearn.dao.SubjectDAO;
import com.simplilearn.entity.ClassRoom;
import com.simplilearn.entity.ClassSubjectKey;
import com.simplilearn.entity.Subject;
import com.simplilearn.entity.SubjectClass;

/**
 * Servlet implementation class ClassRoomUpdateSubjectController
 */
@WebServlet("/addsubjecttoclassroom")
public class ClassRoomUpdateSubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassRoomUpdateSubjectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int classId= Integer.valueOf(request.getParameter("class"));
		int subjectId= Integer.valueOf(request.getParameter("subject"));
		ClassRoom classRoom= ClassRoomDAO.get(classId);
		Subject subject= SubjectDAO.get(subjectId);
		ClassSubjectKey key= new ClassSubjectKey(classRoom.getId(), subject.getId());
		SubjectClass subjectClass= new SubjectClass();
		subjectClass.setId(key);
		subjectClass.setClassRoom(classRoom);
		subjectClass.setSubject(subject);
		classRoom.getClassRooms().add(subjectClass);
		subject.getClassRooms().add(subjectClass);
		
		SubjectClassDAO.add(subjectClass);
		ClassRoomDAO.update(classRoom);
		SubjectDAO.update(subject);
		request.setAttribute("classroom", classRoom);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("classroom-addsubject.jsp");
		requestDispatcher.forward(request, response);
	}

}
