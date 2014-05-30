package com.cecj03.papago.ajax.crud;

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

import com.cecj03.papago.model.PapaMsg;
import com.cecj03.papago.model.crud.services.benchenService;

@WebServlet("/admin/message/message.json")
public class showMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public showMessage() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.textJson(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	private void textJson(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain; charset=UTF-8");
		String tempId = request.getParameter("shopId");
		int shopId;
		try{
		shopId = Integer.parseInt(tempId);
		PrintWriter out = response.getWriter();
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(this.getServletContext());
		benchenService service = (benchenService) context.getBean("benchenService");
		List<PapaMsg> result = service.findShopMessage(shopId);
		
		for (PapaMsg entity : result) {

			arrayBuilder.add(objBuilder
					.add("shopId", entity.getPapaShop().getShopId())
					.add("msgId", entity.getMsgId())
					.add("name", entity.getPapaMem().getName())
					.add("msgDate", entity.getMsgDate().toString())
					.add("msgContent",entity.getMsgContent())
					
					.build());
		}
		out.write(objBuilder.add("list", arrayBuilder.build()).build().toString());
		out.close();
		return;
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
	}
}
