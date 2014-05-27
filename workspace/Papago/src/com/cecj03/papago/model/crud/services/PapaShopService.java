package com.cecj03.papago.model.crud.services;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




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
		public PapaShop insertShop(PapaShop bean) {
			PapaShop result = dao.insert(bean);
			if(result!=null) {
				
				return result;
			}
			return result;
		}
		public PapaShop updateShop(PapaShop bean) {
			PapaShop result = dao.update(bean);
			if (result != null) {
				return result;
			} else {
				return null;
			}
		}

		public boolean deleteShop(int shopId) {
			return dao.delete(shopId);
		}
		public List<PapaShop> select() {
			return dao.select();

		}
		public PapaShop selectShop(int shopId) {
			return dao.select(shopId);
		}
		public PapaShopService(){
			
		}
		public static void main(String args[]){
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			PapaShopService service	 = (PapaShopService) context.getBean("PapaShopService");
			
			System.out.print(service.select());
		}
}
