package com.example.booking.controller;

import com.example.booking.entity.User;
import com.example.booking.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    private PasswordEncoder passwordEncoder;

    @PostMapping("/new")
    public String create(@ModelAttribute User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addUser(user);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable(value = "id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable(value = "id") int id, @ModelAttribute User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.editUser(id, user);
        return "redirect:/user";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable(value = "id") int id) {
        userService.deleteUserById(id);
        return "redirect:/user";
    }

    @GetMapping("")
    public String getAll(Model model) {
        Iterable<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "user";
    }
}
