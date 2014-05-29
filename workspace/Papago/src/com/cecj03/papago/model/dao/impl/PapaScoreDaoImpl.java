package com.cecj03.papago.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.cecj03.papago.model.PapaScore;
import com.cecj03.papago.model.dao.PapaScoreDao;

public class PapaScoreDaoImpl extends GenericDaoImpl<PapaScore> implements PapaScoreDao {

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PapaScore> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PapaScore select(int scoreId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PapaScore> selectByHQL(String hql, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PapaScore insert(PapaScore bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PapaScore update(PapaScore bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int scoreId) {
		// TODO Auto-generated method stub
		return false;
	}

}
