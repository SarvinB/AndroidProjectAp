package com.example.mainapplication.pages.home.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mainapplication.R;
import com.example.mainapplication.adapter.ProductListAdaptor;
import com.example.mainapplication.data.entities.Customer;
import com.example.mainapplication.data.entities.Seller;
import com.example.mainapplication.data.repository.Repository;
import com.example.mainapplication.data.repository.RepositoryCallback;
import com.example.mainapplication.data.repository.Result;
import com.example.mainapplication.objects.CommodityObject;
import com.example.mainapplication.objects.Person;
import com.example.mainapplication.pages.menu.Profile;
import com.example.mainapplication.pages.menu.Setting;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivityCustomer extends AppCompatActivity {
    TextView emailHeader;
    TextView usernameHeader;
    NavigationView navigationView;
    Menu menu;
    MenuItem setting;
    MenuItem profile;
    MenuItem signOut;
    MenuItem signInAsSeller;
    Toolbar toolbar;
    DrawerLayout drawerLayout;

    class DataBaseThread extends Thread
    {
        @Override
        public void run() {
            Customer customer = Repository.getInstance(HomeActivityCustomer.this).findByUsernameCustomer
                    (usernameHeader.getText().toString());
            Person person = Person.getPerson(customer);
            Seller seller = new Seller(person, customer.commodityNumber, customer.loginNumber);
            Repository.getInstance(HomeActivityCustomer.this).insertSeller(seller, new RepositoryCallback<Void>() {
                @Override
                public void onComplete(Result<Void> result) {
                    if (result instanceof Result.Success) {
                        System.out.println("ok");
                    } else if (result instanceof Result.Error) {
                        System.out.println(((Result.Error<Void>) result).exception.getLocalizedMessage());
                    }
                }
            });
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_customer);

        drawerLayout = findViewById(R.id.home_activity_customer);
        toolbar = findViewById(R.id.home_toolbar_customer);
        navigationView = findViewById(R.id.navigation_view_customer);
        View view = navigationView.getHeaderView(0);
        usernameHeader = view.findViewById(R.id.username_header);
        emailHeader = view.findViewById(R.id.email_header);
        menu = navigationView.getMenu();
        profile = menu.getItem(0);
        setting = menu.getItem(1);
        signInAsSeller = menu.getItem(2);
        signOut = menu.getItem(3);

        Intent data = getIntent();
        usernameHeader.setText(data.getStringExtra("username"));
        emailHeader.setText(data.getStringExtra("email"));

        setting.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.home_activity_customer, new Setting()).commit();
                return false;
            }
        });

        profile.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.home_activity_customer, new Profile()).commit();
                return false;
            }
        });


       signInAsSeller.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                DataBaseThread dataBaseThread = new DataBaseThread();
                dataBaseThread.start();

                Intent intent = new Intent(HomeActivityCustomer.this, HomeActivityCustomerAndSeller.class);
                intent.putExtra("username",usernameHeader.getText().toString());
                intent.putExtra("email",emailHeader.getText().toString());
                startActivity(intent);

                return false;
            }
        });

        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_customer);
        NavController navController = navHostFragment.getNavController();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation_customer);
        NavigationUI.setupWithNavController(bottomNav, navController);

        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(navController.getGraph())
                        .setOpenableLayout(drawerLayout)
                        .build();

        NavigationView navView = findViewById(R.id.navigation_view_customer);
        NavigationUI.setupWithNavController(navView, navController);

        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
    }

    public List<CommodityObject> makeFakeProducts() {
        List<CommodityObject> list = new ArrayList<>();

        CommodityObject obj1 = new CommodityObject();
        CommodityObject obj2 = new CommodityObject();
        CommodityObject obj3 = new CommodityObject();
        CommodityObject obj4 = new CommodityObject();
        CommodityObject obj5 = new CommodityObject();
        CommodityObject obj6 = new CommodityObject();
        CommodityObject obj7 = new CommodityObject();
        CommodityObject obj8 = new CommodityObject();

        obj1.setPrice(20000);
        obj1.setName("book1");
        obj1.setImage(String.valueOf(R.drawable.pngtreefull_color_mandala_element_5306633__1_));

        obj2.setPrice(30000);
        obj2.setName("book2");
        obj2.setImage(String.valueOf(R.drawable.pngtreefull_color_mandala_element_5306633__1_));

        obj3.setPrice(40000);
        obj3.setName("book3");
        obj3.setImage(String.valueOf(R.drawable.pngtreefull_color_mandala_element_5306633__1_));

        obj4.setPrice(2000);
        obj4.setName("book4");
        obj4.setImage(String.valueOf(R.drawable.pngtreefull_color_mandala_element_5306633__1_));

        obj5.setPrice(3000);
        obj5.setName("book5");
        obj5.setImage(String.valueOf(R.drawable.pngtreefull_color_mandala_element_5306633__1_));

        obj6.setPrice(50000);
        obj6.setName("book6");
        obj6.setImage(String.valueOf(R.drawable.pngtreefull_color_mandala_element_5306633__1_));

        obj7.setPrice(10000);
        obj7.setName("book7");
        obj7.setImage(String.valueOf(R.drawable.pngtreefull_color_mandala_element_5306633__1_));

        obj8.setPrice(20000);
        obj8.setName("book8");
        obj8.setImage(String.valueOf(R.drawable.pngtreefull_color_mandala_element_5306633__1_));


        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        list.add(obj4);
        list.add(obj5);
        list.add(obj6);
        list.add(obj7);
        list.add(obj8);

        return list;
    }
}

