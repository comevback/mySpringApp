package com.example.myspringapp.controller;

import com.example.myspringapp.dto.ResponseMessage;
import com.example.myspringapp.dto.UserDto;
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
    public ResponseMessage<User> add(@Validated @RequestBody UserDto user){

        User user_return = userService.add(user);
        ResponseMessage<User> returnBody = ResponseMessage.success(user_return);
        return returnBody;

        // return(userService.add(user).toString());
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
        User userEdited = userService.editById(userId,userInfo);
        return ResponseMessage.success(userEdited);
    }

    // delete a user
    @DeleteMapping("/{userId}")
    public ResponseMessage deleteUser(@PathVariable Integer userId){
        userService.deleteById(userId);
        return(ResponseMessage.success());
    }
}
