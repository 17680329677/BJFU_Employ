package com.tbms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tbms.core.dao")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}