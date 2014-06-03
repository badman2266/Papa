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
import com.cecj03.papago.model.crud.services.UpdateShopService;

@WebServlet(urlPatterns = { "/admin/shop/updateshop.controller" })
public class UpdateShopServlet extends HttpServlet {
	private UpdateShopService service = new UpdateShopService();
	private PapaShopService service1 = new PapaShopService();
	
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(this.getServletContext());
		service = (UpdateShopService) context.getBean("UpdateShopService");
		service1 = (PapaShopService) context.getBean("PapaShopService");
		
		// 接收資料
		String cols1 = request.getParameter("updateId");
		String cols2 = request.getParameter("shopId");
		String cols3 = request.getParameter("memId");
		String updateContent = request.getParameter("updateContent");
		String production = request.getParameter("production");

		// 驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("ErrorsMsg", errors);

		if (production != null) {
			if (production.equals("Update") || production.equals("Delete")) {
				if (cols1 == null || cols1.trim().length() == 0) {
					errors.put("updateId", "執行 " + production
							+ " 時 回報編號 欄位不能為空！");
				}
			}

			if (production.equals("Insert") || production.equals("Update")) {
				if (updateContent == null || updateContent.trim().length() == 0) {
					errors.put("updateContent", "執行 " + production
							+ " 時 回報內容 欄位不能為空！");
				}
			}
		}

		// 轉換資料
		int updateId = 0;
		if (cols1 != null && cols1.trim().length() != 0) {
			updateId = service.convertInt(cols1);
			if (updateId == -1000) {
				errors.put("updateId", "回報編號 必須為整數！");
			}
		}

		int shopId = 0;
		if (cols2 != null && cols2.trim().length() != 0) {
			shopId = service.convertInt(cols2);
			if (shopId == -1000) {
				errors.put("shopId", "店家編號 必須為整數！");
			}
		}

		int memId = 0;
		if (cols3 != null && cols3.trim().length() != 0) {
			memId = service.convertInt(cols3);
			if (memId == -1000) {
				errors.put("memId", "會員編號 必須為整數！");
			}
		}

		if (errors != null && !errors.isEmpty()) {
			request.getRequestDispatcher("/admin/shop/UpdateShop.jsp").forward(
					request, response);
			return;
		}

		// 呼叫Model,根據Model執行結果導向View
		UpdateShop bean = new UpdateShop();
		PapaShop shopbean = new PapaShop();
		shopbean.setShopId(shopId);
		PapaMem membean = new PapaMem();
		membean.setMemId(memId);
		bean.setUpdateId(updateId);
		bean.setPapaShop(shopbean);
		bean.setPapaMem(membean);
		bean.setUpdateContent(updateContent);
		bean.getPapaShop().getName();
		if (production != null && production.equals("Select")) {
			List<UpdateShop> result = service.select(bean);
			request.setAttribute("select", result);
			request.getRequestDispatcher("/admin/shop/DisplayShopUpdate.jsp").forward(
					request, response);
		} else if (production != null && production.equals("Insert")) {
			bean.setUpdateDate(new Timestamp(System.currentTimeMillis()));
			UpdateShop result = service.insert(bean);
			if (result != null) {
				request.setAttribute("insert", result);
			} else {
				errors.put("action", "新增失敗！");
			}
			
			//重新傳session
			PapaShop result1=new PapaShop();
			result1 = service1.selectShop(shopId);
			HttpSession session = request.getSession();
			session.setAttribute("select", result1);
			String path = request.getContextPath();
			response.sendRedirect(path + "/shop/papashop.controller?production=Select&shopId="+shopId);
		} else if (production != null && production.equals("Update")) {
			UpdateShop result = service.update(bean);
			if (result != null) {
				request.setAttribute("update", result);
			} else {
				errors.put("action", "修改失敗！");
			}
			request.getRequestDispatcher("/admin/shop/UpdateShop.jsp").forward(
					request, response);
		} else if (production != null && production.equals("Delete")) {
			boolean result = service.delete(bean);
			if (result) {
				errors.put("action", "刪除成功！");
			} else {
				errors.put("action", "刪除失敗！");
			}

			request.getRequestDispatcher("/admin/shop/UpdateShop.jsp").forward(
					request, response);
		} else {
			errors.put("action", "未知的功能" + production);
			request.getRequestDispatcher("/admin/shop/UpdateShop.jsp").forward(
					request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
