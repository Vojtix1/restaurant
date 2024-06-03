package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImageControllerPizza {

    @GetMapping("/dynamic-image")
    public String getDynamicImage(Model model) {
        String imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a3/Eq_it-na_pizza-margherita_sep2005_sml.jpg/640px-Eq_it-na_pizza-margherita_sep2005_sml.jpg";
        model.addAttribute("imageUrl", imageUrl);
        return "dynamicImage";
    }
}
