package com.example.myspringapp.service;

import com.example.myspringapp.dto.UserDto;
import com.example.myspringapp.pojo.User;
import com.example.myspringapp.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service //业务逻辑层
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User add(UserDto user){
        // call repository class
        // 数据库里不能直接存DTO类型的，必须存Pojo里的User类型，所以这里创建一个User对象，把DTO类型的user拷贝过来，在输入数据库
        User userPojo = new User();
        BeanUtils.copyProperties(user,userPojo);
        return userRepository.save(userPojo);
    }

    @Override
    public User selectById(Integer userId){
        return userRepository.findById(userId).orElseThrow(() ->
            new IllegalArgumentException("error: user not exist")
        );
    }

    @Override
    public List<User> selectAll(){
        List<User> userlist = new ArrayList<User>();
        for (User user : userRepository.findAll()){
            userlist.add(user);
        }

        return userlist;
    }

    @Override
    public User editById(Integer userId, UserDto userInfo){
        if (!Objects.equals(userInfo.getUserId(), userId)){
            throw new IllegalArgumentException("Mismatched userId: path=" + userId + ", body=" + userInfo.getUserId());
        }

        User userPojo = new User();
        BeanUtils.copyProperties(userInfo,userPojo);
        return userRepository.save(userPojo);
    }

    @Override
    public void deleteById(Integer userId){
        if (!userRepository.existsById(userId)){
            throw new IllegalArgumentException("Wrong userId");
        }
        userRepository.deleteById(userId);
    }
}

