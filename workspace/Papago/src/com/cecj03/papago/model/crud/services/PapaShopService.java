package com.cecj03.papago.model.crud.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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


public class PapaShopService extends GenericCrudService<PapaShop>{
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
	
	public static void main(String args[]){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		PapaShopService service	 = (PapaShopService) context.getBean("PapaShopService");
		PapaShop bean=new PapaShop();
		PriceType priceType=new PriceType();
		priceType.setPricetypeId(1);
		ShopStatusType shopStatusType=new ShopStatusType();
		shopStatusType.setShopstatusId(1);
		
		ShopType shopType=new ShopType();
		shopType.setShoptypeId(1);
		
		bean.setName("ddddd");
		bean.setPhone("333333");
		bean.setPrice("dddddd");
		bean.setEmail("ddddd");
		bean.setContactName("dddd");
		bean.setContactPhone("ddddd");
		bean.setNote("ddddd");
		bean.setPriceType(priceType);
		bean.setShopAddress("ssssss");
		bean.setShopDate(new Timestamp(new java.util.Date().getTime()));
		bean.setShopStatusType(shopStatusType);
		bean.setWeb("dddddd");
		bean.setShopType(shopType);
		
		System.out.print(service.delete(1));
	}
}
