package org.example.controller;

import org.example.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FoodController {

    @Autowired
    private FoodItemRepository foodItemRepository;

    @GetMapping("/food")
    public String listFoodItems(Model model) {
        model.addAttribute("foodItems", foodItemRepository.findAll());
        return "food";
    }
}
