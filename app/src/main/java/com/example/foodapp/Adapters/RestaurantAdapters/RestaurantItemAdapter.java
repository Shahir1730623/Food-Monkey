package com.example.foodapp.Adapters.RestaurantAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.Model.RestaurantItemModel;
import com.example.foodapp.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

public class RestaurantItemAdapter extends RecyclerView.Adapter<RestaurantItemAdapter.ViewHolder> {

    ArrayList<RestaurantItemModel> list;
    public RestaurantItemAdapter(ArrayList<RestaurantItemModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RestaurantItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantItemAdapter.ViewHolder holder, int position) {
        holder.foodImage.setImageResource(list.get(position).getImg());
        holder.foodName.setText(list.get(position).getFoodName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RoundedImageView foodImage;
        TextView foodName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage = itemView.findViewById(R.id.foodImage);
            foodName = itemView.findViewById(R.id.foodName);

        }
    }
}
