package com.example.mainapplication.pages.commodity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.example.mainapplication.R;
import com.example.mainapplication.data.entities.Commodity;
import com.example.mainapplication.data.repository.Repository;
import com.example.mainapplication.objects.CommodityObject;
import com.example.mainapplication.pages.home.activities.HomeActivityAdminAndCustomer;
import com.example.mainapplication.pages.home.activities.HomeActivityAdminAndSeller;
import com.example.mainapplication.pages.home.activities.HomeActivityAll;
import com.example.mainapplication.pages.home.activities.HomeActivityCustomer;
import com.example.mainapplication.pages.home.activities.HomeActivityCustomerAndSeller;
import com.example.mainapplication.pages.home.activities.HomeActivitySeller;

import org.jetbrains.annotations.NotNull;

public class AddCommodity extends Fragment
{
    EditText name;
    EditText price;
    EditText phoneNumber;
    AppCompatButton enter;
    Spinner categoryList;

    String[] category = {"Estate", "Cars", "Electrical appliances", "Home appliances", "Services"
            , "Personal items", "Entertainment", "Business", "Recruitment and employment"};

    class DataBaseThread extends Thread
    {
        @Override
        public void run() {

            CommodityObject commodityObject = new CommodityObject();
            commodityObject.setPhoneNumber(phoneNumber.getText().toString());
            String str = categoryList.getSelectedItem().toString();
            commodityObject.setCategory(str);
            commodityObject.setName(name.getText().toString());
            commodityObject.setPrice(Integer.parseInt(price.getText().toString()));
            commodityObject.setSeller(getArguments().getString("sellerUserName"));

            Commodity commodity = new Commodity(commodityObject);

            Repository.getInstance(getContext()).insertCommodity(commodity);

        }
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.add_commodity_fragment, container, false);

        name = view.findViewById(R.id.Name_commodity);
        price = view.findViewById(R.id.Price_add_commodity);
        enter = view.findViewById(R.id.EnterB_add_Commodity);
        phoneNumber = view.findViewById(R.id.Phone_add_commodity);
        categoryList = view.findViewById(R.id.add_commodityS);


        ArrayAdapter aa = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, category);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categoryList.setAdapter(aa);


        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DataBaseThread dataBaseThread = new DataBaseThread();
                dataBaseThread.start();

                Intent intent = new Intent(getActivity(), findClass(getArguments().getString("origin")));
                startActivity(intent);
            }
        });

        return view;
    }

    private Class findClass(String name)
    {
        switch (name)
        {
            case "CustomerAndSeller":
            {
                return HomeActivityCustomerAndSeller.class;
            }
            case "Customer":
            {
                return HomeActivityCustomer.class;
            }
            case "Seller":
            {
                return HomeActivitySeller.class;
            }

            case "AdminAndSeller":
            {
                return HomeActivityAdminAndSeller.class;
            }

            case "AdminAndCustomer":
            {
                return HomeActivityAdminAndCustomer.class;
            }

            case "All":
            {
                return HomeActivityAll.class;
            }
        }

        return null;
    }
}
