package com.example.springwebshopexamination.controllers;

import com.example.springwebshopexamination.models.OrderLine;
import com.example.springwebshopexamination.models.User;
import com.example.springwebshopexamination.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/cart")
    public String showCartIndex(Model model) {
        List<OrderLine> orderLines = cartService.getOrderLines();
        model.addAttribute("orderlines", orderLines);

        return "cart";

    }

    @GetMapping("/cart/checkout")
    public String checkout(Model model) {

        model.addAttribute("user", new User());

        return "checkout";
    }
}
