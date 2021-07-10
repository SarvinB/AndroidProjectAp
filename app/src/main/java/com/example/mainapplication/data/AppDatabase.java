package com.example.mainapplication.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.mainapplication.data.dao.AdminDao;
import com.example.mainapplication.data.dao.CommodityDao;
import com.example.mainapplication.data.dao.CustomerDao;
import com.example.mainapplication.data.dao.SellerDao;
import com.example.mainapplication.data.entities.Admin;
import com.example.mainapplication.data.entities.Commodity;
import com.example.mainapplication.data.entities.Customer;
import com.example.mainapplication.data.entities.Seller;
import com.example.mainapplication.data.entities.User;


@Database(entities = {User.class, Admin.class, Seller.class, Customer.class, Commodity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase
{
    public abstract AdminDao adminDao();
    public abstract SellerDao sellerDao();
    public abstract CommodityDao commodityDao();
    public abstract CustomerDao customerDao();

}
