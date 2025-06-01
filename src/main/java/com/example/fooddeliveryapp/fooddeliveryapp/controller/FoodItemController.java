package com.example.fooddeliveryapp.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.fooddeliveryapp.model.FoodItem;
import com.example.fooddeliveryapp.fooddeliveryapp.model.Restaurant;
import com.example.fooddeliveryapp.fooddeliveryapp.service.FoodItemService;
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

@RequestMapping("/fooditem")
@Controller
public class FoodItemController {
    @Autowired
    private FoodItemService service;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/all")
    public String showFoodItems(Model model) {
        List<FoodItem> items = service.findAll();
        model.addAttribute("items", items);
        return "all-food-items";
    }

    @GetMapping("/findbyid")
    public String inputIdForm() {
        return "food-item-by-id";
    }

    @PostMapping("/resultbyid")
    public String getFoodItemById(@RequestParam("id") Long id, Model model) {
        Optional<FoodItem> item = service.findById(id);
        item.ifPresent(value -> model.addAttribute("items", value));
        return "all-food-items";
    }

    @GetMapping("/deletebyid")
    public String deleteIdForm(Model model) {
        return "food-item-by-id";
    }

    @PostMapping("/deletebyid")
    public String deleteFoodItemById(@RequestParam("id") Long id, Model model) {
        service.deleteById(id);
        return "all-restaurants";
    }

    @GetMapping("/addfooditem")
    public String addFoodItem(Model model) {
        return "add-food-item";
    }

    @PostMapping("/intermediate")
    public String addedFoodItemDisplay(
            @RequestParam("name") String name,
            @RequestParam("price") double price,
            @RequestParam("restaurant_id") Long restaurant_id,
            Model model
    ) {
        Optional<Restaurant> restaurantOptional = restaurantService.findById(restaurant_id);
        if (restaurantOptional.isPresent()) {
            service.save(new FoodItem(name, price, restaurantOptional.get()));
        } else {
            model.addAttribute("message", "Restaurant ID not found");
            return "message";
        }
        return "all-food-items";
    }
}