package com.example.mysqlsharding;

import com.example.mysqlsharding.mapper.StudentMapper;
import com.example.mysqlsharding.model.Student;
import com.example.mysqlsharding.model.User;
import com.example.mysqlsharding.util.ApplicationContextUtil;
import com.example.mysqlsharding.util.LoginThreadCacheUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class MysqlShardingApplicationTests {


    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testLoginSearch(){

        //用户的信息可以放入数据库,我这里只是单纯模拟
        User user = new User();
        user.setSqlSessionBeanName("sqlSession4");
        LoginThreadCacheUtil.setUser(user);

        List<Student> list = studentMapper.list();
        System.out.println(list);
    }
}
