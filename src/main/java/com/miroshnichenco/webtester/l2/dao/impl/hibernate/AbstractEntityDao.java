package com.miroshnichenco.webtester.l2.dao.impl.hibernate;

import java.io.Serializable;
import java.sql.Connection;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.miroshnichenco.webtester.l2.dao.IEntityDao;




public abstract class AbstractEntityDao<T> implements IEntityDao<T> {
	//protected final Logger LOGGER = Logger.getLogger(getClass());
	//protected SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

	
	@Autowired
	protected SessionFactory sessionFactory;

	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
		//return sessionFactory.openSession();
	}
	@Override
	public Serializable save(T entity) {
		return getSession().save(entity);

	}

	@Override
	public void update(T entity) {
		getSession().update(entity);

	}

	@Override
	public void delete(T entity) {
		getSession().delete(entity);

	}

	@Override
	public void remove(T entity) {
		delete(entity);
	}
	
	//Id is serialisable because it may be  Long or String or anything
	@Override
	public T findByID(Serializable id) {
		T res = (T) getSession().get(getEntityClass(), id);
		return res;
	}
	//In order to make findByID() common
 	protected abstract Class getEntityClass() ;
	
	
	@Override
	public List<T> finfAll() {
		
		return (List<T>) getSession().createQuery("from " + getEntityClass().getName()).list();
	}

}
