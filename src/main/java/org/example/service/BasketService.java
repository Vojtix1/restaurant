package org.example.service;

import org.example.entity.Basket;
import org.example.entity.FoodItem;
import org.example.repository.BasketRepository;
import org.example.repository.FoodItemRepository;
import org.example.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private FoodService foodService;
    @Autowired
    private FoodItemRepository foodItemRepository;

    public Basket getBasketById(Long id) {
        return basketRepository.findById(id).orElse(null);

    }

    public void addFoodItemToBasket(Long id, Long foodItemId) {
        Basket basket = basketRepository.findById(id).orElse(null);
        FoodItem foodItem = foodItemRepository.findById(foodItemId).orElse(null);

        basket.getItems().add(foodItem);
        basketRepository.save(basket);
    }

        public List<FoodItem> getAllFoodItemsInBasket(Long Id) {
            Basket basket = basketRepository.findById(Id).orElse(null);
            return basket.getItems();
    }
}
