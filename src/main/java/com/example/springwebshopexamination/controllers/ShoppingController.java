package com.example.springwebshopexamination.controllers;

import com.example.springwebshopexamination.models.OrderLine;
import com.example.springwebshopexamination.models.Product;
import com.example.springwebshopexamination.services.CartService;
import com.example.springwebshopexamination.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ShoppingController {

    @Autowired
    ProductService productservice;

    @Autowired
    CartService cartService;

    @GetMapping("/shopping")
    public String productIndex(Model model) {
        List<Product> productList = productservice.getAll();
        model.addAttribute("productList", productList);

        return "shoppingpage";
    }

    @PostMapping("/shopping/{id}")
    public String addToCart(@PathVariable("id") int id, Model model) {
        model.addAttribute("productList", productservice.getAll());
        OrderLine orderLine = new OrderLine(productservice.getById(id),1);
        cartService.addOrderLine(orderLine);

        return "shoppingpage";
    }


}
