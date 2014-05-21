package com.cecj03.papago.model.dao.impl;

import java.util.*;

import org.hibernate.*;

import com.cecj03.papago.model.ReportMsg;
import com.cecj03.papago.model.dao.ReportMsgDao;

@SuppressWarnings("unchecked")
public class ReportMsgDaoImpl implements ReportMsgDao {
	
	private SessionFactory sessionFactory = null;
	
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSessionFactory() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<ReportMsg> select() {
		Session session = sessionFactory.openSession();
		List<ReportMsg> result = (List<ReportMsg>) session.createCriteria(ReportMsg.class).list();
		session.close();
		return result;
	}
	
	@Override
	public ReportMsg select(int repId) {
		Session session = sessionFactory.openSession();
		ReportMsg result = (ReportMsg) session.get(ReportMsg.class, new Integer(repId));
		session.close();
		return result;
	}
	
	@Override
	public List<ReportMsg> selectByHQL(String hql, Object... params) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		List<ReportMsg> result = query.list();
		session.close();
		return result;
	}
	
	@Override
	public ReportMsg insert(ReportMsg bean) {
		ReportMsg result = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(bean);
			transaction.commit();
			result = this.select(bean.getRepId());
		} catch (HibernateException ex) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return result;
	}
	
	@Override
	public ReportMsg update(ReportMsg bean) {
		ReportMsg result = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(bean);
			transaction.commit();
			result = this.select(bean.getRepId());
		} catch (HibernateException ex) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return result;
	}
	
	@Override
	public boolean delete(int ReportMsgId) {
		Session session = sessionFactory.openSession();
		ReportMsg bean = this.select(ReportMsgId);
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
