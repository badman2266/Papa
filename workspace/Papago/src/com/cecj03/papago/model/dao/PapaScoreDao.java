package com.cecj03.papago.model.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.cecj03.papago.model.PapaScore;

public interface PapaScoreDao {

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract List<PapaScore> select();

	public abstract PapaScore select(int scoreId);

	public abstract List<PapaScore> selectByHQL(String hql, Object... params);

	public abstract PapaScore insert(PapaScore bean);

	public abstract PapaScore update(PapaScore bean);

	public abstract boolean delete(int scoreId);

}