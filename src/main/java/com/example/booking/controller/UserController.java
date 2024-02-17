package com.example.booking.controller;

import com.example.booking.entity.User;
import com.example.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/new")
    public String create(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "editUser";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable(value = "id") int id, @ModelAttribute User user) {
        userService.editUser(id, user);
        return "redirect:/user";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable(value = "id") int id) {
        userService.deleteUserById(id);
        return "redirect:/user";
    }

    @GetMapping("/users/{username}")
    public User getUser(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping("")
    public String getAll(Model model) {
        Iterable<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "user";
    }
}
