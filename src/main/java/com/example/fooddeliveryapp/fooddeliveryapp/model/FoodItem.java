package com.example.fooddeliveryapp.fooddeliveryapp.model;

import jakarta.persistence.*;

@Entity
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_id;
    private String name;
    private double price;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Restaurant restaurant;

    public FoodItem() {}

    public FoodItem(String name, double price, Restaurant restaurant) {
        setName(name);
        setPrice(price);
        setRestaurant(restaurant);
    }

    public Long getId() {
        return item_id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setId(Long item_id) {
        this.item_id = item_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
