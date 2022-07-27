package com.example.foodapp.Customer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.foodapp.Customer.Restaurant.RestaurantHomePage;
import com.example.foodapp.Customer.Shop.CustomerShop;
import com.example.foodapp.R;
import com.google.android.material.navigation.NavigationView;

public class CustomerDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Menu Hooks
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        menuIcon = findViewById(R.id.menuIcon);

        navigationDrawer();

    }

    private void navigationDrawer() {
        navigationView.bringToFront(); //To interract with the navigationView
        navigationView.setNavigationItemSelectedListener(this); //Enables us to click the navigation items

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else
                    drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    public void GoToFoodDeliveryActivity(View view) {
        Intent intent = new Intent(this, RestaurantHomePage.class);
        startActivity(intent);
    }

    public void GoToShopActivity(View view) {
        Intent intent = new Intent(this, CustomerShop.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else {
            super.onBackPressed();
        }
    }
}