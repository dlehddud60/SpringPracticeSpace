package org.zerock.myapp.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j2;
@Log4j2
@WebServlet({ "/ContextSet", "/ContextGet" })
public  class ContextSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req,res invoked. ");
		
		ServletContext sc = this.getServletContext();
		ServletConfig config = this.getServletConfig();
		
		log.info("\t+ sc: {}, config: {},",sc,config);
		
		
	}
	

}
