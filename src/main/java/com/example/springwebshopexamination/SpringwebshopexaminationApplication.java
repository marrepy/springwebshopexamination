package com.example.springwebshopexamination;

import com.example.springwebshopexamination.models.OrderLine;
import com.example.springwebshopexamination.models.Product;
import com.example.springwebshopexamination.repositories.ProductRepository;
import com.example.springwebshopexamination.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringwebshopexaminationApplication {

    @Autowired
    ProductRepository productRepository;



    public static void main(String[] args) {
        SpringApplication.run(SpringwebshopexaminationApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(CartService cart) {
        return (args) -> {

//
//            productRepository.save(new Product("Milk", 10));
//            productRepository.save(new Product("Apple", 5));
//            productRepository.save(new Product("Cheese", 60));

            //cart.addOrderLine(new OrderLine(new Product("Cheese", 60), 2));


        };
    }

}
