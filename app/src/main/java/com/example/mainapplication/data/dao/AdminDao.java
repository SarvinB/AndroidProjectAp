package com.example.mainapplication.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mainapplication.data.entities.Admin;
import com.example.mainapplication.data.entities.Commodity;
import com.example.mainapplication.data.entities.Customer;

import java.util.Date;
import java.util.List;

@Dao
public interface AdminDao
{
//    @Query("INSERT INTO Admin VALUES(:allCommodityNumber, :totalPrice, :allSellerNumber)")
//    void insert(String allCommodityNumber, int totalPrice, String allSellerNumber);

    @Query("SELECT * FROM Admin")
    List<Admin> getAll();

    @Insert
    void insertAll(Admin admin);

    @Delete
    void delete(Admin admin);


}
