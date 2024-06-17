package org.example.service;

import org.example.entity.Basket;
import org.example.entity.FoodItem;
import org.example.repository.BasketRepository;
import org.example.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodItemRepository foodItemRepository;

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private BasketService basketService;

    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    public void addToBasket(Long foodItemId) {
        Long defaultBasketId = 1L;
        basketService.addFoodItemToBasket(defaultBasketId, foodItemId);
    }

//    public void addToBasket(Long foodItemId) {
//        FoodItem foodItem = foodItemRepository.findById(foodItemId).orElseThrow(() -> new RuntimeException("Food item not found"));
//
//        Basket basket = basketRepository.findById(1L).orElseGet(() -> {
//            Basket newBasket = new Basket();
//            return basketRepository.save(newBasket);
//        });
//
//        basket.getItems().add(foodItem);
//        basketRepository.save(basket);
//    }
}
