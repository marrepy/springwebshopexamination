package com.example.springwebshopexamination.services;


import com.example.springwebshopexamination.models.Product;
import com.example.springwebshopexamination.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    @Autowired
    ProductRepository productRepo;

    public void add(Product product) {
        productRepo.saveAndFlush(product);
    }
}
