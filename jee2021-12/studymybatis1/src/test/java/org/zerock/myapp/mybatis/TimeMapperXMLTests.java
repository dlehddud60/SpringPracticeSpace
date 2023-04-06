package org.zerock.myapp.mybatis;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

//@NoArgsConstructor
@Log4j2
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class SqlSessionFactoryTests {
	private SqlSessionFactory factory;
	
   
	@BeforeAll
	  void BeforeAll() throws IOException {
	      log.trace("createSqlSessionFactory() invoked");
	  
	  // Step1. 마이바티스 설정파일에 대한 InputStream 을 얻음
	  // 1st. method: CLASSPATH 에 있는 경우
	  String config = "mybatis-config.xml";
	  @Cleanup InputStream is = Resources.getResourceAsStream(config);
	  log.info("\t1. is: {}", is);
	  
	  // 2nd. method:  설정파일이 프로젝트 밖에 있을 때:
	//      					설정파일의 경로를 지정
	//      String config = "/Users/nayoung/temp/mybatis-config.xml";
	//      File f = new File(config);
	//      @Cleanup InputStream is = new FileInputStream(f);
	  
	//      ---------------------
	//      Step.2 SqlSessionFactory 을 세우는 건설사(Builder)생성
	  	SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
	    log.info("\t2. builder: {}", builder);
	  	
	//      Step.3 SqlSessionFactoryBuilder 와 설정파일에 대한 InputStream을 이용해서, 공장 생성
	  	this.factory = builder.build(is);
	    log.info("\t3. this.factory: {}", this.factory);
	  } // beforeAll
   
   
   
// @Disabled
 @Test
 @Order(1)
 @DisplayName("createSqlSessionFactory")
 @Timeout(value=1, unit=TimeUnit.SECONDS)  
 void createSqlSession() throws IOException {
    log.trace("createSqlSession() invoked");
    
    Objects.requireNonNull(this.factory);
    log.info("\t +thisfactory: {}",this.factory);
    @Cleanup
    SqlSession sqlSession = this.factory.openSession();
    
    assertNotNull(sqlSession);
    log.info("\t+ sqlSession:{}",sqlSession);
    
 } // createSqlSession
   

}//end class