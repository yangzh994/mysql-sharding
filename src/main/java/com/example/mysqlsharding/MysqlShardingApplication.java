package com.example.mysqlsharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mysqlsharding.mapper")
public class MysqlShardingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlShardingApplication.class, args);
    }

}
