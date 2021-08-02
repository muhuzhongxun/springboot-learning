package com.xu.service;

import com.xu.pojo.User;

import java.util.List;

public interface UserService {

    List<User> queryUserList();

    User queryUserById(int id);

    User queryUserByName(String name);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
