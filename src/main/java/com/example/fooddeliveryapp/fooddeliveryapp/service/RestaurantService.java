package com.example.fooddeliveryapp.fooddeliveryapp.service;

import com.example.fooddeliveryapp.fooddeliveryapp.model.Restaurant;
import com.example.fooddeliveryapp.fooddeliveryapp.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    Optional<Restaurant> findById(Long id) {
        return restaurantRepository.findById(id);
    }

    void save(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    void deleteById(Long id) {
        restaurantRepository.deleteById(id);
    }
}
