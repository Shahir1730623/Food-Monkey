package com.example.foodapp.Adapters.RestaurantAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.Model.OffersModel;
import com.example.foodapp.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.ViewHolder> {

    ArrayList<OffersModel> list;
    public OffersAdapter(ArrayList<OffersModel> list) {   // Constructor
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offer_item,parent,false); //Generating View Object
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.roundedImageView.setImageResource(list.get(position).getImg());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    // Hold the childView
    public class ViewHolder extends RecyclerView.ViewHolder {

        RoundedImageView roundedImageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            roundedImageView = itemView.findViewById(R.id.offer_image);
        }
    }
}
