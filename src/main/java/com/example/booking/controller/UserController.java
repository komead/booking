package com.example.booking.controller;

import com.example.booking.entity.User;
import com.example.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/new")
    public void create(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("/edit/{userId}")
    public void editUser(@PathVariable int userId, @RequestBody User user) {
        userService.editUser(userId, user);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteUserById(userId);
    }

    @GetMapping("/users/{username}")
    public User getAll(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }
}
