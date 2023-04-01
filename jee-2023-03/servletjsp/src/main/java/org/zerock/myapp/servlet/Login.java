package org.zerock.myapp.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@WebServlet("/Login")
public final class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
//		get방식은 server.xml에서 인코딩 처리하였 post방식은 web.xml에서 인코딩 처리를 하였기 때문에 필요가 없어졌다.
//		request.setCharacterEncoding("utf8"); 
		
//		Tomcat 서버의 설정으로, 모든 전송방식으로 수신된
//		전송파라터(Request Parameters)의 값을 받는 문자합을 
//	was의 설정으로 대체했기 때문에 아래의 문장이 필요 없어졌다.

//		String userid = request.getParameter("userid");
//		String passwd = request.getParameter("passwd");
//		
//		log.info("userid: {}",userid);
//		log.info("passwd: {}",passwd);
		
//		모든 수신된 전송파라미터의 목록을 출력한다. 
//		하지만 첫번째 값만 출력한다.
//		Enumeration<String> names = request.getParameterNames();
//		while(names.hasMoreElements()) {
//			String name = names.nextElement();
//			String value = request.getParameter(name);
//			log.info("\t + name: {}, value: {}",name,value);
//		}
//		getParameterValues()메소드는 전송파라미터의 다중값을 배열에 담아서 출력할 수 있다. 
		String[] hobby = request.getParameterValues("hobby");
		log.info("hobby: {}",Arrays.toString(hobby));
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		
//		out.println("<html><body>");
//		out.println("아이디값: " + userid +"<br>");
//		out.println("비밀번호값: " + passwd +"<br>");
//		out.println("</body></html>");
//		
//		
//		out.flush();
		
	} // service

} // end claas
