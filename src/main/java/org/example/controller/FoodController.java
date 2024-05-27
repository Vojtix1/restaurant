package org.example.controller;

import org.example.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/")
    public String getFoodItems(Model model) {
        model.addAttribute("foodItems", foodService.getAllFoodItems());
        return "foodItems";
    }

    @PostMapping("/add-to-basket")
    public String addToBasket(@RequestParam Long foodItemId) {
        foodService.addToBasket(foodItemId);
        return "redirect:/";
    }
}