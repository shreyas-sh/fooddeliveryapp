package com.example.fooddeliveryapp.fooddeliveryapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;
    private Long user_id;
    private Long restaurant_id;
    private Long food_item_id;

    public Orders() {}

    public Orders(Long user_id, Long restaurant_id, Long food_item_id) {
        setUser_id(user_id);
        setRestaurant_id(restaurant_id);
        setFood_item_id(food_item_id);
    }

    public Long getOrder_id() {
        return order_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public Long getRestaurant_id() {
        return restaurant_id;
    }

    public Long getFood_item_id() {
        return food_item_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public void setRestaurant_id(Long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public void setFood_item_id(Long food_item_id) {
        this.food_item_id = food_item_id;
    }
}