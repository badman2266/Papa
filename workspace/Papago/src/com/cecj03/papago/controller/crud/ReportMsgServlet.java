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
import com.cecj03.papago.model.crud.services.ReportMsgService;

@WebServlet(
		urlPatterns={"/admin/message/reportmsg.controller"}
		)

public class ReportMsgServlet extends HttpServlet {
	private ReportMsgService service = new ReportMsgService();
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		service = (ReportMsgService) context.getBean("ReportMsgService");
		
	// 接收資料
		String cols1 = request.getParameter("repId");
		String cols2 = request.getParameter("msgId");
		String cols3 = request.getParameter("memId");
		String report = request.getParameter("report");
		String production = request.getParameter("production");
		
	// 驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("ErrorsMsg", errors);
		
		if (production != null) {
			if (production.equals("Update") || production.equals("Delete")) {
				if (cols1 == null || cols1.trim().length() == 0) {
					errors.put("repId", "執行 " + production + " 時 檢舉編號 欄位不能為空！");
				}
			}
			
			if (production.equals("Insert") || production.equals("Update")) {
				if (report == null || report.trim().length() == 0) {
					errors.put("report", "執行 " + production + " 時 檢舉內容 欄位不能為空！");
				}
			}
		}
		
	//轉換資料
		int repId = 0;
		if (cols1 != null && cols1.trim().length() != 0) {		
			repId = service.convertInt(cols1);
			if (repId == -1000) {
				errors.put("repId", "檢舉編號 必須為整數！");
			}
		}
		
		int msgId = 0;
		if (cols2 != null && cols2.trim().length() != 0) {		
			msgId = service.convertInt(cols2);
			if (msgId == -1000) {
				errors.put("msgId", "留言文章編號 必須為整數！");
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
			request.getRequestDispatcher("/admin/message/ReportMsg.jsp").forward(request, response);
			return;
		}
		
	// 呼叫Model,根據Model執行結果導向View
		ReportMsg bean = new ReportMsg();
		PapaMsg msgbean = new PapaMsg();
		msgbean.setMsgId(msgId);
		PapaMem membean = new PapaMem();
		membean.setMemId(memId);
		
		bean.setRepId(repId);
		bean.setPapaMsg(msgbean);
		bean.setPapaMem(membean);
		bean.setReport(report);
				
		if (production != null && production.equals("Select")) {
			List<ReportMsg> result = service.select(bean);
			request.setAttribute("select", result);
			request.getRequestDispatcher("/admin/message/display.jsp").forward(request, response);
		} else if (production != null && production.equals("Insert")) {
			 bean.setReportDate(new Timestamp(System.currentTimeMillis()));
			 ReportMsg result = service.insert(bean);
			 if (result != null) {
				 request.setAttribute("insert", result);
			 } else {
				 errors.put("action", "新增失敗！"); 
			 }
			 request.getRequestDispatcher("/admin/message/ReportMsg.jsp").forward(request, response);
		} else if (production != null && production.equals("Update")) {
			 ReportMsg result = service.update(bean);
			 if (result != null) {
				 request.setAttribute("update", result);
			 } else {
				 errors.put("action", "修改失敗！"); 
			 }
			 request.getRequestDispatcher("/admin/message/ReportMsg.jsp").forward(request, response);
		} else if (production != null && production.equals("Delete")) {
			 boolean result = service.delete(bean);
			 if (result) {
				 errors.put("action", "刪除成功！");
			 } else {
				 errors.put("action", "刪除失敗！"); 
			 }
		
		request.getRequestDispatcher("/admin/message/ReportMsg.jsp").forward(request, response);
		} else {
			errors.put("action", "未知的功能" + production);
			request.getRequestDispatcher("/admin/message/ReportMsg.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
