package com.example.myspringapp.repository;

import com.example.myspringapp.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository  // 数据访问层
public interface UserRepository extends CrudRepository<User, Integer> {
}

