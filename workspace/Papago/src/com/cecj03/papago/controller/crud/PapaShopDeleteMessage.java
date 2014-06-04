package com.cecj03.papago.controller.crud;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cecj03.papago.model.PapaMsg;
import com.cecj03.papago.model.PapaShop;
import com.cecj03.papago.model.crud.services.PapaShopService;
import com.cecj03.papago.model.crud.services.benchenService;

@WebServlet(
		urlPatterns={"/shop/deletemessage.controller"}
		)
public class PapaShopDeleteMessage extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		PapaShopService service = (PapaShopService) context.getBean("PapaShopService");
		benchenService bcservice =(benchenService) context.getBean("benchenService");
		String cols1 = request.getParameter("shopId");
		String cols2 = request.getParameter("msgId");
		String production = request.getParameter("production");
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("ErrorsMsg", errors);
		int shopId = 0;
		if (cols1 != null && cols1.trim().length() != 0) {		
			shopId = service.convertInt(cols1);
			if (shopId == -1000) {
				errors.put("shopId", "店家編號 必須為整數！");
			}
		}
		int msgId = 0;
		if (cols2 != null && cols2.trim().length() != 0) {		
			msgId = service.convertInt(cols2);
			if (msgId == -1000) {
				errors.put("msgId", "店家編號 必須為整數！");
			}
		}
		PapaShop bean = new PapaShop();
		PapaMsg msgbean= new PapaMsg();
		bean.setShopId(shopId);
		msgbean.setMsgId(msgId);
		
		if(production != null && production.equals("deletemessage")){
			 boolean result = bcservice.deleteMessage(msgId);
			 if (result) {
				 errors.put("action", "刪除成功！");
			 } else {
				 errors.put("action", "刪除失敗！"); 
			 }
			 String path = request.getContextPath();
				response.sendRedirect(path+"/shop/papashop.controller?production=Select&shopId="+ shopId);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
	

}
