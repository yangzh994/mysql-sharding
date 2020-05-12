package com.example.mysqlsharding.config;

import com.example.mysqlsharding.model.DBModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfig {

    @Bean("dbModel1")
    public DBModel dbModel1(){
        DBModel dbModel = new DBModel();
        dbModel.setDriver("com.mysql.jdbc.Driver");
        dbModel.setUrl("jdbc:mysql:///mall1");
        dbModel.setUsername("root");
        dbModel.setPassword("yzh123");
        return dbModel;
    }

    @Bean("dbModel2")
    public DBModel dbModel2(){
        DBModel dbModel = new DBModel();
        dbModel.setDriver("com.mysql.jdbc.Driver");
        dbModel.setUrl("jdbc:mysql:///mall2");
        dbModel.setUsername("root");
        dbModel.setPassword("yzh123");
        return dbModel;
    }

    @Bean("dbModel3")
    public DBModel dbModel3(){
        DBModel dbModel = new DBModel();
        dbModel.setDriver("com.mysql.jdbc.Driver");
        dbModel.setUrl("jdbc:mysql:///mall3");
        dbModel.setUsername("root");
        dbModel.setPassword("yzh123");
        return dbModel;
    }

    @Bean("dbModel4")
    public DBModel dbModel4(){
        DBModel dbModel = new DBModel();
        dbModel.setDriver("com.mysql.jdbc.Driver");
        dbModel.setUrl("jdbc:mysql:///mall4");
        dbModel.setUsername("root");
        dbModel.setPassword("yzh123");
        return dbModel;
    }
}
