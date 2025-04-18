package com.example.myspringapp.controller;

import com.example.myspringapp.message.ResponseMessage;
import com.example.myspringapp.dto.UserDto;
import com.example.myspringapp.mybatis.UserMapper;
import com.example.myspringapp.pojo.User;
import com.example.myspringapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping
    public ResponseMessage<Integer> add(@Validated @RequestBody UserDto user){
        int user_return = userService.add(user);
        return ResponseMessage.success(user_return);
    }

    // index
    @GetMapping("/")
    public String getIndex(){
        return "hello";
    }

    // find a user by userid
    @GetMapping("/{userId}")
    public ResponseMessage get(@PathVariable Integer userId){
        User userSelected = userService.selectById(userId);
        return ResponseMessage.success(userSelected);
    }

    // find all user
    @GetMapping("/all")
    public ResponseMessage selectAll(){
        List<User> users = userService.selectAll();
        return ResponseMessage.success(users);
    }

    // edit a user info by id
    @PutMapping("/{userId}")
    public ResponseMessage editUser(@Validated @PathVariable Integer userId, @RequestBody UserDto userInfo){
        User userEdited = userService.update(userId,userInfo);
        return ResponseMessage.success(userEdited);
    }

    // delete a user
    @DeleteMapping("/{userId}")
    public ResponseMessage deleteUser(@PathVariable Integer userId){
        userService.deleteById(userId);
        return(ResponseMessage.success());
    }
}
