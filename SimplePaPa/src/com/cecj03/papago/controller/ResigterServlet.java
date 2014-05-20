package com.cecj03.papago.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

@WebServlet("/LoginServlet")
public class ResigterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.print("Dome");
		// 接收資料
		// 準備存放錯誤訊息的Map物件
		Map<String, String> msgMap = new HashMap<String, String>();
		// 準備存放註冊成功之訊息的Map物件
		Map<String, String> msgOK = new HashMap<String, String>();
		Map<String, String> myParam = new HashMap<String, String>();
		// 註冊成功後將用response.sendRedirect()導向新的畫面，所以需要
		// session物件來存放共用資料。
		HttpSession session = request.getSession();
		request.setAttribute("MsgMap", msgMap);
		request.setAttribute("myParam", myParam);
		session.setAttribute("MsgOK", msgOK);

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) { // 如果含有檔案資料
			msgMap.put("errorIDEmpty", "<B>表單並非 Multipart 表單</B>");
			// 導向原來輸入資料的畫面，顯示錯誤訊息
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
			return;
		}

		String col1= request.getParameter("account");
		String col2= request.getParameter("name");
		String col3= request.getParameter("password");
		String col4= request.getParameter("email");
		String col5= request.getParameter("optionsSex");
		
		
		// 轉換資料

		// 驗證資料

		// 呼叫Model、根據Model執行結果導向View

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

}
