package com.cecj03.papago.model.dao;

import java.util.List;

/*
 * 通用層的定義
 */

public interface GenericDao<T> {

	public T findById(int id);

	public List<T> findAll();
	
	public List<T> findByHQL(String hql, Object... params);//Object 後面的參數... 代表無限加 

	public T insert(T entity);

	public T update(T entity);

	public boolean delete(int id);
}
