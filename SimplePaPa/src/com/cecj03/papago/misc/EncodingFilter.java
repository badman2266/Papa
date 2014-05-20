package com.cecj03.papago.misc;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

@WebFilter("/*")

public class EncodingFilter implements Filter {

    public EncodingFilter() {
    	
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		request.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);
	}
	
	private FilterConfig config;
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

}
