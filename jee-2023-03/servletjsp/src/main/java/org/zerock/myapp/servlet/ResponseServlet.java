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


@Log4j2
@NoArgsConstructor

@WebServlet("/Response" )
public final class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
			log.trace("service(req, res)invoked."); 
			
//			Step.1 응답문서 구성문자들의 코딩 지
			res.setCharacterEncoding("utf8");
//			Step.2 응답무넛의 형식 지정 
			res.setContentType("text/html; charset=utf8");
			
			@Cleanup
			PrintWriter out = res.getWriter();
			
			out.println("<h1>LifecycleServlet</h1>");
			out.flush(); //출력버퍼에 잔류할지 모르는 데이터를 위해, 강제 flus(방출) 
			
	} // service

} // end class 
