package com.example.mainapplication.objects;

import android.net.Uri;

import java.util.Date;

public class Person
{
    private String name;
    private String lastName;
    private String email;
    private String image;
    private String birthday;
    private String username;
    private String password;
    private User user;

    public enum User {
        CUSTOMER,
        ADMIN,
        SELLER
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getImage() {
        return image;
    }

    public User getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
