package com.cecj03.papago.controller.crud;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cecj03.papago.model.PriceType;
import com.cecj03.papago.model.crud.services.PriceTypeService;

@WebServlet(
		urlPatterns={"/admin/shop/pricetype.controller"}
		)

public class PriceTypeServlet extends HttpServlet {
	private PriceTypeService service = new PriceTypeService();
	
//	private PriceTypeService service;
//	public void setService(PriceTypeService service) {
//		this.service = service;
//	}
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		service = (PriceTypeService) context.getBean("PriceTypeService");
		
	// 接收資料
		String cols1 = request.getParameter("pricetypeId");
		String priceType = request.getParameter("priceType");
		String production = request.getParameter("production");
		
	// 驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("ErrorsMsg", errors);
		
		if (production != null) {
			if (production.equals("Insert") || production.equals("Update") || production.equals("Delete")) {
				if (cols1 == null || cols1.trim().length() == 0) {
					errors.put("pricetypeId", "執行 " + production + " 時 價位類型編號 欄位不能為空！");
				}
			}
			
			if (production.equals("Insert") || production.equals("Update")) {
				if (priceType == null || priceType.trim().length() == 0) {
					errors.put("priceType", "執行 " + production + " 時 價位類型 欄位不能為空！");
				}
			}
		}
		
	//轉換資料
		int pricetypeId = 0;
		if (cols1 != null && cols1.trim().length() != 0) {		
			pricetypeId = service.convertInt(cols1);
			if (pricetypeId == -1000) {
				errors.put("pricetypeId", "價位類型編號 必須為整數！");
			}
		}
		
		if (errors != null && !errors.isEmpty()) {
			request.getRequestDispatcher("/admin/shop/PriceType.jsp").forward(request, response);
			return;
		}
		
	// 呼叫Model,根據Model執行結果導向View
		PriceType bean = new PriceType();
		bean.setPricetypeId(pricetypeId);
		bean.setPriceType(priceType);
				
		if (production != null && production.equals("Select")) {
			List<PriceType> result = service.select(bean);
			session.setAttribute("select", result);
			request.getRequestDispatcher("/admin/shop/display.jsp").forward(request, response);
		} else if (production != null && production.equals("Insert")) {
			 PriceType result = service.insert(bean);
			 if (result != null) {
				 request.setAttribute("insert", result);
			 } else {
				 errors.put("action", "新增失敗！"); 
			 }
			 request.getRequestDispatcher("/admin/shop/PriceType.jsp").forward(request, response);
		} else if (production != null && production.equals("Update")) {
			 PriceType result = service.update(bean);
			 if (result != null) {
				 request.setAttribute("update", result);
			 } else {
				 errors.put("action", "修改失敗！"); 
			 }
			 request.getRequestDispatcher("/admin/shop/PriceType.jsp").forward(request, response);
		} else if (production != null && production.equals("Delete")) {
			 boolean result = service.delete(bean);
			 if (result) {
				 errors.put("action", "刪除成功！");
			 } else {
				 errors.put("action", "刪除失敗！"); 
			 }
		
		request.getRequestDispatcher("/admin/shop/PriceType.jsp").forward(request, response);
		} else {
			errors.put("action", "未知的功能" + production);
			request.getRequestDispatcher("/admin/shop/PriceType.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
