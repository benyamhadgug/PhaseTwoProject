package com.simplilearn.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.entity.Student;
import com.simplilearn.entity.Teacher;

public class TeacherDAO {
	public static void add(Teacher e) {
		Session session = null;
		try {
			// 1. Build session factory
			SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
			//2. Create session object
			session = sessionFactory.openSession();
			session.getTransaction().begin();;
			session.save(e);
			
			session.getTransaction().commit();
			
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<Teacher> list() {
		Session session = null;
		List<Teacher> elements = null;
		try {
			// 1. Build session factory
			SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
			//2. Create session object
			session = sessionFactory.openSession();
			
			//3. Define Query and execute it
			elements = session.createQuery("from Teacher e").list();
			
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return elements;
	}
	public static void update(Teacher e) {
		Session session = null;
		try {
			// 1. Build session factory
			SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
			//2. Create session object
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.update(e);
			session.getTransaction().commit();
			
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	public static Teacher get(int id) {
		
		Session session = null;
		Teacher e=null;
		try {
			// 1. Build session factory
			SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
			//2. Create session object
			session = sessionFactory.openSession();

			return (Teacher) session.get(Teacher.class, id);
			
			
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return e;
	}
	public static void delete(Teacher e) {
		Session session = null;
		try {
			// 1. Build session factory
			SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
			//2. Create session object
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.delete(e);
			session.getTransaction().commit();
			
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}	
}