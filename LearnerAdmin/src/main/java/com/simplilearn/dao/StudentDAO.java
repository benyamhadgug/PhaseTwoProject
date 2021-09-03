package com.simplilearn.dao;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;

import com.simplilearn.entity.Student;

public class StudentDAO {
	public static void add(Student e) {
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
	public static List<Student> list() {
		Session session = null;
		List<Student> elements = null;
		try {
			// 1. Build session factory
			SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
			//2. Create session object
			session = sessionFactory.openSession();
			
			//3. Define Query and execute it
			elements = session.createQuery("from Student e").list();
			
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return elements;
	}
	public static void update(Student e) {
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
	public static Student get(int id) {
		
		Session session = null;
		Student e=null;
		try {
			// 1. Build session factory
			SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
			//2. Create session object
			session = sessionFactory.openSession();

			return (Student) session.get(Student.class, id);
			
			
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return e;
	}
	public static void delete(Student e) {
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