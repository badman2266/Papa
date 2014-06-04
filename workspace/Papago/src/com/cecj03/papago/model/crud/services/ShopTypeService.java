package com.cecj03.papago.model.crud.services;

import java.util.*;

import com.cecj03.papago.model.ShopType;
import com.cecj03.papago.model.dao.ShopTypeDao;

public class ShopTypeService {
	
	private ShopTypeDao dao;
	
	public void setDao(ShopTypeDao dao) {
		this.dao = dao;
	}
	
	public List<ShopType> select(ShopType bean) {
		List <ShopType> result = null;
		if (bean != null && bean.getShoptypeId() != 0) {
			ShopType temp = dao.findById(bean.getShoptypeId());
			
			if (temp != null) {
				result = new ArrayList<ShopType>();
				result.add(temp);
			}
		} else {
			result = dao.findAll();
		}
		return result;
	}
	public ShopType insert(ShopType bean) {
		ShopType result = null;
		if (bean != null) {
			result = dao.insert(bean);
		}
		return result;
	}
	public ShopType update(ShopType bean) {
		ShopType result = null;
		if (bean != null) {
			result = dao.update(bean);
		}
		return result;
	}
	public boolean delete(ShopType bean) {
		boolean result = false;
		if (bean != null) {
			result = dao.delete(bean.getShoptypeId());
		}
		return result;
	}
	public int convertInt(String data) {
		int result = 0;
		try {
			result = Integer.parseInt(data);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			result = -1000;
		}
		return result;
	}
	public ShopTypeService() {
		
	}
}
