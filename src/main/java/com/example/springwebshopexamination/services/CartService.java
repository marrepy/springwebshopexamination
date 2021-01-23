package com.example.springwebshopexamination.services;

import com.example.springwebshopexamination.models.OrderLine;
import com.example.springwebshopexamination.models.Product;
import com.example.springwebshopexamination.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
@SessionScope
public class CartService {

    List<OrderLine> orderLines = new ArrayList<>();

    @Autowired
    OrderRepository orderRepository;

    CartService() {

        addOrderLine(new OrderLine(new Product("Cheese", 60), 2));

    }

public List<OrderLine> getOrderLines() {
return orderLines;
}

public void addOrderLine(OrderLine orderLine) {
    orderLines.add(orderLine);
}



}
