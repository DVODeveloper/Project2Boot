package com.example.Project2Boot.service;

import com.example.Project2Boot.dao.UserDao;
import com.example.Project2Boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public User readUser(int id) {
        return userDao.readUser(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUser(int id, User user) {
        userDao.updateUser(id, user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
