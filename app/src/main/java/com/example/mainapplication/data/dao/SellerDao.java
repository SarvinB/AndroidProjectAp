package com.example.mainapplication.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mainapplication.data.entities.Commodity;
import com.example.mainapplication.data.entities.Customer;
import com.example.mainapplication.data.entities.Seller;

import java.util.Date;
import java.util.List;

@Dao
public interface SellerDao
{
//    @Query("INSERT INTO Seller VALUES(:commodityNumber, :loginNumber)")
//    void insert(String commodityNumber, String loginNumber);

    @Query("SELECT * FROM Seller")
    List<Seller> getAll();

    @Query("SELECT * FROM Seller WHERE username IN (:usernameList)")
    List<Seller> findByUsername(String[] usernameList);

    @Insert
    void insertAll(Seller seller);

    @Delete
    void delete(Seller seller);
}
