package com.simplilearn.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.entity.ClassRoom;
import com.simplilearn.entity.Subject;

public class SubjectDAO {
	public static void add(Subject e) {
		Session session = null;
		try {
			// 1. Build session factory
			SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
			//2. Create session object
			session = sessionFactory.openSession();
			session.getTransaction().begin();
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
	public static List<Subject> list() {
		Session session = null;
		List<Subject> elements = null;
		try {
			// 1. Build session factory
			SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
			//2. Create session object
			session = sessionFactory.openSession();
			
			//3. Define Query and execute it
			elements = session.createQuery("from Subject e").list();
			
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return elements;
	}
	public static void update(Subject e) {
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
	public static Subject get(int id) {
		
		Session session = null;
		Subject e=null;
		try {
			// 1. Build session factory
			SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
			//2. Create session object
			session = sessionFactory.openSession();

			return (Subject) session.get(Subject.class, id);
			
			
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return e;
	}
	public static void delete(Subject e) {
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