package com.example.springwebshopexamination.repositories;

import com.example.springwebshopexamination.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {


}
