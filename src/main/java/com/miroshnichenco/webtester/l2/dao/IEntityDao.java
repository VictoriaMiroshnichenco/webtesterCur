package com.miroshnichenco.webtester.l2.dao;

import java.io.Serializable;
import java.util.List;

public interface IEntityDao<T> {
	
	public Serializable save(T entity);
	
	public void update(T entity);
	
	public void delete (T entity);
	
	public void remove (T entity);
	
	public T findByID(Serializable id);
	
	public List<T> finfAll();
	
}
