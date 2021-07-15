package com.example.mainapplication.data.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.example.mainapplication.objects.Person;

@Entity
public class Seller extends User
{

    public Seller()
    {

    }
    public Seller(Person person, int commodityNumber, int loginNumber)
    {
        super(person);
        this.commodityNumber = commodityNumber;
        this.loginNumber = loginNumber;
    }

    @ColumnInfo(name = "commodity_number")
    public int commodityNumber;

    @ColumnInfo(name = "login_number")
    public int loginNumber;

}
