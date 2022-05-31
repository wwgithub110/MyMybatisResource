package com.mytest.mapper;

import com.mytest.model.User;

import java.util.List;

public interface UserMapper {
  List<User> findAll();
  User selectUser(Integer id);
  int saveUser(User user);
}
