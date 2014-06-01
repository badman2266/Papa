package com.cecj03.papago.model.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cecj03.papago.model.PapaMem;
import com.cecj03.papago.model.PapaShop;
import com.cecj03.papago.model.dao.PapaShopDao;



public  class PapaShopDaoImpl extends GenericDaoImpl<PapaShop> implements PapaShopDao {
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
	public PapaShop select(int shopId) {
		Session session = sessionFactory.openSession();
		PapaShop result = (PapaShop) session.get(PapaShop.class, new Integer(shopId));
		session.close();
		return result;
	}

	@Override
	public List<PapaShop> select() {
		//Session session = sessionFactory.openSession();
		 Session session = sessionFactory.openSession();
		List<PapaShop> result = (List<PapaShop>) session.createCriteria(PapaShop.class).list();
		
		session.close();
		return result;
//		List<PapaShop> result = null;
//		Session session = sessionFactory.openSession();
//		Criteria criteria = session.createCriteria(PapaShop.class);
//		Iterator beans = criteria.list().iterator();
//		result = new ArrayList<PapaShop>();
//		while (beans.hasNext()) {
//			PapaShop temp = new PapaShop();
//			temp = (PapaShop) beans.next();
//
//			result.add(temp);
//
//		}
//
//		session.close();
//		
//		return result;
	}

	@Override
	public boolean delete(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		PapaShop entity=this.select(id);
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
	}

	@Override
	public PapaShop update(PapaShop bean) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(bean);
			tx.commit();
			return bean;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PapaShop> selectByHQL(String hql, Object... params) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		List<PapaShop> result = query.list();
		session.close();
		return result;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<PapaShop> selectLikeHQL(String hql) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		List<PapaShop> result = query.list();
		session.close();
		return result;
	}
	
	
	@Override
	public PapaShop insert(PapaShop bean) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(bean);
			tx.commit();
			return bean;
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		
	}
	public PapaShopDaoImpl(){
		
	}
	public static void main(String arg[]){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		PapaShopDaoImpl dao = (PapaShopDaoImpl)context.getBean("PapaShopDao");

	}
}
