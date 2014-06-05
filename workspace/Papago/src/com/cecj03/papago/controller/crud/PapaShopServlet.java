package com.cecj03.papago.controller.crud;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cecj03.papago.model.*;
import com.cecj03.papago.model.crud.services.PapaShopService;
import com.cecj03.papago.model.crud.services.PriceTypeService;
import com.cecj03.papago.model.crud.services.ShopTypeService;
import com.cecj03.papago.model.crud.services.benchenService;

@WebServlet(
		urlPatterns={"/shop/papashop.controller"}
		)

public class PapaShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		PapaShopService service = (PapaShopService) context.getBean("PapaShopService");
		benchenService bcservice =(benchenService) context.getBean("benchenService");
	// 接收資料
		String cols1 = request.getParameter("shopId");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String shopAddress = request.getParameter("shopAddress");
		String cols2 = request.getParameter("shoptypeId");
		String cols3 = request.getParameter("shopstatusId");
		String contactName = request.getParameter("contactName");
		String contactPhone = request.getParameter("contactPhone");
		String price = request.getParameter("price");
		String web = request.getParameter("web");
		String note = request.getParameter("note");
		String cols4 = request.getParameter("pricetypeId");
		String msgContent = request.getParameter("msgContent");
		String randshop = request.getParameter("randshop");
		String cols5 = request.getParameter("choosetype");
		String cols6 = request.getParameter("optprice");
		String production = request.getParameter("production");
		
	// 驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("ErrorsMsg", errors);
		
		if (production != null) {
			if (production.equals("Update") || production.equals("Delete")) {
				if (cols1 == null || cols1.trim().length() == 0) {
					errors.put("shopId", "執行 " + production + " 時 店家編號 欄位不能為空！");
				}
			}
			
			if (production.equals("Insert") || production.equals("Update")) {
				if (name == null || name.trim().length() == 0) {
					errors.put("name", "執行 " + production + " 時 店家名稱 欄位不能為空！");
				} else if (phone == null || phone.trim().length() == 0) {
					errors.put("phone", "執行 " + production + " 時 店家電話 欄位不能為空！");
				} else if (shopAddress == null || shopAddress.trim().length() == 0) {
					errors.put("shopAddress", "執行 " + production + " 時 店家地址 欄位不能為空！");
				} else if (price == null || price.trim().length() == 0) {
					errors.put("price", "執行 " + production + " 時 價位 欄位不能為空！");
				}
			}
		}
		
	//轉換資料
		int shopId = 0;
		if (cols1 != null && cols1.trim().length() != 0) {		
			shopId = service.convertInt(cols1);
			if (shopId == -1000) {
				errors.put("shopId", "店家編號 必須為整數！");
			}
		}
		
		int shoptypeId = 0;
		if (cols2 != null && cols2.trim().length() != 0) {		
			shoptypeId = service.convertInt(cols2);
			if (shoptypeId == -1000) {
				errors.put("shoptypeId", "店家類型編號 必須為整數！");
			}
		}
		
		int shopstatusId = 0;
		if (cols3 != null && cols3.trim().length() != 0) {		
			shopstatusId = service.convertInt(cols3);
			if (shopstatusId == -1000) {
				errors.put("shopstatusId", "店家狀態編號 必須為整數！");
			}
		}
		
		int pricetypeId = 0;
		if (cols4 != null && cols4.trim().length() != 0) {		
			pricetypeId = service.convertInt(cols4);
			if (pricetypeId == -1000) {
				errors.put("pricetypeId", "價位類型編號 必須為整數！");
			}
		}
		
		int choosetype = 0;
		if (cols5 != null && cols5.trim().length() != 0) {		
			choosetype = service.convertInt(cols5);
			if (choosetype == -1000) {
				errors.put("chooseErr", "未預期的錯誤！");
			}
		}
		
		int optprice = 0;
		if (cols6 != null && cols6.trim().length() != 0) {		
			optprice = service.convertInt(cols6);
			if (optprice == -1000) {
				errors.put("chooseErr", "未預期的錯誤！");
			}
		}
		
		if (errors != null && !errors.isEmpty()) {
			request.getRequestDispatcher("/admin/shop/InsertShop.jsp").forward(request, response);
			return;
		}
				
	// 呼叫Model,根據Model執行結果導向View
		PapaShop bean = new PapaShop();
		PapaMsg msgbean= new PapaMsg();
		ShopType typebean = new ShopType();
		typebean.setShoptypeId(shoptypeId);
		ShopStatusType statusbean = new ShopStatusType();
		statusbean.setShopstatusId(shopstatusId);
		PriceType pricetypebean = new PriceType();
		pricetypebean.setPricetypeId(pricetypeId);
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		
		bean.setShopId(shopId);
		bean.setName(name);
		bean.setPhone(phone);
		bean.setEmail(email);
