package com.example.foodapp.Adapters.ShopAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.Model.ShopProductModel;
import com.example.foodapp.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

public class ShopProductAdapter extends RecyclerView.Adapter<ShopProductAdapter.ViewHolder> {

    ArrayList<ShopProductModel> list;
    public ShopProductAdapter(ArrayList<ShopProductModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemImage.setImageResource(list.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RoundedImageView itemImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
        }
    }
}
