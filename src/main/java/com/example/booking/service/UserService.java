package com.example.booking.service;

import com.example.booking.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    User getUserById(int id);
    void editUser(int id, User user);
    void deleteUserById(int id);
    List<User> getAll();
}
