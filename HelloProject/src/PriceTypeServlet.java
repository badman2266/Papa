package tw.com.digigp01.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import tw.com.digigp01.model.PriceTypeBean;
import tw.com.digigp01.service.PriceTypeService;

public class PriceTypeServlet extends HttpServlet {
	private PriceTypeService service = new PriceTypeService();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	// 接收資料
		String cols1 = request.getParameter("ptid");
		String type = request.getParameter("type");
		String prodaction = request.getParameter("prodaction");
		
	// 驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("ErrorsMags", errors);
		
		if (prodaction != null) {
			if (prodaction.equals("新增") || prodaction.equals("修改") || prodaction.equals("刪除")) {
				if (cols1 == null || cols1.trim().length() == 0) {
					errors.put("ptid", "執行 " + prodaction + " 時 價位類型編號 欄位不能為空！");
				}
			}
		}
		
	//轉換資料
		int ptid = 0;
		if (cols1 != null && cols1.trim().length() != 0) {		
			ptid = PriceTypeBean.convertInt(cols1);
			if (ptid == -1000) {
				errors.put("ptid", "價位類型編號 必須為整數！");
			}
		}
		
		if (type == null || type.trim().length() == 0) {		
			errors.put("type", "價位類型 必須輸入！");
		} 
		
		if (errors != null && !errors.isEmpty()) {
			request.getRequestDispatcher("/admin/shop/PriceType.jsp").forward(request, response);
			return;
		}
		
	// 呼叫Model,根據Model執行結果導向View
		PriceTypeBean bean = new PriceTypeBean();
		bean.setPtypeId(ptid);
		bean.setPtype(type);
				
		if (prodaction != null && prodaction.equals("查詢")) {
			List<PriceTypeBean> result = service.select(bean);
			request.setAttribute("select", result);
			request.getRequestDispatcher("/admin/shop/display.jsp").forward(request, response);
		} else if (prodaction != null && prodaction.equals("新增")) {
			 PriceTypeBean result = service.insert(bean);
			 if (result != null) {
				 request.setAttribute("insert", result);
			 } else {
				 errors.put("action", "新增失敗！"); 
			 }
			 request.getRequestDispatcher("/admin/shop/PriceType.jsp").forward(request, response);
		} else if (prodaction != null && prodaction.equals("修改")) {
			 PriceTypeBean result = service.update(bean);
			 if (result != null) {
				 request.setAttribute("update", result);
			 } else {
				 errors.put("action", "修改失敗！"); 
			 }
			 request.getRequestDispatcher("/admin/shop/PriceType.jsp").forward(request, response);
		} else if (prodaction != null && prodaction.equals("刪除")) {
			 boolean result = service.delete(bean);
			 if (result) {
				 errors.put("action", "刪除成功！");
			 } else {
				 errors.put("action", "刪除失敗！"); 
			 }
		
		request.getRequestDispatcher("/admin/shop/PriceType.jsp").forward(request, response);
		} else {
			errors.put("action", "未知的功能" + prodaction);
			request.getRequestDispatcher("/admin/shop/PriceType.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
