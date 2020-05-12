package com.example.mysqlsharding.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.mysqlsharding.model.DBModel;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

@org.springframework.context.annotation.Configuration
public class DataSource4Config {

    @Resource
    @Qualifier("dbModel4")
    private DBModel dbModel;
//
//    @Bean("sqlSessionFactory4")
//    public SqlSessionFactory sqlSessionFactory(SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(dbModel.getDriver());
//        dataSource.setUrl(dbModel.getUrl());
//        dataSource.setUsername(dbModel.getUsername());
//        dataSource.setPassword(dbModel.getPassword());
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
//        return sqlSessionFactory;
//    }

    @Bean("sqlSession4")
    public SqlSession sqlSession(SqlSessionFactory sqlSessionFactory) throws Exception {
        Configuration configuration = sqlSessionFactory.getConfiguration();
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(dbModel.getDriver());
        dataSource.setUrl(dbModel.getUrl());
        dataSource.setUsername(dbModel.getUsername());
        dataSource.setPassword(dbModel.getPassword());
        configuration.setEnvironment(new Environment(configuration.getEnvironment().getId(),configuration.getEnvironment().getTransactionFactory(),dataSource));
        SqlSessionFactory sqlSessionFactory4 = new DefaultSqlSessionFactory(configuration);
        return sqlSessionFactory4.openSession();
    }
}
