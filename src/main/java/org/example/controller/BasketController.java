package org.example.controller;

import org.example.entity.Basket;
import org.example.entity.FoodItem;
import org.example.service.BasketService;
import org.example.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

@Controller
public class BasketController {

    @Autowired
    private FoodService foodService;


//    public BasketController(BasketService basketService) {
//        this.basketService = basketService;
//    }

    @Autowired
    private BasketService basketService;

    @GetMapping("/basket/{basketId}")
        public String getBasket(@PathVariable Long basketId, Model model) {
        Basket basket = basketService.getBasketById(basketId);
        model.addAttribute("basket", basket);
        return "basket";
    }
}