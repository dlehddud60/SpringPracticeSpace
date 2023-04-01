package org.zerock.myapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2
@WebServlet("/ContextParam")
public final class ContextParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req,res invoked. ");
		ServletContext ctx = req.getServletContext();
//		ServletContext ctx2 = this.getServletContext(); 비추
		
		String driver = ctx.getInitParameter("driver");
		String savePath = ctx.getInitParameter("savePath");
		
		
		res.setCharacterEncoding("utf8");
		res.setContentType("text/html; charset=utf-8");
		
		
		@Cleanup
		PrintWriter out = res.getWriter();
		
		out.println("<h1>1. driver: " + driver + "</h1>");
		out.println("h1>2. driver: " + savePath + "</h1>");
		
		out.flush();
		
		
	}//service

}//end class
