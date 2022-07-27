package com.example.foodapp.Customer.Shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.foodapp.Adapters.ShopAdapters.CategoryAdapter;
import com.example.foodapp.Adapters.ShopAdapters.ShopProductAdapter;
import com.example.foodapp.Adapters.SliderAdapter;
import com.example.foodapp.Customer.CustomerDashboard;
import com.example.foodapp.Model.CategoryModel;
import com.example.foodapp.Model.ShopProductModel;
import com.example.foodapp.Model.SliderData;
import com.example.foodapp.R;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;


public class CustomerShop extends AppCompatActivity {

    SliderView sliderView;
    ArrayList<SliderData> sliderDataArrayList;
    SliderAdapter sliderAdapter;

    RecyclerView categoryRecyclerView;
    ArrayList<CategoryModel> categoryList;
    CategoryAdapter categoryAdapter;

    RecyclerView snacksRecyclerView;
    ArrayList<ShopProductModel> snacksList;
    ShopProductAdapter shopProductAdapter;

    RecyclerView teaRecyclerView;
    ArrayList<ShopProductModel> teaCoffeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_homepage);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getCategory();
        getSnacks();
        getTeaCoffee();
        getSliderData();

        View includeView = findViewById(R.id.include);
        ImageView backBtn = includeView.findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CustomerDashboard.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
    }

    private void getSnacks() {
        snacksRecyclerView = findViewById(R.id.snacksRecyclerView);
        snacksRecyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        snacksRecyclerView.setHasFixedSize(true);

        snacksList = new ArrayList<>();
        snacksList.add(new ShopProductModel(R.drawable.lays1));
        snacksList.add(new ShopProductModel(R.drawable.lays2));
        snacksList.add(new ShopProductModel(R.drawable.lays3));
        snacksList.add(new ShopProductModel(R.drawable.lays4));

        shopProductAdapter = new ShopProductAdapter(snacksList);
        snacksRecyclerView.setAdapter(shopProductAdapter);

    }

    private void getTeaCoffee(){
        teaRecyclerView = findViewById(R.id.teaRecyclerView);
        teaRecyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        teaRecyclerView.setHasFixedSize(true);

        teaCoffeeList = new ArrayList<>();
        teaCoffeeList.add(new ShopProductModel(R.drawable.nes1));
        teaCoffeeList.add(new ShopProductModel(R.drawable.nes2));
        teaCoffeeList.add(new ShopProductModel(R.drawable.nes3));
        teaCoffeeList.add(new ShopProductModel(R.drawable.nes4));

        shopProductAdapter = new ShopProductAdapter(teaCoffeeList);
        teaRecyclerView.setAdapter(shopProductAdapter);
    }

    private void getCategory() {

        categoryRecyclerView = findViewById(R.id.categoryRecyclerView);
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        categoryRecyclerView.setHasFixedSize(true);

        categoryList = new ArrayList<>();
        categoryList.add(new CategoryModel(R.drawable.category_1));
        categoryList.add(new CategoryModel(R.drawable.category_2));
        categoryList.add(new CategoryModel(R.drawable.category_2));
        categoryList.add(new CategoryModel(R.drawable.category_1));
        categoryList.add(new CategoryModel(R.drawable.category_1));
        categoryList.add(new CategoryModel(R.drawable.category_2));

        categoryAdapter = new CategoryAdapter(categoryList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void getSliderData() {

        sliderView = findViewById(R.id.slider);
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // we are creating array list for storing our image urls.
        sliderDataArrayList = new ArrayList<>();
        sliderDataArrayList.add(new SliderData(R.drawable.slideimg_1));
        sliderDataArrayList.add(new SliderData(R.drawable.slideimg_2));
        sliderDataArrayList.add(new SliderData(R.drawable.slideimg_3));

        sliderAdapter = new SliderAdapter(this, sliderDataArrayList);
        sliderView.setSliderAdapter(sliderAdapter);

        // set scroll time in seconds and scrollable automatically.
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();

    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }


}