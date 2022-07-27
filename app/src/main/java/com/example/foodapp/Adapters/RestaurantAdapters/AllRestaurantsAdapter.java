package com.example.foodapp.Adapters.RestaurantAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.Model.AllRestaurantsModel;
import com.example.foodapp.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

public class AllRestaurantsAdapter extends RecyclerView.Adapter<AllRestaurantsAdapter.ViewHolder> {

    ArrayList<AllRestaurantsModel> list;
    public AllRestaurantsAdapter(ArrayList<AllRestaurantsModel> list) {   // Constructor
        this.list = list;
    }

    @NonNull
    @Override
    public AllRestaurantsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_restaurants_item,parent,false);
        return new AllRestaurantsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllRestaurantsAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RoundedImageView restaurantImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            restaurantImage = itemView.findViewById(R.id.restaurantImage);
        }
    }
}
