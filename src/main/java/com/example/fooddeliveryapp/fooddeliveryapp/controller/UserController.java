package com.example.fooddeliveryapp.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.fooddeliveryapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
@Controller
public class UserController {
    @Autowired
    private UserService service;
}