package com.cecj03.papago.model.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cecj03.papago.model.dao.GenericDao;

/*
 * 實做層
 */
@SuppressWarnings("unchecked")
public class GenericDaoImpl<T> implements GenericDao<T> {

	private Class<T> clazz;

	/**
	 * 通過建構子指定DAO的具體實現類
	 */
	public GenericDaoImpl() {
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
		clazz=(Class<T>) type.getActualTypeArguments()[0];
		System.out.println("DAO的真實實現類是：" + this.clazz.getName());  
	}
	
	private SessionFactory sessionFactory = null;

	//注入spring
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//拿到session
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public T findById(int id) {
		//Session session = DefaultFactory.getSessionFactory().openSession();
		Session session= sessionFactory.openSession();
		T result= (T) session.get(clazz, new Integer(id));
		session.close();
		return result;
	}

	@Override
	public List<T> findAll() {
		//Session session = DefaultFactory.getSessionFactory().openSession();
		Session session= sessionFactory.openSession();
		List<T> result= (List<T>) session.createCriteria(this.clazz).list();
		session.close();
		return result;
	}

	@Override
	public List<T> findByHQL(String hql, Object... params) {
		Session session = sessionFactory.openSession();
		Query query=session.createQuery(hql);
	
		for(int i=0; params!=null && i<params.length; i++){
			query.setParameter(i, params[i]);
		}
		List<T> result = query.list();
		session.close();
		return result;
	}

	@Override
	public T insert(T entity) {
		//Session session = DefaultFactory.getSessionFactory().openSession();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(entity);
			tx.commit();
			return entity;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}

	@Override
	public T update(T entity) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(entity);
			tx.commit();
			return entity;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}

	@Override
	public boolean delete(int id) {
		//Session session = DefaultFactory.getSessionFactory().openSession();
		Session session = sessionFactory.getCurrentSession();
		T entity=this.findById(id);
		if(entity!=null){
			Transaction tx = session.beginTransaction();
			try {
				session.delete(entity);
				tx.commit();
				return true;
			} catch (HibernateException e) {
				tx.rollback();
				e.printStackTrace();
				System.out.println("deleting fail on Transaction");
				return false;
			} finally {
				session.close();
			}
		}else{
			System.out.println("there's nothing to delete!");
			return false;
		}
	}

}
