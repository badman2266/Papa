package com.cecj03.papago.misc.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cecj03.papago.model.PapaShop;
import com.cecj03.papago.model.crud.services.PapaShopService;

/**
 * Servlet implementation class ShopListDisplay
 */
@WebServlet("/ShopListDisplay.json")
public class ShopListDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ShopListDisplay() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(this.getServletContext());
		 PapaShopService service = ( PapaShopService) context
				.getBean("PapaShopService");
		 PapaShop bean=null;
		 List<PapaShop> Shoplists= service.select(bean);
		 
		 for(PapaShop entity : Shoplists){
			 arrayBuilder.add(objBuilder.add("addr", entity.getShopAddress())
					                    .add("text", "<strong>"+entity.getName()
					                    	   +"</strong><br>"+entity.getShopAddress() 
					                    	  // http://localhost:8080/Papago/shop/papashop.controller?production=Select&shopId=1
					                    	    // <c:url value='/shop/papashop.controller?production=Select&shopId=1'/>					          
					                    	   +"<br><a href='"+request.getContextPath()+"/shop/papashop.controller?production=Select&shopId="+entity.getShopId()
					                    	   +"'>點我</a>"
					                    		)
					                    .build());						
		 }
		 out.write(arrayBuilder.build().toString());
			out.close();
			return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
