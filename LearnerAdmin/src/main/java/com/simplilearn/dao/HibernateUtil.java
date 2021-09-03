package com.simplilearn.dao;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.entity.ClassRoom;
import com.simplilearn.entity.Student;
import com.simplilearn.entity.Subject;
import com.simplilearn.entity.Teacher;
import com.simplilearn.entity.SubjectClass;

public class HibernateUtil {
	public static SessionFactory sessionFactory;

	public static SessionFactory buildSessionFactory() {
		if (sessionFactory != null) {
			return sessionFactory;
		}
		sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(Subject.class)
				.addAnnotatedClass(ClassRoom.class)
				.addAnnotatedClass(SubjectClass.class)
				
				.buildSessionFactory();
		return sessionFactory;
	}
}