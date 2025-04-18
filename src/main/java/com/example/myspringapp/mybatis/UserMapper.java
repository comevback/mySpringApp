package com.example.myspringapp.mybatis;

import com.example.myspringapp.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    int add(User userInfo);

    User findById(@Param("userId") Integer userId);

    List<User> findAll();

    User update(@Param("userInfo") User userInfo);

    boolean existsById(@Param("userId") Integer userId);

    void deleteById(@Param("userId") Integer userId);
}
