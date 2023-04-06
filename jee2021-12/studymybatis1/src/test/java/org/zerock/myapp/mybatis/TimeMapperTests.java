package org.zerock.myapp.mybatis;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

//@NoArgsConstructor
@Log4j2
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class TimeMapperTests {
	private SqlSessionFactory factory;

   
	@BeforeAll
	  void BeforeAll() throws IOException {
	      log.trace("createSqlSessionFactory() invoked");

	  String config = "mybatis-config.xml";
	  @Cleanup InputStream is = Resources.getResourceAsStream(config);
	  	SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
	  	this.factory = builder.build(is);
	  } // beforeAll
   
   
   
// @Disabled
 @Test
 @Order(1)
 @DisplayName("testGetNow")
 @Timeout(value=1, unit=TimeUnit.SECONDS)  
 void testGetNow() throws IOException {
    log.trace("createSqlSession() invoked");
    
    Objects.requireNonNull(this.factory);
    log.info("\t +thisfactory: {}",this.factory);
    @Cleanup
    SqlSession sqlSession = this.factory.openSession();
    
    assertNotNull(sqlSession);
    log.info("\t+ sqlSession:{}",sqlSession);
    
 } // createSqlSession
   

}//end class