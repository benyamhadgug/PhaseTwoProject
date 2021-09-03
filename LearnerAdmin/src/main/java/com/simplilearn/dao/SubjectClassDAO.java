package com.simplilearn.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.entity.SubjectClass;

public class SubjectClassDAO {
	public static void add(SubjectClass e) {
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
}
