package com.example.fooddeliveryapp.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.fooddeliveryapp.model.Restaurant;
import com.example.fooddeliveryapp.fooddeliveryapp.model.User;
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

    @GetMapping("/")
    public String rootPage(Model model) {
        return "restaurant-root-page";
    }

    @GetMapping("/all")
    public String showRestaurants(Model model) {
        List<Restaurant> items = service.findAll();
        model.addAttribute("restaurants", items);
        return "all-restaurants";
    }

    @GetMapping("/findbyid")
    public String inputIdForm() {
        return "restaurant-by-id";
    }

    @PostMapping("/resultbyid")
    public String getRestaurantById(@RequestParam("id") Long id, Model model) {
        Optional<Restaurant> restaurant = service.findById(id);
        restaurant.ifPresent(value -> model.addAttribute("restaurants", value));
        return "all-restaurants";
    }

    @GetMapping("/deletebyid")
    public String deleteIdForm(Model model) {
        return "delete-restaurant-by-id";
    }

    @PostMapping("/all")
    public String deleteRestaurantById(@RequestParam("id") Long id, Model model) {
        Optional<Restaurant> deletedRestaurant = service.findById(id);
        service.deleteById(id);
        return showRestaurants(model);
    }

    @GetMapping("/addrestaurant")
    public String addRestaurant(Model model) {
        return "add-restaurant";
    }

    @PostMapping("/intermediate")
    public String addedRestaurantDisplay(
            @RequestParam("name") String name,
            @RequestParam("location") String location,
            Model model
    ) {
        service.save(new Restaurant(name, location));
        return showRestaurants(model);
    }

    @PostMapping("/deleteall")
    public String deleteAll(Model model) {
        service.deleteAll();
        return showRestaurants(model);
    }
}
