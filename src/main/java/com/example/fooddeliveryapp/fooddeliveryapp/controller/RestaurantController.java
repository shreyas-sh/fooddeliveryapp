package com.example.fooddeliveryapp.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.fooddeliveryapp.model.Restaurant;
import com.example.fooddeliveryapp.fooddeliveryapp.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@RequestMapping("/restaurant")
@Controller
public class RestaurantController {
    @Autowired
    private RestaurantService service;

    @GetMapping("/all")
    public String showFoodItems(Model model) {
        List<Restaurant> items = service.findAll();
        model.addAttribute("restaurants", items);
        return "all-restaurants";
    }

    @GetMapping("/findbyid")
    public String inputIdForm() {
        return "restaurant-by-id";
    }

    @PostMapping("/resultbyid")
    public String getFoodById(@RequestParam("id") Long id, Model model) {
        Optional<Restaurant> restaurant = service.findById(id);
        restaurant.ifPresent(value -> model.addAttribute("restaurants", value));
        return "all-restaurants";
    }
}
