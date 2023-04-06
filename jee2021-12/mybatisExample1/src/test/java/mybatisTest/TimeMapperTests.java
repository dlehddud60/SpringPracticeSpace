package mybatisTest;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Log4j2
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TimeMapperTests {
    private SqlSessionFactory factory;

    @BeforeAll
    void BeforeAll() throws IOException {
        log.trace("createSqlSessionFactoryTests invoked. ");

        String config = "mybatis-config.xml";
        @Cleanup
        InputStream is = Resources.getResourceAsStream(config);
        log.info("\t1. is: {}", is);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        log.info("\t2. builder: {}", builder);

        this.factory = builder.build(is);
        log.info("\t3. this.factory: {}", this.factory);
    }

    @Test
    @Order(1)
    @DisplayName("createSqlSessionFactory")
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void createSqlSession() {
        log.trace("createSqlSession() invoked. ");

        Objects.requireNonNull(this.factory);
        log.info("\t + thisfactory: {}",this.factory);


    }
}
