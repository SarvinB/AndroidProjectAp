package com.example.mainapplication.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mainapplication.data.entities.Admin;
import com.example.mainapplication.data.entities.Commodity;
import com.example.mainapplication.data.entities.Customer;
import com.example.mainapplication.data.entities.Seller;

import java.util.Date;
import java.util.List;

@Dao
public interface AdminDao
{
//    @Query("INSERT INTO Admin VALUES(:allCommodityNumber, :totalPrice, :allSellerNumber)")
//    void insert(String allCommodityNumber, int totalPrice, String allSellerNumber);

    @Query("SELECT * FROM Admin")
    List<Admin> getAll();

    @Query("SELECT * FROM Admin WHERE username IN (:usernameList)")
    List<Admin> findByUsernames(String[] usernameList);

    @Query("SELECT * FROM Admin WHERE username IN (:username)")
    Admin findByUsername(String username);

    @Insert
    void insertAll(Admin admin);

    @Delete
    void delete(Admin admin);


}
