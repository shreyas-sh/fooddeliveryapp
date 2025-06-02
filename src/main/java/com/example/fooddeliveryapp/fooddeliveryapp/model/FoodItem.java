package com.example.fooddeliveryapp.fooddeliveryapp.model;

import com.example.fooddeliveryapp.fooddeliveryapp.exception.WrongTypeException;
import jakarta.persistence.*;

@Entity
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_id;

    private String name;
    private double price;

    public FoodItem() {
    }

    public FoodItem(String name, double price) {
        setName(name);
        setPrice(price);
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        try {
            if (price <= 0)
                throw new WrongTypeException("Price should be positive");
            this.price = price;
        } catch (WrongTypeException e) {
            this.price = 100;
        }
    }
}
