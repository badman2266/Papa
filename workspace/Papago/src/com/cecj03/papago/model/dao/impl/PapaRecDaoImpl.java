package com.cecj03.papago.model.dao.impl;

import com.cecj03.papago.model.PapaMem;
import com.cecj03.papago.model.PapaRec;
import com.cecj03.papago.model.ShopType;
import com.cecj03.papago.model.dao.PapaRecDao;

public class PapaRecDaoImpl extends GenericDaoImpl<PapaRec> implements PapaRecDao {


	public static void main(String[] args) {
		
		PapaRecDaoImpl dao=new PapaRecDaoImpl();
		PapaRec entity = new PapaRec();
		
		entity.setName("白蘭氏");
		entity.setContactPhone("0912345678");
		entity.setEmail("jeff32191182@yahoo.com.tw");
		entity.setContactName("陳傑揚");
		entity.setPhone("02-2212-2233");
		entity.setPrice("204");
		entity.setNote("很小器耶~~~");
		entity.setRecAddress("台北市中興路二段230號1樓");
		entity.setWeb("http://www.books.com.tw/products/0010468939");
		
		PapaMem bean1= new PapaMem();
		bean1.setMemId(1);
		
		ShopType bean2= new ShopType();
		bean2.setShoptypeId(2);
		
		entity.setPapaMem(bean1);
		entity.setShopType(bean2);
		
		
		dao.insert(entity);
		
	}
	
	
}
