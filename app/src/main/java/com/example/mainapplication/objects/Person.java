package com.example.mainapplication.objects;

import android.net.Uri;

import com.example.mainapplication.data.entities.Admin;
import com.example.mainapplication.data.entities.Customer;
import com.example.mainapplication.data.entities.Seller;

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

    public static Person getPerson(Customer customer)
    {
        Person person = new Person();
        person.setImage(customer.image);
        person.setLastName(customer.lastname);
        person.setName(customer.name);
        person.setUser(User.SELLER);
        person.setBirthday(customer.birthday);
        person.setUsername(customer.userName);
        person.setEmail(customer.email);
        person.setPassword(customer.password);
        return person;
    }

    public static Person getPerson(Admin admin, User user)
    {
        Person person = new Person();
        person.setImage(admin.image);
        person.setLastName(admin.lastname);
        person.setName(admin.name);
        person.setUser(user);
        person.setBirthday(admin.birthday);
        person.setUsername(admin.userName);
        person.setEmail(admin.email);
        person.setPassword(admin.password);
        return person;

    }

    public static Person getPerson(Seller seller)
    {
        Person person = new Person();
        person.setImage(seller.image);
        person.setLastName(seller.lastname);
        person.setName(seller.name);
        person.setUser(User.CUSTOMER);
        person.setBirthday(seller.birthday);
        person.setUsername(seller.userName);
        person.setEmail(seller.email);
        person.setPassword(seller.password);
        return person;

    }
}
