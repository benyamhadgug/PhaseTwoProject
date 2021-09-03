package com.simplilearn.dao;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;

import com.simplilearn.entity.ClassRoom;
import com.simplilearn.entity.Student;

public class ClassRoomDAO {
	public static void add(ClassRoom e) {
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
	public static List<ClassRoom> list() {
		Session session = null;
		List<ClassRoom> elements = null;
		try {
			// 1. Build session factory
			SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
			//2. Create session object
			session = sessionFactory.openSession();
			
			//3. Define Query and execute it
			elements = session.createQuery("from ClassRoom e").list();
			
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return elements;
	}
	public static void update(ClassRoom e) {
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
	public static ClassRoom get(int id) {
		
		Session session = null;
		ClassRoom e=null;
		try {
			// 1. Build session factory
			SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
			//2. Create session object
			session = sessionFactory.openSession();

			return (ClassRoom) session.get(ClassRoom.class, id);
			
			
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return e;
	}
	public static void delete(ClassRoom e) {
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