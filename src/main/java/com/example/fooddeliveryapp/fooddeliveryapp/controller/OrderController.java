package com.example.fooddeliveryapp.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.fooddeliveryapp.model.FoodItem;
import com.example.fooddeliveryapp.fooddeliveryapp.model.Orders;
import com.example.fooddeliveryapp.fooddeliveryapp.model.Restaurant;
import com.example.fooddeliveryapp.fooddeliveryapp.model.User;
import com.example.fooddeliveryapp.fooddeliveryapp.service.FoodItemService;
import com.example.fooddeliveryapp.fooddeliveryapp.service.OrderService;
import com.example.fooddeliveryapp.fooddeliveryapp.service.RestaurantService;
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

@RequestMapping("/orders")
@Controller
public class OrderController {
    @Autowired
    private OrderService service;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;

    @Autowired
    private FoodItemService foodItemService;

    @GetMapping("/all")
    public String showOrders(Model model) {
        List<Orders> items = service.findAll();
        model.addAttribute("orders", items);
        return "all-orders";
    }

    @GetMapping("/")
    public String rootPage(Model model) {
        return "order-root-page";
    }

    @GetMapping("/findbyid")
    public String inputIdForm() {
        return "order-by-id";
    }

    @PostMapping("/resultbyid")
    public String getOrderById(@RequestParam("id") Long id, Model model) {
        Optional<Orders> order = service.findById(id);
        order.ifPresent(value -> model.addAttribute("items", value));
        return "all-orders";
    }

    @GetMapping("/deletebyid")
    public String deleteIdForm(Model model) {
        return "delete-order-by-id";
    }

    @PostMapping("/deletebyid")
    public String deleteOrderById(@RequestParam("id") Long id, Model model) {
        service.deleteById(id);
        return showOrders(model);
    }

    @GetMapping("/addorder")
    public String addFoodItem(Model model) {
        return "add-order";
    }

    @PostMapping("/intermediate")
    public String addedFoodItemDisplay(
            @RequestParam("user_id") Long user_id,
            @RequestParam("restaurant_id") Long restaurant_id,
            @RequestParam("food_item_id") Long food_item_id,
            Model model
    ) {
        Optional<User> user = userService.findById(user_id);
        Optional<Restaurant> restaurant = restaurantService.findById(restaurant_id);
        Optional<FoodItem> foodItem = foodItemService.findById(food_item_id);
        if (restaurant.isPresent() && user.isPresent() && foodItem.isPresent()) {
            service.save(new Orders(user_id, restaurant_id, food_item_id));
        } else {
            model.addAttribute("message", "User ID or Restaurant ID or Food Item ID not found");
            return "message";
        }
        return showOrders(model);
    }

    @PostMapping("/deleteall")
    public String deleteAll(Model model) {
        service.deleteAll();
        return showOrders(model);
    }
}
