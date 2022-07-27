package com.example.foodapp.Customer.Restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.foodapp.Adapters.RestaurantAdapters.MostPopularAdapter;
import com.example.foodapp.Adapters.RestaurantAdapters.RestaurantItemAdapter;
import com.example.foodapp.Adapters.RestaurantAdapters.RestaurantMenuAdapter;
import com.example.foodapp.Customer.CustomerDashboard;
import com.example.foodapp.Model.MostPopularModel;
import com.example.foodapp.Model.RestaurantItemModel;
import com.example.foodapp.Model.RestaurantMenuModel;
import com.example.foodapp.R;

import java.util.ArrayList;

public class RestaurantSinglePage extends AppCompatActivity {

    RecyclerView menuRecyclerView;
    ArrayList<RestaurantMenuModel> menuList;
    RestaurantMenuAdapter restaurantMenuAdapter;

    RecyclerView mostPopularRecyclerView;
    ArrayList<MostPopularModel> mostPopularList;
    MostPopularAdapter mostPopularAdapter;

    RecyclerView lowBudgetRecyclerView;
    ArrayList<RestaurantItemModel> lowBudgetList;
    RestaurantItemAdapter restaurantItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_single_page);

        getRestaurantMenus();
        getPopularItems();
        getRestaurantItems();
    }

    private void getRestaurantItems() {
        lowBudgetRecyclerView = findViewById(R.id.LowBudgetRecyclerView);
        lowBudgetRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        lowBudgetRecyclerView.setHasFixedSize(true);

        lowBudgetList = new ArrayList<>();
        lowBudgetList.add(new RestaurantItemModel(R.drawable.fooditem_1,"Chicken Cheese Pizza"));
        lowBudgetList.add(new RestaurantItemModel(R.drawable.fooditem_1,"Parmesan Chicken Salad"));
        lowBudgetList.add(new RestaurantItemModel(R.drawable.fooditem_1,"Beef Cheese Burger"));
        lowBudgetList.add(new RestaurantItemModel(R.drawable.fooditem_1,"Chicken Cheese Burger"));
        lowBudgetList.add(new RestaurantItemModel(R.drawable.restaurant_2,"Crispy Fried Chicken Bucket"));
        lowBudgetList.add(new RestaurantItemModel(R.drawable.restaurant_1,"Deluxe Pizza Combo"));

        restaurantItemAdapter = new RestaurantItemAdapter(lowBudgetList);
        lowBudgetRecyclerView.setAdapter(restaurantItemAdapter);
    }


    private void getRestaurantMenus() {
        menuRecyclerView = findViewById(R.id.menuRecyclerView);
        menuRecyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        menuRecyclerView.setHasFixedSize(true);

        menuList = new ArrayList<>();
        menuList.add(new RestaurantMenuModel("Popular"));
        menuList.add(new RestaurantMenuModel("Low budget"));
        menuList.add(new RestaurantMenuModel("Discounted Items"));
        menuList.add(new RestaurantMenuModel("Extras"));
        menuList.add(new RestaurantMenuModel("Sides"));
        menuList.add(new RestaurantMenuModel("Desserts"));
        menuList.add(new RestaurantMenuModel("Drinks"));

        restaurantMenuAdapter = new RestaurantMenuAdapter(menuList);
        menuRecyclerView.setAdapter(restaurantMenuAdapter);

    }

    private void getPopularItems() {
        mostPopularRecyclerView = findViewById(R.id.mostPopularRecyclerView);
        mostPopularRecyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        mostPopularRecyclerView.setHasFixedSize(true);

        mostPopularList = new ArrayList<>();
        mostPopularList.add(new MostPopularModel(R.drawable.fooditem_1,"Chicken Cheese Pizza"));
        mostPopularList.add(new MostPopularModel(R.drawable.fooditem_1,"Parmesan Chicken Salad"));
        mostPopularList.add(new MostPopularModel(R.drawable.fooditem_1,"Beef Cheese Burger"));
        mostPopularList.add(new MostPopularModel(R.drawable.fooditem_1,"Chicken Cheese Burger"));

        mostPopularAdapter = new MostPopularAdapter(mostPopularList);
        mostPopularRecyclerView.setAdapter(mostPopularAdapter);
    }

    public void ReturnToHomePage(View view) {
        Intent intent = new Intent(getApplicationContext(), RestaurantHomePage.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
}