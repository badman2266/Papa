package com.cecj03.papago.model.dao.impl;

import java.util.*;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import com.cecj03.papago.model.PriceType;
import com.cecj03.papago.model.dao.PriceTypeDao;

@SuppressWarnings("unchecked")
public class PriceTypeDaoImpl implements PriceTypeDao {
	
	private SessionFactory sessionFactory = null;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSessionFactory() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<PriceType> select() {
		List<PriceType> result = null;
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(PriceType.class);
		
		Iterator beans = criteria.list().iterator();
		result = new ArrayList<PriceType>();
		while (beans.hasNext()) {
			PriceType bean = (PriceType) beans.next();
			result.add(bean);
		}
		session.close();
		return result;
	}
	
	@Override
	public PriceType select(int pricetypeId) {
		PriceType result = null;
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(PriceType.class);
		criteria.add(Restrictions.eq("pricetypeId", pricetypeId));
		Iterator beans = criteria.list().iterator();
		while (beans.hasNext()) {
			result = (PriceType) beans.next();
		}
		session.close();
		return result;
	}
	
	@Override
	public List<PriceType> selectByHQL(String hql, Object... params) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		List<PriceType> result = query.list();
		session.close();
		return result;
	}
	
	@Override
	public PriceType insert(PriceType bean) {
		PriceType result = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(bean);
			transaction.commit();
			result = this.select(bean.getPricetypeId());
		} catch (HibernateException ex) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return result;
	}
	
	@Override
	public PriceType update(PriceType bean) {
		PriceType result = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(bean);
			transaction.commit();
			result = this.select(bean.getPricetypeId());
		} catch (HibernateException ex) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return result;
	}
	
	@Override
	public boolean delete(int pricetypeId) {
		Session session = sessionFactory.openSession();
		PriceType bean = this.select(pricetypeId);
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
