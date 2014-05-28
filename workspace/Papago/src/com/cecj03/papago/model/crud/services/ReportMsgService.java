package com.cecj03.papago.model.crud.services;

import java.util.*;

import com.cecj03.papago.model.ReportMsg;
import com.cecj03.papago.model.dao.ReportMsgDao;

public class ReportMsgService {
	
	private ReportMsgDao dao;
	
	public void setDao(ReportMsgDao dao) {
		this.dao = dao;
	}
	
	public List<ReportMsg> select(ReportMsg bean) {
		List <ReportMsg> result = null;
		if (bean != null && bean.getRepId() != 0) {
			ReportMsg temp = dao.select(bean.getRepId());
			
			if (temp != null) {
				result = new ArrayList<ReportMsg>();
				result.add(temp);
			}
		} else {
			result = dao.select();
		}
		return result;
	}
	public ReportMsg insert(ReportMsg bean) {
		ReportMsg result = null;
		if (bean != null) {
			result = dao.insert(bean);
		}
		return result;
	}
	public ReportMsg update(ReportMsg bean) {
		ReportMsg result = null;
		if (bean != null) {
			result = dao.update(bean);
		}
		return result;
	}
	public boolean delete(ReportMsg bean) {
		boolean result = false;
		if (bean != null) {
			result = dao.delete(bean.getRepId());
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
	public ReportMsgService() {
		
	}
}
