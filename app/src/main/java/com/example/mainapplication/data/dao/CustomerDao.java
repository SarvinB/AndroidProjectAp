package com.example.mainapplication.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mainapplication.data.entities.Customer;
import com.example.mainapplication.data.entities.Seller;

import java.util.Date;
import java.util.List;

@Dao
public interface CustomerDao
{
//    @Query("INSERT INTO Customer VALUES(:username, :name, :lastName, :email, :password, :image, :birthday, :commodityNumber, :loginNumber)")
//    void insert(String username, String name, String lastName, String email, String password, String image, String birthday, String commodityNumber, String loginNumber);

    @Query("SELECT * FROM Customer")
    List<Customer> getAll();

    @Query("SELECT * FROM Customer WHERE username IN (:username)")
    Customer findByUsername(String username);

    @Query("SELECT * FROM Customer WHERE username IN (:usernameList)")
    List<Customer> findByUsernames(String[] usernameList);

    @Insert
    void insertAll(Customer customer);

    @Delete
    void delete(Customer customer);
}
