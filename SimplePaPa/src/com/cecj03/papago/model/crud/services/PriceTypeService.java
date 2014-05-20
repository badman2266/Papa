package com.cecj03.papago.model.crud.services;

import java.util.*;

import com.cecj03.papago.model.dao.PriceTypeDao;
import com.cecj03.papago.model.entity.PriceType;

public class PriceTypeService {
	
	private PriceTypeDao dao;
	
	public void setDao(PriceTypeDao dao) {
		this.dao = dao;
	}
	
	public List<PriceType> select(PriceType bean) {
		List <PriceType> result = null;
		if (bean != null && bean.getPricetypeId() != 0) {
			PriceType temp = dao.select(bean.getPricetypeId());
			
			if (temp != null) {
				result = new ArrayList<PriceType>();
				result.add(temp);
			}
		} else {
			result = dao.select();
		}
		return result;
	}
	public PriceType insert(PriceType bean) {
		PriceType result = null;
		if (bean != null) {
			result = dao.insert(bean);
		}
		return result;
	}
	public PriceType update(PriceType bean) {
		PriceType result = null;
		if (bean != null) {
			result = dao.update(bean);
		}
		return result;
	}
	public boolean delete(PriceType bean) {
		boolean result = false;
		if (bean != null) {
			result = dao.delete(bean.getPricetypeId());
		}
		return result;
	}
	public PriceTypeService() {
		
	}
}