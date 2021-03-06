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
import com.cecj03.papago.model.crud.services.PapaScoreService;

@WebServlet(
		urlPatterns={"/admin/rank/papascore.controller"}
		)

public class PapaScoreServlet extends HttpServlet {
	private PapaScoreService service = new PapaScoreService();
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		service = (PapaScoreService) context.getBean("PapaScoreService");
		
	// 接收資料
		String cols1 = request.getParameter("scoreId");
		String cols2 = request.getParameter("shopId");
		String cols3 = request.getParameter("memId");
		String cols4 = request.getParameter("score");
		String production = request.getParameter("production");
		
	// 驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("ErrorsMsg", errors);
		
		if (production != null) {
			if (production.equals("Update") || production.equals("Delete")) {
				if (cols1 == null || cols1.trim().length() == 0) {
					errors.put("scoreId", "執行 " + production + " 時 評分編號 欄位不能為空！");
				}
			}
			
			if (production.equals("Insert") || production.equals("Update")) {
				if (cols4 == null || cols4.trim().length() == 0) {
					errors.put("score", "執行 " + production + " 時 評分 欄位不能為空！");
				}
			}
		}
		
	//轉換資料
		int scoreId = 0;
		if (cols1 != null && cols1.trim().length() != 0) {		
			scoreId = service.convertInt(cols1);
			if (scoreId == -1000) {
				errors.put("scoreId", "評分編號 必須為整數！");
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
		
		int score = 0;
		if (cols4 != null && cols4.trim().length() != 0) {		
			score = service.convertInt(cols4);
			if (score == -1000) {
				errors.put("score", "評分 必須為整數！");
			}
		}
		
		if (errors != null && !errors.isEmpty()) {
			request.getRequestDispatcher("/admin/rank/PapaScore.jsp").forward(request, response);
			return;
		}
		
	// 呼叫Model,根據Model執行結果導向View
		PapaScore bean = new PapaScore();
		PapaShop shopbean = new PapaShop();
		shopbean.setShopId(shopId);
		PapaMem membean = new PapaMem();
		membean.setMemId(memId);
				
		bean.setScoreId(scoreId);
		bean.setPapaShop(shopbean);
		bean.setPapaMem(membean);
		bean.setScore(score);
						
		if (production != null && production.equals("Select")) {
			List<PapaScore> result = service.select(bean);
			request.setAttribute("select", result);
			request.getRequestDispatcher("/admin/rank/display.jsp").forward(request, response);
		} else if (production != null && production.equals("Insert")) {
			 bean.setScoreDate(new Timestamp(System.currentTimeMillis()));
			 PapaScore result = service.insert(bean);
			 if (result != null) {
				 request.setAttribute("insert", result);
			 } else {
				 errors.put("action", "新增失敗！"); 
			 }
			 request.getRequestDispatcher("/admin/rank/PapaScore.jsp").forward(request, response);
		} else if (production != null && production.equals("Update")) {
			 PapaScore result = service.update(bean);
			 if (result != null) {
				 request.setAttribute("update", result);
			 } else {
				 errors.put("action", "修改失敗！"); 
			 }
			 request.getRequestDispatcher("/admin/rank/PapaScore.jsp").forward(request, response);
		} else if (production != null && production.equals("Delete")) {
			 boolean result = service.delete(bean);
			 if (result) {
				 errors.put("action", "刪除成功！");
			 } else {
				 errors.put("action", "刪除失敗！"); 
			 }
		
		request.getRequestDispatcher("/admin/rank/PapaScore.jsp").forward(request, response);
		} else {
			errors.put("action", "未知的功能" + production);
			request.getRequestDispatcher("/admin/rank/PapaScore.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
