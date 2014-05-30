package com.cecj03.papago.controller.crud;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cecj03.papago.model.PapaMem;
import com.cecj03.papago.model.PriceType;
import com.cecj03.papago.model.crud.services.PapaMemCrudService;


@WebServlet("/admin/member/UpdateMember.controller")
public class UpdateMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateMember() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		
		//接收資料
		String Str = request.getParameter("srt");
		System.out.print(Str);
		
		
		//驗證資料
		if(Str==null || Str.length()==0){
			request.getRequestDispatcher("/admin/member/displayallmember.jsp").forward(request, response);
		}
		
		//轉換資料
		String[] aArray = Str.split("---");
		
		String memid= aArray[0];
		String col1= aArray[1];
		String col2= aArray[2];
		String col3= aArray[3];
		String col4= aArray[4];
		String col5= aArray[5];
		String col6= aArray[6];
		String col7= aArray[7];
		String col8= aArray[8];
		String col9= aArray[9];
		int Id=Integer.parseInt(memid);
		
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(this.getServletContext());
		 PapaMemCrudService service = (PapaMemCrudService) context
				.getBean("PapaMemCrudService");
		
		PapaMem result = service.readById(Id);
		session.setAttribute("select", result);
		
		System.out.print(result.getAccount());
		request.getRequestDispatcher("/admin/member/updatemember.jsp").forward(request, response);
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
