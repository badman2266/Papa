package com.cecj03.papago.model.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.cecj03.papago.model.PapaMsg;

public interface PapaMsgDao {

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract List<PapaMsg> select();

	public abstract PapaMsg select(int msgId);

	public abstract List<PapaMsg> selectByHQL(String hql, Object... params);

	public abstract PapaMsg insert(PapaMsg bean);

	public abstract PapaMsg update(PapaMsg bean);

	public abstract boolean delete(int PapaMsgId);

}