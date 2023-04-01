package org.zerock.myapp.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
@WebServlet("/contextFile")
public final class contextFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
		
//		String path = "/WEB-INF/testFile.txt";
		String path = "/WEB-INF/web.xml";
//		String readFile = "/WEB-INF/testFile.txt";
		
		ServletContext sc = req.getServletContext();
		
		@Cleanup
		InputStream is = sc.getResourceAsStream(path);
		
		@Cleanup
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		// 응답문서 생성 및 전송 
//		res.setContentType("text/html; charset=UTF-8");
		res.setContentType("application/xml; charset=UTF-8");
		
		@Cleanup
		PrintWriter out = res.getWriter();
		
		out.println("<p>");
		
		String line = null;
		
		while((line = br.readLine()) != null) {
			out.println(line+"<br>");
		} // while
		
		out.println("</p>");
		
		out.println("</pre>");
		
		out.flush();
	} // service

} // end class 
