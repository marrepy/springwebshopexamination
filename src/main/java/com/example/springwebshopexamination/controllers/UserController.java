package com.example.springwebshopexamination.controllers;

import com.example.springwebshopexamination.auth.CurrentUserDetails;
import com.example.springwebshopexamination.formdata.UserFormData;
import com.example.springwebshopexamination.models.OrderLine;
import com.example.springwebshopexamination.models.User;
import com.example.springwebshopexamination.services.CartService;
import com.example.springwebshopexamination.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    CartService cartService;


    @GetMapping("/user/login")
    public String showLogin(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/user/registration")
    public String showRegisterUser(Model model) {
        model.addAttribute("user", new UserFormData());
        return "registration";
    }

    @PostMapping("/user/login")
    public String loginUser(@ModelAttribute("user") User user, Model model) {
        Optional<User> optionalUser = userService.findByEmail(user.getEmail());
        log.info("Passwords are same: " + (optionalUser.isPresent() && user.getPassword().equals(optionalUser.get().getPassword())));
        if (optionalUser.isPresent() && user.getPassword().equals(optionalUser.get().getPassword())) {
            userService.loadUser(user.getEmail());

            log.info(userService.getCurrentUserDetails().get().toString());
            CurrentUserDetails currentUserDetails = userService.getCurrentUserDetails().get();
            model.addAttribute("currentUser", currentUserDetails);
            return "submit";

        } else {
            model.addAttribute("user", new User());
            return "login";        }


    }

    @PostMapping("user/registration")
    public String registerUser(@ModelAttribute("user") UserFormData userFormData, Model model) {
        System.out.println(userFormData.toString());

        userService.registerUser(userFormData);
        List<OrderLine> orderLines = cartService.getOrderLines();
        model.addAttribute("orderlines", orderLines);
        return "cart";
    }



}
