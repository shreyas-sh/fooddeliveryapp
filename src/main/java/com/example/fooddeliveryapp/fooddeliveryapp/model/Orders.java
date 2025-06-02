package com.example.fooddeliveryapp.fooddeliveryapp.model;

import jakarta.persistence.*;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "food_item_id", nullable = false)
    private FoodItem foodItem;

    public Orders() {}

    public Orders(User user, Restaurant restaurant, FoodItem foodItem) {
        this.user = user;
        this.restaurant = restaurant;
        this.foodItem = foodItem;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }
}
