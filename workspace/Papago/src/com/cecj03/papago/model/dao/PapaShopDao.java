package com.cecj03.papago.model.dao;

import java.util.List;

import com.cecj03.papago.model.PapaShop;

public interface PapaShopDao {
	public abstract PapaShop select(int id);

	public abstract List<PapaShop> select();

	public abstract boolean delete(int id);

	public abstract PapaShop update(PapaShop bean);

	public abstract PapaShop insert(PapaShop bean);
}
