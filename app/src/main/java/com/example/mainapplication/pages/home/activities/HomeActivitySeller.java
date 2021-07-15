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

import com.example.mainapplication.R;
import com.example.mainapplication.pages.menu.Profile;
import com.example.mainapplication.pages.menu.Setting;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HomeActivitySeller extends AppCompatActivity
{
    TextView emailHeader;
    TextView usernameHeader;
    NavigationView navigationView;
    Menu menu;
    MenuItem setting;
    MenuItem profile;
    Toolbar toolbar;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_seller);


        drawerLayout = findViewById(R.id.home_activity_seller);
        navigationView = findViewById(R.id.navigation_view_seller);
        View view = navigationView.getHeaderView(0);
        usernameHeader = view.findViewById(R.id.username_header);
        emailHeader = view.findViewById(R.id.email_header);
        menu = navigationView.getMenu();
        profile = menu.getItem(0);
        setting = menu.getItem(1);
        toolbar = findViewById(R.id.home_toolbar_seller);

        setting.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.home_activity_seller, new Setting()).commit();
                return false;
            }
        });

        profile.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.home_activity_seller, new Profile()).commit();
                return false;
            }
        });


        Intent data = getIntent();
        usernameHeader.setText(data.getStringExtra("username"));
        emailHeader.setText(data.getStringExtra("email"));


        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_seller);
        NavController navController = navHostFragment.getNavController();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation_seller);
        NavigationUI.setupWithNavController(bottomNav, navController);

        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(navController.getGraph())
                        .setOpenableLayout(drawerLayout)
                        .build();

        NavigationView navView = findViewById(R.id.navigation_view_seller);
        NavigationUI.setupWithNavController(navView, navController);

        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);

    }
}
