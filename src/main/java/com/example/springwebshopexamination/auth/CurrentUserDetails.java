package com.example.springwebshopexamination.auth;


import com.example.springwebshopexamination.models.User;



public class CurrentUserDetails  {
    private String name;
    private String password;
    private String email;

    public CurrentUserDetails(User user) {
        this.name = user.getName();
        this.password = user.getPassword();
        this.email = user.getEmail();
    }


    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CurrentUserDetails{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
