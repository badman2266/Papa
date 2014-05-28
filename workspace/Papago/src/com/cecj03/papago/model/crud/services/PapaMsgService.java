package com.cecj03.papago.model.crud.services;

import java.util.*;

import com.cecj03.papago.model.PapaMsg;
import com.cecj03.papago.model.dao.PapaMsgDao;

public class PapaMsgService {
	
	private PapaMsgDao dao;
	
	public void setDao(PapaMsgDao dao) {
		this.dao = dao;
	}
	
	public List<PapaMsg> select(PapaMsg bean) {
		List <PapaMsg> result = null;
		if (bean != null && bean.getMsgId() != 0) {
			PapaMsg temp = dao.select(bean.getMsgId());
			
			if (temp != null) {
				result = new ArrayList<PapaMsg>();
				result.add(temp);
			}
		} else {
			result = dao.select();
		}
		return result;
	}
	public PapaMsg insert(PapaMsg bean) {
		PapaMsg result = null;
		if (bean != null) {
			result = dao.insert(bean);
		}
		return result;
	}
	public PapaMsg update(PapaMsg bean) {
		PapaMsg result = null;
		if (bean != null) {
			result = dao.update(bean);
		}
		return result;
	}
	public boolean delete(PapaMsg bean) {
		boolean result = false;
		if (bean != null) {
			result = dao.delete(bean.getMsgId());
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
	public PapaMsgService() {
		
	}
}
