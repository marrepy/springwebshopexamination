package com.example.springwebshopexamination.repositories;

import com.example.springwebshopexamination.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {


}
