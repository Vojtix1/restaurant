package org.example.controller;

import org.example.entity.Basket;
import org.example.entity.FoodItem;
//import org.example.entity.User;
import org.example.repository.BasketRepository;
import org.example.repository.FoodItemRepository;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;


@Controller
public class BasketController {

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/basket/add")
    public String addToBasket(@RequestParam Long foodItemId, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        Basket basket = basketRepository.findByUser(user);
        if (basket == null) {
            basket = new Basket();
            basket.setUser(user);
        }
        FoodItem foodItem = foodItemRepository.findById(foodItemId).orElseThrow();
        return "redirect:/basket";
    }

    @GetMapping("/basket")
    public String viewBasket(Model model, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        Basket basket = basketRepository.findByUser(user);
        model.addAttribute("basket", basket);
        return "basket";
    }
}
