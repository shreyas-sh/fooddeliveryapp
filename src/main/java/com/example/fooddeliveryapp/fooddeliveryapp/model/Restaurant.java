package com.example.fooddeliveryapp.fooddeliveryapp.model;

import com.example.fooddeliveryapp.fooddeliveryapp.exception.WrongTypeException;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurant_id;

    private String name;
    private String location;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "restaurant_id")  // FK column in FoodItem table
    private List<FoodItem> foodItemList = new ArrayList<>();

    public Restaurant() {}

    public Restaurant(String name, String location) {
        setName(name);
        setLocation(location);
    }

    public Long getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        try {
            if (!Character.isUpperCase(location.charAt(0)))
                throw new WrongTypeException("Invalid location name");
            this.location = location;
        } catch (WrongTypeException e) {
            if (location == null || location.isEmpty())
                location = "";
            else
                location = location.substring(0, 1).toUpperCase() + location.substring(1).toLowerCase();
            this.location = location;
        }
    }

    public List<FoodItem> getFoodItemList() {
        return foodItemList;
    }

    public void setFoodItemList(List<FoodItem> foodItemList) {
        this.foodItemList = foodItemList;
    }
}
