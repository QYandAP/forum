package com.apefactory.forum.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class BaseDao<T> {

	private final String GET_USER_BY_USERNAME = "from User u where u.userName = :userName";

	private final String QUERY_USER_BY_USERNAME = "from User u where u.userName like :userName";

	private Class<T> entityClass;

	@Resource
	private SessionFactory sessionFactory;

	public BaseDao() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class) params[0];
	}

	public Session openSession(){
		return sessionFactory.openSession();
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}


	public void save(T entity) {
		getSession().save(entity);
	}


	public void delete(T entity) {
		getSession().delete(entity);
	}


	public void update(T entity) {
		getSession().update(entity);
	}


	public T getById(Integer id) {
		if (id == null) {
			return null;
		} else {
			return (T) getSession().get(entityClass, id);
		}
	}


	public T getByName(String name) {
		Iterator iter = openSession().createQuery(GET_USER_BY_USERNAME).setParameter("userName", name).iterate();
		if (iter.hasNext()) {
			return (T) iter.next();
		} else {
			return null;
		}
	}


	public List<T> getALL() {
		return openSession().createQuery("from "+entityClass.getSimpleName()).list();
	}


}
