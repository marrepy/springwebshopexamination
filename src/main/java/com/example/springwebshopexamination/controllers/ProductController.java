package com.example.springwebshopexamination.controllers;


import com.example.springwebshopexamination.models.Product;
import com.example.springwebshopexamination.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("products", productService.getAll());
        return "productindex";
    }

    @PostMapping("/products")
    public String addProduct(Product product, Model model) {
        model.addAttribute("products", productService.getAll());
        productService.add(product);

        return "redirect:productindex";
    }

}
