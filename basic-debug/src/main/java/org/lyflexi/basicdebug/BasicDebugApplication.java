package org.lyflexi.basicdebug;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("org.lyflexi.basicdebug.dao")
@SpringBootApplication
@EnableScheduling
public class BasicDebugApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicDebugApplication.class, args);
	}

}
