package com.example.fooddeliveryapp.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.fooddeliveryapp.model.FoodItem;
import com.example.fooddeliveryapp.fooddeliveryapp.service.FoodItemService;
import com.example.fooddeliveryapp.fooddeliveryapp.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@RequestMapping("/fooditem")
@Controller
public class FoodItemController {
    @Autowired
    private FoodItemService service;

    @Autowired
    private RestaurantService resService;

    @GetMapping("/all")
    public String showFoodItems(Model model) {
        List<FoodItem> items = service.findAll();
        model.addAttribute("items", items);
        return "fooditems";
    }
}