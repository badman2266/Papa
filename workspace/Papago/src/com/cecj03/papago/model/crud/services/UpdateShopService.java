package com.cecj03.papago.model.crud.services;

import java.util.*;

import com.cecj03.papago.model.UpdateShop;
import com.cecj03.papago.model.dao.UpdateShopDao;

public class UpdateShopService {
	
	private UpdateShopDao dao;
	
	public void setDao(UpdateShopDao dao) {
		this.dao = dao;
	}
	
	public List<UpdateShop> select(UpdateShop bean) {
		List <UpdateShop> result = null;
		if (bean != null && bean.getUpdateId() != 0) {
			UpdateShop temp = dao.select(bean.getUpdateId());
			
			if (temp != null) {
				result = new ArrayList<UpdateShop>();
				result.add(temp);
			}
		} else {
			result = dao.select();
		}
		return result;
	}
	public UpdateShop insert(UpdateShop bean) {
		UpdateShop result = null;
		if (bean != null) {
			result = dao.insert(bean);
		}
		return result;
	}
	public UpdateShop update(UpdateShop bean) {
		UpdateShop result = null;
		if (bean != null) {
			result = dao.update(bean);
		}
		return result;
	}
	public boolean delete(UpdateShop bean) {
		boolean result = false;
		if (bean != null) {
			result = dao.delete(bean.getUpdateId());
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
	public UpdateShopService() {
		
	}
}
