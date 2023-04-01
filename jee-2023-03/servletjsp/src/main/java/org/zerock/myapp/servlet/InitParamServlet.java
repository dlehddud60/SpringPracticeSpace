package org.zerock.myapp.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


//@WebServlet(//uri맵	
//		urlPatterns = "/InitParam" , 
//		initParams = { 
//				@WebInitParam(name = "dirPath", value = "C:/temp"), 
//				@WebInitParam(name = "userid", value = "Yoseph")
//		})
@Log4j2
@NoArgsConstructor
public final class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	final상수로 선언 불
//	private final String dirPath ;
//	private final String userid;
	
	private  String dirPath ;
	private  String userid;

	@Override
	public void init(ServletConfig config) //1. 서블릿 객체가 생성된 직후에 콜
			throws ServletException {
		log.trace("init({}) invoked."  , config);
//		이 서블릿만 사용가능한, 초기화파라미터 값 획득하여, 필드에 저
	this.dirPath  = config.getInitParameter("dirPath");
	this.userid = config.getInitParameter("userid");
	
	log.info("\t+ dirPath: {}, userid: {}", dirPath, userid);
	}//init

//	@Override
//	public void destroy() {		//3. 서블릿 객체가 파괴되기 전에 콜
//		log.trace("destroy() invoked." );
//
//		String dirPath = this.getInitParameter("dirPath");
//		String userid = this.getInitParameter("userid");
//		log.info("\t+ dirPath: {}, userid: {}",dirPath, userid);
//	}//destroy
	
	
	//2. 처리할 요청이 웹브라우저부터 왔을 때 서블릿 컨테이너에 의해서 역시 콜백
	@Override
	protected void service(HttpServletRequest red, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(red, res) invoked." );
		log.info("\t+ dirPath: {}, userid: {}",this.dirPath, this.userid);

	}//service

}//end class
