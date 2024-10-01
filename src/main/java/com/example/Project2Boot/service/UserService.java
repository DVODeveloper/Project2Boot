package com.example.Project2Boot.service;

import com.example.Project2Boot.model.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    User readUser(int id);

    void updateUser(int id, User user);

    void deleteUser(int id);

    List<User> getAllUsers();
}
