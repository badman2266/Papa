package com.cecj03.papago.model.crud.services;

import com.cecj03.papago.model.PapaRec;
import com.cecj03.papago.model.dao.PapaRecDao;

public class PapaRecSerivce {
	PapaRecDao dao;

	public void setDao(PapaRecDao dao) {
		this.dao = dao;
	}
	public PapaRec insertRecShop(PapaRec bean){
		PapaRec result = dao.insert(bean);
		if(result!=null) {
			
			return result;
		}
		return result;
		
	}
}
