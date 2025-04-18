package com.example.myspringapp.service;

import com.example.myspringapp.dto.UserDto;
import com.example.myspringapp.mybatis.UserMapper;
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
    // SPA
//    @Autowired
//    UserRepository userRepository;

    // MyBatis
    @Autowired
    UserMapper userMapper;

    @Override
    public int add(UserDto user){
        // call repository class
        // 数据库里不能直接存DTO类型的，必须存Pojo里的User类型，所以这里创建一个User对象，把DTO类型的user拷贝过来，在输入数据库
        User userPojo = new User();
        BeanUtils.copyProperties(user,userPojo);

        // spa
        // return userRepository.save(userPojo);

        // mybatis
        return userMapper.add(userPojo);
    }

    @Override
    public User selectById(Integer userId){
        // spa
//        return userRepository.findById(userId).orElseThrow(() ->{
//            throw new IllegalArgumentException("error: user not exist");
//        });

        // mybatis
        User userReturn =  userMapper.findById(userId);
        if (userReturn == null){
            throw new IllegalArgumentException("error: user not exist");
        }else {
            return userReturn;
        }
    }

    @Override
    public List<User> selectAll(){
        // spa
//        List<User> userlist = new ArrayList<User>();
//        for (User user : userRepository.findAll()){
//            userlist.add(user);
//        }

        // mybatis
        return userMapper.findAll();
    }

    @Override
    public User update(Integer userId, UserDto userInfo){
        if (!Objects.equals(userInfo.getUserId(), userId)){
            throw new IllegalArgumentException("Mismatched userId: path=" + userId + ", body=" + userInfo.getUserId());
        }

        User userPojo = new User();
        BeanUtils.copyProperties(userInfo,userPojo);

        // spa
//        return userRepository.save(userPojo);

        // mybatis
        return userMapper.update(userPojo); // mybatis的findAll返回的就直接是一个List
    }

    @Override
    public void deleteById(Integer userId){
        // spa
//        if (!userRepository.existsById(userId)){
//            throw new IllegalArgumentException("Wrong userId");
//        }
//        userRepository.deleteById(userId);

        // mybatis
        if (!userMapper.existsById(userId)){
            throw new IllegalArgumentException("Wrong userId");
        }
        userMapper.deleteById(userId);
    }
}

