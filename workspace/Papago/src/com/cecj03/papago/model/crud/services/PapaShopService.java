package com.cecj03.papago.model.crud.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.cecj03.papago.model.PapaShop;
import com.cecj03.papago.model.PriceType;
import com.cecj03.papago.model.ShopStatusType;
import com.cecj03.papago.model.ShopType;
import com.cecj03.papago.model.dao.PapaShopDao;
import com.cecj03.papago.model.dao.impl.PapaShopDaoImpl;


public class PapaShopService {
	private PapaShopDao dao;
	
	public void setDao(PapaShopDao dao) {
		this.dao = dao;
	}
	
	@Transactional
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
	
	@Transactional
	public List<PapaShop> like(String name) {
		List <PapaShop> result = null;
		if (name != null && name.length() != 0) {
			result = dao.selectLikeHQL("from PapaShop P where P.name like '%"+name+"%'");
		}
		return result;
	}
	
	@Transactional
	public PapaShop insertShop(PapaShop bean) {
		PapaShop result = dao.insert(bean);
		if(result!=null) {
			return result;
		}
		return result;
	}
	
	@Transactional
	public PapaShop updateShop(PapaShop bean) {
		PapaShop result = dao.update(bean);
		if (result != null) {
			return result;
		} else {
			return null;
		}
	}
	
	@Transactional
	public boolean deleteShop(int shopId) {
		return dao.delete(shopId);
	}
	
	@Transactional
	public List<PapaShop> select(PapaShop bean) {
		List <PapaShop> result = null;
		if (bean != null && bean.getShopId() != 0) {
			PapaShop temp = dao.select(bean.getShopId());
			
			if (temp != null) {
				result = new ArrayList<PapaShop>();
				result.add(temp);
			}
		} else {
			result = dao.select();
		}
		return result;
	}
	
	@Transactional
	public PapaShop selectShop(int shopId) {
		return dao.select(shopId);
	}
	
	public PapaShopService() {
					
	}
	
//	public static void main(String args[]){
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		PapaShopService service	 = (PapaShopService) context.getBean("PapaShopService");
//		System.out.print(service.select());
//	}
}
