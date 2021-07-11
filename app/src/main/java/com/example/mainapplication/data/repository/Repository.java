package com.example.mainapplication.data.repository;

import android.content.Context;

import com.example.mainapplication.application.MyApplication;
import com.example.mainapplication.data.entities.Admin;
import com.example.mainapplication.data.entities.Commodity;
import com.example.mainapplication.data.entities.Customer;
import com.example.mainapplication.data.entities.Seller;

import java.util.List;

public class Repository
{
    private static Repository repository;
    private LocalDataSource localDataSource;
    private RemoteDataSource remoteDataSource;

    private Repository(Context context)
    {
        localDataSource = new LocalDataSource(context);
        remoteDataSource = new RemoteDataSource();

    }

    public static Repository getInstance(Context context) {
        if(repository == null)
            repository = new Repository(context);
        return repository;
    }

    public void getAllCustomers(RepositoryCallback<List<Customer>> callback)
    {
        MyApplication.executorService.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    List<Customer> customers = localDataSource.getAllCustomers();
                    callback.onComplete(new Result.Success<>(customers));
                }

                catch (Exception e)
                {
                    callback.onComplete(new Result.Error<>(e));
                }
            }
        });
    }

    public void insertCustomer(Customer customer, RepositoryCallback<Void> callback)
    {
        MyApplication.executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    localDataSource.insertCustomer(customer);
                    callback.onComplete(new Result.Success<>(null));
                }
                catch (Exception e)
                {
                    callback.onComplete(new Result.Error<>(e));
                }

            }
        });
    }

    public void deleteCustomer(Customer customer)
    {
        localDataSource.deleteCustomer(customer);
    }

    public List<Customer> findByUsernameCustomer(String[] usernameList)
    {
        return localDataSource.findByUsernameCustomer(usernameList);
    }

    public void insertAdmin(Admin admin, RepositoryCallback<Void> callback)
    {
        MyApplication.executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    localDataSource.insertAdmin(admin);
                    callback.onComplete(new Result.Success<>(null));
                }
                catch (Exception e)
                {
                    callback.onComplete(new Result.Error<>(e));
                }

            }
        });
    }

    public void deleteAdmin(Admin admin)
    {
        localDataSource.deleteAdmin(admin);
    }

    public void getAllAdmins(RepositoryCallback<List<Admin>> callback)
    {
        MyApplication.executorService.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    List<Admin> admins = localDataSource.getAllAdmins();
                    callback.onComplete(new Result.Success<>(admins));
                }
                catch (Exception e)
                {
                    callback.onComplete(new Result.Error<>(e));
                }
            }
        });
    }

    public void insertSeller(Seller seller, RepositoryCallback<Void> callback)
    {
        MyApplication.executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    localDataSource.insertSeller(seller);
                    callback.onComplete(new Result.Success<>(null));
                }
                catch (Exception e)
                {
                    callback.onComplete(new Result.Error<>(e));
                }

            }
        });
    }

    public void getAllSellers(RepositoryCallback<List<Seller>> callback)
    {
        MyApplication.executorService.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    List<Seller> sellers = localDataSource.getAllSellers();
                    callback.onComplete(new Result.Success<>(sellers));
                }
                catch (Exception e)
                {
                    callback.onComplete(new Result.Error<>(e));
                }
            }
        });
    }

    public void deleteSeller(Seller seller)
    {
        localDataSource.deleteSeller(seller);
    }

    public List<Seller> findByUsernameSeller(String[] usernameList)
    {
        return localDataSource.findByUsernameSeller(usernameList);
    }

    public List<Commodity> getAllCommodities()
    {
        return localDataSource.getAllCommodities();
    }

    public void insertCommodity(Commodity commodity)
    {
        localDataSource.insertCommodity(commodity);
    }

    public void deleteCommodity(Commodity commodity)
    {
        localDataSource.deleteCommodity(commodity);
    }

    public List<Commodity> findByIdCommodity(int[] idList)
    {
        return localDataSource.findByIdCommodity(idList);
    }
}
