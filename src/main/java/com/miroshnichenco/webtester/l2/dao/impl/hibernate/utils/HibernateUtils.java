package com.miroshnichenco.webtester.l2.dao.impl.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtils {
	private static final SessionFactory sessionFactory;
	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void close(){
		sessionFactory.close();
	}
}
