package com.office.datasirpi.data.service;

import com.office.datasirpi.data.entity.User;

import java.util.List;

public interface UserService {

    List<User> listAllUser();

    void saveUser(User user);

    User getUser(Integer id);

    void deleteUser(Integer id);
}
