package com.example.springwebshopexamination.repositories;

import com.example.springwebshopexamination.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {



}
