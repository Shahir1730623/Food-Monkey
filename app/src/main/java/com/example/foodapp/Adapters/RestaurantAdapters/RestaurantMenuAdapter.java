package com.example.foodapp.Adapters.RestaurantAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.Model.RestaurantMenuModel;
import com.example.foodapp.R;

import java.util.ArrayList;

public class RestaurantMenuAdapter extends RecyclerView.Adapter<RestaurantMenuAdapter.Viewholder> {

    ArrayList<RestaurantMenuModel> list;

    public RestaurantMenuAdapter(ArrayList<RestaurantMenuModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RestaurantMenuAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_menu_item,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantMenuAdapter.Viewholder holder, int position) {
        holder.textView.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView textView;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.menuTitle);
        }
    }
}
