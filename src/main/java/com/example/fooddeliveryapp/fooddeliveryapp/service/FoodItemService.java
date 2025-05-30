package com.example.fooddeliveryapp.fooddeliveryapp.service;

import com.example.fooddeliveryapp.fooddeliveryapp.model.FoodItem;
import com.example.fooddeliveryapp.fooddeliveryapp.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {
    private final FoodItemRepository foodItemRepository;

    @Autowired
    public FoodItemService(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    List<FoodItem> findAll() {
        return foodItemRepository.findAll();
    }

    Optional<FoodItem> findById(Long id) {
        return foodItemRepository.findById(id);
    }

    void save(FoodItem foodItem) {
        foodItemRepository.save(foodItem);
    }

    void deleteById(Long id) {
        foodItemRepository.deleteById(id);
    }
}
