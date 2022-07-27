package com.example.foodapp.Adapters.ShopAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.Model.CategoryModel;
import com.example.foodapp.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    ArrayList<CategoryModel> list;

    public CategoryAdapter(ArrayList<CategoryModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        holder.category_image.setImageResource(list.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RoundedImageView category_image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            category_image = itemView.findViewById(R.id.category_image);
        }
    }
}
