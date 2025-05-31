package com.example.fooddeliveryapp.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.fooddeliveryapp.model.User;
import com.example.fooddeliveryapp.fooddeliveryapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/users")
@Controller
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/all")
    public String showFoodItems(Model model) {
        List<User> items = service.findAll();
        model.addAttribute("users", items);
        return "all-users";
    }
}