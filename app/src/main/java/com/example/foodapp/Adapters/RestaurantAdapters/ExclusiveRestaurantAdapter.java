package com.example.foodapp.Adapters.RestaurantAdapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodapp.Customer.Restaurant.RestaurantSinglePage;
import com.example.foodapp.Model.AllRestaurantsModel;
import com.example.foodapp.Model.ExclusiveRestaurantModel;
import com.example.foodapp.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

public class ExclusiveRestaurantAdapter extends FirebaseRecyclerAdapter<AllRestaurantsModel,ExclusiveRestaurantAdapter.ViewHolder> {

    public ExclusiveRestaurantAdapter(@NonNull FirebaseRecyclerOptions<AllRestaurantsModel> options) {
        super(options);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.special_restaurant_item,parent,false); //Generating View Object
        return new ExclusiveRestaurantAdapter.ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull AllRestaurantsModel model) {
        holder.restaurantName.setText(model.getName());
        holder.restaurantFoodType.setText(model.getType());
        holder.restaurantDeliveryTime.setText(model.getDeliveryTime());
        holder.deliveryCharge.setText(model.getDeliveryCharge());
        holder.restaurantDiscount.setText(model.getDiscount());
        holder.restaurantOrders.setText(model.getOrders());
        holder.restaurantRating.setText(model.getRating());
        Glide.with(holder.restaurantImage.getContext()).load(model.getImgUrl()).into(holder.restaurantImage);

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        RoundedImageView restaurantImage;
        TextView restaurantDeliveryTime,restaurantDiscount,restaurantName,restaurantOrders,restaurantRating,
                restaurantFoodType,deliveryCharge;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            restaurantImage = itemView.findViewById(R.id.restaurantImage);
            restaurantDeliveryTime = itemView.findViewById(R.id.restaurantDeliveryTime);
            restaurantDiscount = itemView.findViewById(R.id.restaurantDiscount);
            restaurantName = itemView.findViewById(R.id.restaurantName);
            restaurantOrders = itemView.findViewById(R.id.restaurantOrders);
            restaurantRating = itemView.findViewById(R.id.restaurantRating);
            restaurantFoodType = itemView.findViewById(R.id.restaurantFoodType);
            deliveryCharge = itemView.findViewById(R.id.deliveryCharge);
        }
    }


}
