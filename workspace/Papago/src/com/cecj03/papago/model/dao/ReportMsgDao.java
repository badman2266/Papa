package com.cecj03.papago.model.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.cecj03.papago.model.ReportMsg;

public interface ReportMsgDao {

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract List<ReportMsg> select();

	public abstract ReportMsg select(int repId);

	public abstract List<ReportMsg> selectByHQL(String hql, Object... params);

	public abstract ReportMsg insert(ReportMsg bean);

	public abstract ReportMsg update(ReportMsg bean);

	public abstract boolean delete(int repId);

}