//		bean.setShopPic(shopPic);
		bean.setShopAddress(shopAddress);
		bean.setShopType(typebean);
		bean.setShopStatusType(statusbean);
		bean.setShopDate(ts);
		bean.setContactName(contactName);
		bean.setContactPhone(contactPhone);
		bean.setPrice(price);
		bean.setWeb(web);
		bean.setNote(note);
		bean.setPriceType(pricetypebean);
		msgbean.setPapaShop(bean);
		msgbean.setMsgContent(msgContent);
		
		
		if (production != null && production.equals("RecMe")) {
			ShopTypeService st0 = (ShopTypeService) context.getBean("ShopTypeService");
			PriceTypeService pt0 = (PriceTypeService) context.getBean("PriceTypeService");
			
			if (randshop != null && randshop.length() != 0 && randshop.equals("rndd")) {
				// randshop = true
				if (choosetype == 200 && optprice == 200) {
					// Random All
					List<PapaShop> temp = service.select(null);
					List<PapaShop> result = service.giveRand(temp);
					session.setAttribute("shoplist", result);
					request.getRequestDispatcher("/shop/list.jsp").forward(request, response);
				} else if (choosetype != 200) {
					// ShopType Selected (Random)
					typebean.setShoptypeId(choosetype);
					String ss = st0.select(typebean).get(0).getShopType();
					List<PapaShop> temp = service.selectType(choosetype);
					List<PapaShop> result = service.giveRand(temp);
					session.setAttribute("shoplist", result);
					session.setAttribute("searchtype", ss);
					request.getRequestDispatcher("/shop/list.jsp").forward(request, response);
				} else if (optprice != 200) {
					// PriceType Selected (Random)
					pricetypebean.setPricetypeId(optprice);
					String pp = pt0.select(pricetypebean).get(0).getPriceType();
					List<PapaShop> temp = service.selectPrice(optprice);
					List<PapaShop> result = service.giveRand(temp);
					session.setAttribute("shoplist", result);
					session.setAttribute("searchtype", pp);
					request.getRequestDispatcher("/shop/list.jsp").forward(request, response);
				}
			} else {
				// randshop = false
				if (choosetype != 200 && optprice != 200) {
					// 將choosetype丟進typebean(ShopType實體)物件，然後使用該物件將店家型別找出。
					typebean.setShoptypeId(choosetype);
					String ss = st0.select(typebean).get(0).getShopType();
					
					// 將optprice丟進pricetypebean(PriceType實體)物件，然後使用該物件將價位型別找出。
					pricetypebean.setPricetypeId(optprice);
					String pp = pt0.select(pricetypebean).get(0).getPriceType();
					
					List<PapaShop> result = service.selectShopPrice(choosetype, optprice);
					session.setAttribute("shoplist", result);
					session.setAttribute("searchtype", ss + " - " + pp);
					request.getRequestDispatcher("/shop/list.jsp").forward(request, response);
				} else if (choosetype != 200) {
					// ShopType Selected (Nomal)
					typebean.setShoptypeId(choosetype);
					String ss = st0.select(typebean).get(0).getShopType();
					
					List<PapaShop> result = service.selectType(choosetype);
					
					session.setAttribute("shoplist", result);
					session.setAttribute("searchtype", ss);
					request.getRequestDispatcher("/shop/list.jsp").forward(request, response);
				} else if (optprice != 200) {
					// PriceType Selected (Nomal)
					pricetypebean.setPricetypeId(optprice);
					String pp = pt0.select(pricetypebean).get(0).getPriceType();
					
					List<PapaShop> result = service.selectPrice(optprice);
					
					session.setAttribute("shoplist", result);
					session.setAttribute("searchtype", pp);
					request.getRequestDispatcher("/shop/list.jsp").forward(request, response);
				}
			}
		} else if (production != null && production.equals("SelectPrice")) {
			PriceTypeService pt = (PriceTypeService) context.getBean("PriceTypeService");
			String temp = pt.select(pricetypebean).get(0).getPriceType();
			List<PapaShop> result = service.selectPrice(pricetypeId);
			session.setAttribute("shoplist", result);
			session.setAttribute("searchtype", temp);
			request.getRequestDispatcher("/shop/list.jsp").forward(request, response);
		} else if (production != null && production.equals("SelectType")) {
			ShopTypeService st = (ShopTypeService) context.getBean("ShopTypeService");
			String temp = st.select(typebean).get(0).getShopType();
			List<PapaShop> result = service.selectType(shoptypeId);
			session.setAttribute("shoplist", result);
			session.setAttribute("searchtype", temp);
			request.getRequestDispatcher("/shop/list.jsp").forward(request, response);
		} else if (production != null && production.equals("CharSelect")) {
			List<PapaShop> result = service.like(name);
			session.setAttribute("shoplist", result);
			request.setAttribute("select", result);
			request.getRequestDispatcher("/shop/list.jsp").forward(request, response);
		} else if (production != null && production.equals("Select")) {
			List<PapaShop> result = service.select(bean);
			session.setAttribute("select", result);
			List<PapaMsg> messageresult = bcservice.showMessage(shopId);
			session.setAttribute("msg", messageresult);
			request.getRequestDispatcher("/shop/restaurant.jsp").forward(request, response);
		} else if (production != null && production.equals("Insert")) {
			 PapaShop result = service.insertShop(bean);
			 if (result != null) {
				 request.setAttribute("insert", result);
			 } else {
				 errors.put("action", "新增失敗！"); 
			 }
			 request.getRequestDispatcher("/admin/shop/PapaShop.jsp").forward(request, response);
		} else if (production != null && production.equals("Update")) {
			 PapaShop result = service.updateShop(bean);
			 if (result != null) {
				 request.setAttribute("update", result);
			 } else {
				 errors.put("action", "修改失敗！"); 
			 }
			 request.getRequestDispatcher("/admin/shop/PapaShop.jsp").forward(request, response);
		} else if (production != null && production.equals("Delete")) {
			 boolean result = service.deleteShop(shopId);
			 if (result) {
				 errors.put("action", "刪除成功！");
			 } else {
				 errors.put("action", "刪除失敗！"); 
			 }
		
		request.getRequestDispatcher("/admin/shop/PapaShop.jsp").forward(request, response);
		}else if(production != null && production.equals("writemessage")){
			List<PapaShop> resultt = service.select(bean);
			session.setAttribute("select", resultt);
			
			PapaMsg result = bcservice.writeMessage(msgbean);
			 if(result != null){
				 session.setAttribute("insert", result);
			 }else{
				 errors.put("action", "新增失敗！");
			 }
				String path = request.getContextPath();
				response.sendRedirect(path+"/shop/papashop.controller?production=Select&shopId="+ shopId);
		} else {
			errors.put("action", "未知的功能" + production);
			request.getRequestDispatcher("/admin/message/PapaShop.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
