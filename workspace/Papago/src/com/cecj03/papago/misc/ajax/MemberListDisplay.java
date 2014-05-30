package com.cecj03.papago.misc.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cecj03.papago.model.PapaMem;
import com.cecj03.papago.model.crud.services.PapaMemCrudService;

@WebServlet("/MemberListDisplay.json")
public class MemberListDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberListDisplay() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(this.getServletContext());
		 PapaMemCrudService service = (PapaMemCrudService) context
				.getBean("PapaMemCrudService");
		 
		 List<PapaMem> MemLists = service.readAll();
		 
		 for (PapaMem entity : MemLists) {
				arrayBuilder.add(objBuilder.add("id", entity.getMemId())
						                   .add("account", entity.getAccount())
						                   .add("name",  entity.getName())
						                   .add("phone", entity.getPhone())
						                   .add("email", entity.getEmail())
						                   .add("sex", entity.getSex())
						                   .add("address", entity.getMemAddress())
						                   .add("birth", entity.getBirth().toString().substring(0, 10))
						                   .add("type",  entity.getMemType().getMemType())
						                   .add("status",  entity.getMemStatusType().getMemStatus())
						.build());
			}
			out.write(objBuilder.add("data", arrayBuilder.build()).build().toString());
			out.close();
			return;

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

}
