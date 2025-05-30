package com.example.fooddeliveryapp.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.fooddeliveryapp.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/restaurant")
@Controller
public class RestaurantController {
    @Autowired
    private RestaurantService service;
}
