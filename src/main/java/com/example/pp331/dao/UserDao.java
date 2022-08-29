package com.example.pp331.dao;

import com.example.pp331.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {
    public User saveUser(User user);
    public User deleteUser(User user);
    public User updateUser(User user);
    public User getUser(int id);

    List<User> usersList();
}
