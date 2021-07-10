package com.example.mainapplication.data.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.example.mainapplication.objects.Person;

@Entity
public class Admin extends User
{
    public Admin()
    {

    }

    public Admin(Person person, int allCommodityNumber, int totalPrice, int allSellerNumber)
    {
        super(person);
        this.allCommodityNumber = allCommodityNumber;
        this.allSellerNumber = allSellerNumber;
        this.totalPrice = totalPrice;
    }

    @ColumnInfo(name = "all_commodity_number")
    public int allCommodityNumber;

    @ColumnInfo(name = "total_price")
    public int totalPrice;

    @ColumnInfo(name = "all_seller_number")
    public int allSellerNumber;
}
