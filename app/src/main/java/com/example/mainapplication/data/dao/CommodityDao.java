package com.example.mainapplication.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mainapplication.data.entities.Commodity;
import com.example.mainapplication.data.entities.Customer;
import com.example.mainapplication.data.entities.User;

import java.util.Date;
import java.util.List;

@Dao
public interface CommodityDao
{
    @Query("INSERT INTO Commodity(name, price, category, image, customer, seller, admin) " +
            "VALUES(:name, :price, :category, :image, :customer, :seller, :admin)")
    void insert(String name, int price, String category, String image, String customer, String seller, String admin);

    @Query("SELECT * FROM Commodity")
    List<Commodity> getAll();

    @Query("SELECT * FROM Commodity WHERE id IN (:idList)")
    List<Commodity> findByUsername(int[] idList);

    @Delete
    void delete(Commodity commodity);
}
