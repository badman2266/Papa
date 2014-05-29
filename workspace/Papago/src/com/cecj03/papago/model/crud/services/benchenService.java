package com.cecj03.papago.model.crud.services;

import java.util.ArrayList;
import java.util.List;


import com.cecj03.papago.model.PapaMem;
import com.cecj03.papago.model.PapaMsg;
import com.cecj03.papago.model.PapaShop;
import com.cecj03.papago.model.dao.FavoritesListDao;
import com.cecj03.papago.model.dao.MemStatusTypeDao;
import com.cecj03.papago.model.dao.MemTypeDao;
import com.cecj03.papago.model.dao.PapaMemDao;
import com.cecj03.papago.model.dao.PapaMsgDao;
import com.cecj03.papago.model.dao.PapaRecDao;
import com.cecj03.papago.model.dao.PapaScoreDao;
import com.cecj03.papago.model.dao.PapaShopDao;
import com.cecj03.papago.model.dao.PriceTypeDao;
import com.cecj03.papago.model.dao.ReportMsgDao;
import com.cecj03.papago.model.dao.ShopStatusTypeDao;
import com.cecj03.papago.model.dao.ShopTypeDao;
import com.cecj03.papago.model.dao.UpdateShopDao;
public class benchenService {
		private FavoritesListDao favoritesListDao;
		private MemStatusTypeDao memStatusTypeDao;
		private MemTypeDao memTypeDao;
		private PapaMemDao papaMemDao;
		private PapaMsgDao papaMsgDao;
		private PapaRecDao papaRecDao;
		private PapaScoreDao papaScoreDao;
		private PapaShopDao papaShopDao;
		private PriceTypeDao priceTypeDao;
		private ReportMsgDao reportMsgDao;
		private ShopStatusTypeDao shopStatusTypeDao;
		private ShopTypeDao shopTypeDao;
		private UpdateShopDao updateShopDao;
		public void setFavoritesListDao(FavoritesListDao favoritesListDao) {
			this.favoritesListDao = favoritesListDao;
		}
		public void setMemStatusTypeDao(MemStatusTypeDao memStatusTypeDao) {
			this.memStatusTypeDao = memStatusTypeDao;
		}
		public void setMemTypeDao(MemTypeDao memTypeDao) {
			this.memTypeDao = memTypeDao;
		}
		public void setPapaMemDao(PapaMemDao papaMemDao) {
			this.papaMemDao = papaMemDao;
		}
		public void setPapaMsgDao(PapaMsgDao papaMsgDao) {
			this.papaMsgDao = papaMsgDao;
		}
		public void setPapaRecDao(PapaRecDao papaRecDao) {
			this.papaRecDao = papaRecDao;
		}
		public void setPapaScoreDao(PapaScoreDao papaScoreDao) {
			this.papaScoreDao = papaScoreDao;
		}
		public void setPapaShopDao(PapaShopDao papaShopDao) {
			this.papaShopDao = papaShopDao;
		}
		public void setPriceTypeDao(PriceTypeDao priceTypeDao) {
			this.priceTypeDao = priceTypeDao;
		}
		public void setReportMsgDao(ReportMsgDao reportMsgDao) {
			this.reportMsgDao = reportMsgDao;
		}
		public void setShopStatusTypeDao(ShopStatusTypeDao shopStatusTypeDao) {
			this.shopStatusTypeDao = shopStatusTypeDao;
		}
		public void setShopTypeDao(ShopTypeDao shopTypeDao) {
			this.shopTypeDao = shopTypeDao;
		}
		public void setUpdateShopDao(UpdateShopDao updateShopDao) {
			this.updateShopDao = updateShopDao;
		}
		public List<PapaMsg> showMessage(PapaMsg bean) {
			List<PapaMsg> result = null;
			if(bean!=null && bean.getMsgId()!=0) {
				PapaMsg temp = papaMsgDao.select(bean.getMsgId());
				if(temp!=null) {
					result = new ArrayList<PapaMsg>();
					result.add(temp);
				}
			} else {
				result = papaMsgDao.select(); 
			}
			return result;
		}
		
		public PapaMsg writeMessage(PapaMsg bean) {
			PapaMsg result = null;
			PapaMem pm = new PapaMem();
			PapaShop ps = new PapaShop();
			pm.setMemId(papaMemDao.findById(2).getMemId());
			ps.setShopId(papaShopDao.select(1).getShopId());
			if (bean != null) {
				java.util.Date date = new java.util.Date();
				long temp = date.getTime();
				bean.setMsgDate(new java.sql.Timestamp(temp));
				bean.setPapaMem(pm);
				bean.setPapaShop(ps);
				result = papaMsgDao.insert(bean);
			}
			return result;
		}
		
		
}
