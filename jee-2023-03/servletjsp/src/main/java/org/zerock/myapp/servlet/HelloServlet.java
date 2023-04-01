package org.zerock.myapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


//@WebServlet(
//		description = "Our First Servlet Web Component.", 
//		urlPatterns = { 
//				"/Hello", 
//				"/Nayoung", 
//				"/YYY"
//		})

//서블릿은 반드시 매개변수가 없는 기본 생성자가 있어야 한다.
//서블릿은 반드시 HTTPServlte을 상속해야 한다.
//서블이 어떤 요청방식으로 전송된 요청이든 처리하고 싶을 때에는, 아래와 같이 반드시 service()메소드를 오버라이딩 하면 된다.
@Log4j2
@NoArgsConstructor

@WebServlet(name="HelloServlet",  value= { "/Hello", "/World"})
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req,res) invoked.");
		
		log.info("\t1. 전송방식: {}",req.getMethod());
		log.info("\t2. 요청URI: {}",req.getRequestURI());
		log.info("\t3. 요청URL: {}",req.getRequestURL());
		log.info("\t4. 요청Protocol: {}", req.getProtocol()); //HTTP OR HTTPS
		log.info("\t5. 요청ContexRoot: {}",req.getPathInfo());
		log.info("\t2. 요청을보낸클라이언트주: {}",req.getRemoteAddr());
		log.info("\t7. 요청을보낸클라이언트세션ID: {}",req.getRequestedSessionId());
		@Cleanup
		PrintWriter out = res.getWriter();
		
		out.println("Hello, Worldjj!!!");
		
		out.flush();
			
	} // Service

} // end class 
