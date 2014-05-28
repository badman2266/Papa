package com.cecj03.papago.model.crud.services;

import java.util.*;

import com.cecj03.papago.model.PapaScore;
import com.cecj03.papago.model.dao.PapaScoreDao;

public class PapaScoreService {
	
	private PapaScoreDao dao;
	
	public void setDao(PapaScoreDao dao) {
		this.dao = dao;
	}
	
	public List<PapaScore> select(PapaScore bean) {
		List <PapaScore> result = null;
		if (bean != null && bean.getScoreId() != 0) {
			PapaScore temp = dao.select(bean.getScoreId());
			
			if (temp != null) {
				result = new ArrayList<PapaScore>();
				result.add(temp);
			}
		} else {
			result = dao.select();
		}
		return result;
	}
	public PapaScore insert(PapaScore bean) {
		PapaScore result = null;
		if (bean != null) {
			result = dao.insert(bean);
		}
		return result;
	}
	public PapaScore update(PapaScore bean) {
		PapaScore result = null;
		if (bean != null) {
			result = dao.update(bean);
		}
		return result;
	}
	public boolean delete(PapaScore bean) {
		boolean result = false;
		if (bean != null) {
			result = dao.delete(bean.getScoreId());
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
	public PapaScoreService() {
		
	}
}
