package com.example.fooddeliveryapp.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.fooddeliveryapp.model.User;
import com.example.fooddeliveryapp.fooddeliveryapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Optional;

@RequestMapping("/users")
@Controller
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/all")
    public String showUsers(Model model) {
        List<User> users = service.findAll();
        model.addAttribute("users", users);
        return "all-users";
    }

    @GetMapping("/findbyid")
    public String inputIdForm() {
        return "user-by-id";
    }

    @PostMapping("/resultbyid")
    public String getUserById(@RequestParam("id") Long id, Model model) {
        Optional<User> user = service.findById(id);
        user.ifPresent(value -> model.addAttribute("users", value));
        return "all-users";
    }

    @GetMapping("/adduser")
    public String addUser() {
        return "add-user";
    }

    @PostMapping("/all")
    public String addedUserDisplay(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            Model model
    ) {
        User user = new User(name, email);
        service.save(user);
        return showUsers(model);
    }
}