package com.example.myspringapp.service;

import com.example.myspringapp.pojo.User;
import com.example.myspringapp.dto.UserDto;

import java.util.List;

public interface IUserService {
    // add user
    User add(UserDto user);
    // find a user
    User selectById(Integer userId);

    List<User> selectAll();

    User editById(Integer userId,UserDto userInfo);

    void deleteById(Integer userId);
}
