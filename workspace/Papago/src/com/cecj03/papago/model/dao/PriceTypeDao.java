package com.cecj03.papago.model.dao;

import java.util.List;

import com.cecj03.papago.model.PriceType;

public interface PriceTypeDao {

	public abstract List<PriceType> select();

	public abstract PriceType select(int pricetypeId);
	
	public List<PriceType> selectByHQL(String hql, Object... params);

	public abstract PriceType insert(PriceType bean);

	public abstract PriceType update(PriceType bean);

	public abstract boolean delete(int pricetypeId);

}