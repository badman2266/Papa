package com.cecj03.papago.model.crud.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cecj03.papago.model.PapaMem;
import com.cecj03.papago.model.PapaRec;
import com.cecj03.papago.model.ShopType;
import com.cecj03.papago.model.dao.GenericDao;

public class PapaRecService extends GenericCrudService<PapaRec> {

	public void setDao(GenericDao<PapaRec> dao) {
		super.setDao(dao);
	}
	public PapaRec insertRecShop(PapaRec bean){
		PapaRec result = dao.insert(bean);
		if(result!=null) {
			
			return result;
		}
		return result;
	}
	
	public PapaRec createRecShop(PapaRec entity, int memId, int shoptypeId){
		PapaMem bean1= new PapaMem();
		bean1.setMemId(memId);
		
		ShopType bean2= new ShopType();
		bean2.setShoptypeId(shoptypeId);
		
		entity.setPapaMem(bean1);
		entity.setShopType(bean2);
		
		PapaRec result = dao.insert(entity);
		if (result != null) {
			return result;
		} else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.config.xml");
		PapaRecService service = (PapaRecService) context
				.getBean("PapaRecService");
		PapaRec entity = new PapaRec();
		entity.setName("白蘭氏");
		entity.setContactPhone("0912");
		entity.setEmail("jeff32182");
		entity.setContactName("陳");
		entity.setPhone("02-223");
		entity.setPrice("204");
		entity.setNote("很小~");
		entity.setRecAddress("台樓");
		entity.setWeb("http:/.tw/");
		entity.setRecId(4);
		System.out.println(service.readAll());
		//System.out.println(service.createRecShop(entity, 3, 1));
		
		
		
	}
	
	
	
}
