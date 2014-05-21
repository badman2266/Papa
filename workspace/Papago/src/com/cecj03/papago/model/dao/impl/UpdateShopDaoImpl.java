package com.cecj03.papago.model.dao.impl;

import java.util.*;

import org.hibernate.*;

import com.cecj03.papago.model.UpdateShop;
import com.cecj03.papago.model.dao.UpdateShopDao;

@SuppressWarnings("unchecked")
public class UpdateShopDaoImpl implements UpdateShopDao {
	
	private SessionFactory sessionFactory = null;
	
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSessionFactory() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<UpdateShop> select() {
		Session session = sessionFactory.openSession();
		List<UpdateShop> result = (List<UpdateShop>) session.createCriteria(UpdateShop.class).list();
		session.close();
		return result;
	}
	
	@Override
	public UpdateShop select(int updateId) {
		Session session = sessionFactory.openSession();
		UpdateShop result = (UpdateShop) session.get(UpdateShop.class, new Integer(updateId));
		session.close();
		return result;
	}
	
	@Override
	public List<UpdateShop> selectByHQL(String hql, Object... params) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		List<UpdateShop> result = query.list();
		session.close();
		return result;
	}
	
	@Override
	public UpdateShop insert(UpdateShop bean) {
		UpdateShop result = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(bean);
			transaction.commit();
			result = this.select(bean.getUpdateId());
		} catch (HibernateException ex) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return result;
	}
	
	@Override
	public UpdateShop update(UpdateShop bean) {
		UpdateShop result = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(bean);
			transaction.commit();
			result = this.select(bean.getUpdateId());
		} catch (HibernateException ex) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return result;
	}
	
	@Override
	public boolean delete(int updateId) {
		Session session = sessionFactory.openSession();
		UpdateShop bean = this.select(updateId);
		if (bean != null) {
			Transaction transaction = session.beginTransaction();
			try {
				session.delete(bean);
				transaction.commit();
				return true;
			} catch (HibernateException ex) {
				transaction.rollback();
				return false;
			} finally {
				session.close();
			}
		}
		return false;
	}
}
