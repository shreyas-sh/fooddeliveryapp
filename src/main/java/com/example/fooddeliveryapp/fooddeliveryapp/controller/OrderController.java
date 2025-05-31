package com.example.fooddeliveryapp.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.fooddeliveryapp.model.Orders;
import com.example.fooddeliveryapp.fooddeliveryapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@RequestMapping("/orders")
@Controller
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping("/all")
    public String showFoodItems(Model model) {
        List<Orders> items = service.findAll();
        model.addAttribute("orders", items);
        return "all-orders";
    }
}
