package com.example.foodapp.Customer.Restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.foodapp.Adapters.RestaurantAdapters.AllRestaurantsAdapter;
import com.example.foodapp.Adapters.RestaurantAdapters.OffersAdapter;
import com.example.foodapp.Adapters.RestaurantAdapters.ExclusiveRestaurantAdapter;
import com.example.foodapp.Customer.CustomerDashboard;
import com.example.foodapp.Model.AllRestaurantsModel;
import com.example.foodapp.Model.OffersModel;
import com.example.foodapp.Model.ExclusiveRestaurantModel;
import com.example.foodapp.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class RestaurantHomePage extends AppCompatActivity {

    ArrayList<OffersModel> offersList;
    //ArrayList<ExclusiveRestaurantModel> exclusiveRestaurantsList;
    //ArrayList<ExclusiveRestaurantModel> recommendedRestaurantsList;
    //ArrayList<AllRestaurantsModel> allRestaurantsList;

    RecyclerView offersRecyclerView;
    RecyclerView exclusivesRecyclerView;
    RecyclerView recommendedRecyclerView;
    RecyclerView allRestaurantsRecyclerView;

    OffersAdapter offersAdapter;
    ExclusiveRestaurantAdapter exclusiveRestaurantAdapter;
    AllRestaurantsAdapter allRestaurantsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_homepage);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Query query = FirebaseDatabase.getInstance().getReference().child("Restaurants").child("Exclusives");

        FirebaseRecyclerOptions<AllRestaurantsModel> options =
                new FirebaseRecyclerOptions.Builder<AllRestaurantsModel>()
                        .setQuery(query, AllRestaurantsModel.class)
                        .build();


        getOffers();
        getExclusiveRestaurants(options);
        getRecommendedRestaurants(options);
        //getAllRestaurants();

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


    private void getOffers() {
        offersRecyclerView = findViewById(R.id.offersRecyclerView);
        offersRecyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        offersRecyclerView.setHasFixedSize(true);

        offersList = new ArrayList<>();
        offersList.add(new OffersModel(R.drawable.restaurant_offer1));
        offersList.add(new OffersModel(R.drawable.restaurant_offer1));
        offersList.add(new OffersModel(R.drawable.restaurant_offer2));
        offersList.add(new OffersModel(R.drawable.restaurant_offer2));

        offersAdapter = new OffersAdapter(offersList);
        offersRecyclerView.setAdapter(offersAdapter);
    }

    private void getExclusiveRestaurants(FirebaseRecyclerOptions<AllRestaurantsModel> options) {
        exclusivesRecyclerView = findViewById(R.id.exclusivesRecyclerView);
        exclusivesRecyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        exclusivesRecyclerView.setHasFixedSize(true);

        exclusiveRestaurantAdapter = new ExclusiveRestaurantAdapter(options);
        exclusivesRecyclerView.setAdapter(exclusiveRestaurantAdapter);

    }

    private void getRecommendedRestaurants(FirebaseRecyclerOptions<AllRestaurantsModel> options) {
        recommendedRecyclerView = findViewById(R.id.recommendedRecyclerView);
        recommendedRecyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        exclusivesRecyclerView.setHasFixedSize(true);

        exclusiveRestaurantAdapter = new ExclusiveRestaurantAdapter(options);
        recommendedRecyclerView.setAdapter(exclusiveRestaurantAdapter);

    }


   /* private void getAllRestaurants(FirebaseRecyclerOptions<AllRestaurantsModel> options) {
        allRestaurantsRecyclerView = findViewById(R.id.allRestaurantsRecyclerView);
        allRestaurantsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        allRestaurantsRecyclerView.setHasFixedSize(true);


        allRestaurantsAdapter = new AllRestaurantsAdapter(allRestaurantsList);
        allRestaurantsRecyclerView.setAdapter(allRestaurantsAdapter);
    }*/

    @Override
    protected void onStart() {
        super.onStart();
        exclusiveRestaurantAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        exclusiveRestaurantAdapter.stopListening();
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }

}