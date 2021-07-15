package com.example.mainapplication.data.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.mainapplication.objects.CommodityObject;

@Entity
public class Commodity
{
    public Commodity()
    {

    }

    public Commodity(CommodityObject commodity)
    {
        phoneNumber = commodity.getPhoneNumber();
        customer = commodity.getCustomer();
        seller = commodity.getSeller();
        price = commodity.getPrice();
        category = commodity.getCategory();
        image = commodity.getImage();
        name = commodity.getName();
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "price")
    public int price;

    @ColumnInfo(name = "category")
    public String category;

    @ColumnInfo(name = "image")
    public String image;

    @ColumnInfo(name = "customer")
    public String customer;

    @ColumnInfo(name = "seller")
    public String seller;

    @ColumnInfo(name = "phoneNumber")
    public String phoneNumber;

}
