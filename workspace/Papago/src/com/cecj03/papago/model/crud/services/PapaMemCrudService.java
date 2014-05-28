package com.cecj03.papago.model.crud.services;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cecj03.papago.model.MemStatusType;
import com.cecj03.papago.model.MemType;
import com.cecj03.papago.model.PapaMem;
import com.cecj03.papago.model.dao.GenericDao;

public class PapaMemCrudService extends GenericCrudService<PapaMem> {

	public void setDao(GenericDao<PapaMem> dao) {
		super.setDao(dao);
	}

	public PapaMem createMem(PapaMem entity, int type, int status) {
		MemType entity1 = new MemType();
		MemStatusType entity2 = new MemStatusType();
		entity1.setMemtypeId(type);
		entity2.setMemstatusId(status);
		entity.setMemType(entity1);
		entity.setMemStatusType(entity2);
		PapaMem result = dao.insert(entity);
		if (result != null) {
			return result;
		} else {
			return null;
		}
	}

	public PapaMem login(String memAccount, String memPassword) {
		String hql = "from PapaMem where account = ?";
		List<PapaMem> result = dao.findByHQL(hql, memAccount);
		Iterator<PapaMem> list = result.iterator();

		while (list.hasNext()) {
			PapaMem item = (PapaMem) list.next();
			System.out.println(item.getMemPassword());
			System.out.println(item.getAccount());
			System.out.println(item.getMemType().getMemType()+"dd");
			if (item != null) {
				if (memPassword != null && memPassword.length() != 0) {
					String temp = item.getMemPassword(); // database
					String pass = memPassword.toString(); // user input
					if (temp.equals(pass)) {
						return item;
					}
				}
			}
		}
		return null;
	}
	
	public boolean changePassword(
			String memAccount, String oldPassword, String newPassword) {
		PapaMem item = this.login(memAccount, oldPassword);
		if(item!=null) {	
			System.out.println(item.getAccount());
			String temp = newPassword.toString();
			item.setMemPassword(temp);
			if(dao.update(item)!=null){
				return true;
			}
			return false;
		}
		return false;
	}
	
	

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.config.xml");
		PapaMemCrudService service = (PapaMemCrudService) context
				.getBean("PapaMemCrudService");
		System.out.println(service.changePassword("q", "q", "qa"));
	}

	// 測試Service
/*
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.config.xml");
		PapaMemCrudService service = (PapaMemCrudService) context
				.getBean("PapaMemCrudService");
		PapaMem entity = new PapaMem();
		MemType entity1 = new MemType();
		MemStatusType entity2 = new MemStatusType();
		entity.setAccount("S");
		entity.setName("C");
		entity.setMemPassword("F");
		entity.setBirth(new java.util.Date());
		entity.setEmail("AA");
		entity.setSex("無"); // 無圖片
		entity.setBirth(new java.util.Date());
		entity.setPhone("023232323");
		entity.setMemAddress("台北市");
		entity.setMemDate(new Timestamp(System.currentTimeMillis()));
		entity1.setMemtypeId(1);
		entity2.setMemstatusId(1);
		entity.setMemType(entity1);
		entity.setMemStatusType(entity2);
		System.out.println("beans=" + service.create(entity));
	}
*/
}
