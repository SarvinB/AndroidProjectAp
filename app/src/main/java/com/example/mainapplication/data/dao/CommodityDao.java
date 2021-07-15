package com.example.mainapplication.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;

import com.example.mainapplication.data.entities.Commodity;

import java.util.List;

@Dao
public interface CommodityDao
{
    @Query("INSERT INTO Commodity(name, price, category, image, customer, seller, phoneNumber) " +
            "VALUES(:name, :price, :category, :image, :customer, :seller, :phoneNumber)")
    void insert(String name, int price, String category, String image, String customer, String seller, String phoneNumber);

    @Query("SELECT * FROM Commodity")
    List<Commodity> getAll();

    @Query("SELECT * FROM Commodity WHERE id IN (:idList)")
    List<Commodity> findByUsernames(int[] idList);

    @Query("SELECT * FROM Commodity WHERE id IN (:id)")
    Commodity findByUsername(int id);

    @Delete
    void delete(Commodity commodity);
}
