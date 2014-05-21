package com.cecj03.papago.model.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.cecj03.papago.model.UpdateShop;

public interface UpdateShopDao {

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract List<UpdateShop> select();

	public abstract UpdateShop select(int updateId);

	public abstract List<UpdateShop> selectByHQL(String hql, Object... params);

	public abstract UpdateShop insert(UpdateShop bean);

	public abstract UpdateShop update(UpdateShop bean);

	public abstract boolean delete(int updateId);

}