package com.cecj03.papago.model.dao.impl;

import java.util.*;

import org.hibernate.*;

import com.cecj03.papago.model.PapaMsg;
import com.cecj03.papago.model.dao.PapaMsgDao;

@SuppressWarnings("unchecked")
public class PapaMsgDaoImpl implements PapaMsgDao {
	
	private SessionFactory sessionFactory = null;
	
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSessionFactory() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<PapaMsg> select() {
		Session session = sessionFactory.openSession();
		List<PapaMsg> result = (List<PapaMsg>) session.createCriteria(PapaMsg.class).list();
		session.close();
		return result;
	}
	
	@Override
	public PapaMsg select(int msgId) {
		Session session = sessionFactory.openSession();
		PapaMsg result = (PapaMsg) session.get(PapaMsg.class, new Integer(msgId));
		session.close();
		return result;
	}
	
	@Override
	public List<PapaMsg> selectByHQL(String hql, Object... params) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		List<PapaMsg> result = query.list();
		session.close();
		return result;
	}
	
	@Override
	public PapaMsg insert(PapaMsg bean) {
		PapaMsg result = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(bean);
			transaction.commit();
			result = this.select(bean.getMsgId());
		} catch (HibernateException ex) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return result;
	}
	
	@Override
	public PapaMsg update(PapaMsg bean) {
		PapaMsg result = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(bean);
			transaction.commit();
			result = this.select(bean.getMsgId());
		} catch (HibernateException ex) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return result;
	}
	
	@Override
	public boolean delete(int msgId) {
		Session session = sessionFactory.openSession();
		PapaMsg bean = this.select(msgId);
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
