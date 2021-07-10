package com.example.mainapplication.data.repository;

import android.content.Context;

import androidx.room.Room;

import com.example.mainapplication.data.AppDatabase;
import com.example.mainapplication.data.entities.Admin;
import com.example.mainapplication.data.entities.Commodity;
import com.example.mainapplication.data.entities.Customer;
import com.example.mainapplication.data.entities.Seller;

import java.util.List;

public class LocalDataSource
{
    AppDatabase db;
    public LocalDataSource(Context context)
    {
        db = Room.databaseBuilder(context, AppDatabase.class, "MainApplication_database").build();
    }

    public List<Customer> getAllCustomers()
    {
        return db.customerDao().getAll();
    }

    public void insertCustomer(Customer customer)
    {
        db.customerDao().insertAll(customer);
    }

    public void deleteCustomer(Customer customer)
    {
        db.customerDao().delete(customer);
    }

    public List<Customer> findByUsernameCustomer(String[] usernameList)
    {
        return db.customerDao().findByUsername(usernameList);
    }

    public void insertAdmin(Admin admin)
    {
        db.adminDao().insertAll(admin);
    }

    public void deleteAdmin(Admin admin)
    {
        db.adminDao().delete(admin);
    }

    public List<Admin> getAllAdmins()
    {
        return db.adminDao().getAll();
    }

    public void insertSeller(Seller seller)
    {
        db.sellerDao().insertAll(seller);
    }

    public void deleteSeller(Seller seller)
    {
        db.sellerDao().delete(seller);
    }

    public List<Seller> findByUsernameSeller(String[] usernameList)
    {
        return db.sellerDao().findByUsername(usernameList);
    }

    public List<Commodity> getAllCommodities()
    {
        return db.commodityDao().getAll();
    }

    public void insertCommodity(Commodity commodity)
    {
        db.commodityDao().insert(commodity.name, commodity.price, commodity.category, commodity.image, commodity.customer, commodity.seller, commodity.admin);
    }

    public void deleteCommodity(Commodity commodity)
    {
        db.commodityDao().delete(commodity);
    }

    public List<Commodity> findByIdCommodity(int[] idList)
    {
        return db.commodityDao().findByUsername(idList);
    }

}
