package org.lyflexi.autopartitionprocedure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("org.lyflexi.autopartitionprocedure.dao")
@SpringBootApplication
@EnableScheduling
public class AutoPartitionProcedureApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoPartitionProcedureApplication.class, args);
    }

}
