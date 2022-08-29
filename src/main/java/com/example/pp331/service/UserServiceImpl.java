package com.example.pp331.service;

import com.example.pp331.dao.UserDao;
import com.example.pp331.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public void setUserDao (UserDao userDao){
        this.userDao=userDao;
    }

    @Transactional
    public User saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Transactional
    public User deleteUser(User user) {
        return userDao.deleteUser(user);
    }

    @Transactional
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Transactional
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public List<User> usersList() {
        return userDao.usersList();
    }
}
