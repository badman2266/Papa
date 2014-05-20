package com.cecj03.papago.model.dao;

import java.util.List;

import com.cecj03.papago.model.entity.PriceType;

public interface PriceTypeDao {

	public abstract List<PriceType> select();

	public abstract PriceType select(int pricetypeId);

	public abstract PriceType insert(PriceType bean);

	public abstract PriceType update(PriceType bean);

	public abstract boolean delete(int pricetypeId);

}