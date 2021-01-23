package com.example.springwebshopexamination.services;


import com.example.springwebshopexamination.auth.CurrentUserDetails;
import com.example.springwebshopexamination.formdata.UserFormData;
import com.example.springwebshopexamination.models.Order;
import com.example.springwebshopexamination.models.User;
import com.example.springwebshopexamination.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Optional;

@Service
@SessionScope
public class UserService {


    @Autowired
    UserRepository userRepository;

    private Optional<CurrentUserDetails> currentUserDetails = Optional.empty();


    public void registerUser(UserFormData userFormData) {

        userRepository.save(new User(userFormData.getName(), userFormData.getPassword(), userFormData.getEmail()));

    }

    public Optional<User> findByEmail(String email) {

        return userRepository.findByEmail(email);
    }

    public void loadUser(String email) {
        Optional<User> optional = findByEmail(email);
        User loadedUser = optional.get();
        setCurrentUserDetails(new CurrentUserDetails(loadedUser));
    }

    public void setCurrentUserDetails(CurrentUserDetails currentUserDetails) {
        this.currentUserDetails = Optional.of(currentUserDetails);
    }

    public Optional<CurrentUserDetails> getCurrentUserDetails() {
        return currentUserDetails;
    }
}
