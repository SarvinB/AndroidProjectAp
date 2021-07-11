package com.example.mainapplication.pages.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mainapplication.R;
import com.example.mainapplication.data.AppDatabase;
import com.example.mainapplication.data.entities.Commodity;
import com.example.mainapplication.data.entities.Customer;
import com.example.mainapplication.objects.CommodityObject;
import com.example.mainapplication.objects.Person;
import com.example.mainapplication.pages.home.HomeActivityCustomer;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}