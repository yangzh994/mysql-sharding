package com.example.mysqlsharding.mapper;

import com.example.mysqlsharding.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM STUDENT")
    public List<Student> list();
}
