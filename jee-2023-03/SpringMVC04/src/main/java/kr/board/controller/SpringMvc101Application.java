package kr.board.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("kr.board.mapper")
public class SpringMvc101Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvc101Application.class, args);
    }

}
