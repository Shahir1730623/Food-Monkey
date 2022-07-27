package com.example.foodapp.Model;

public class RestaurantItemModel {
    int img;
    String foodName;

    public RestaurantItemModel(int img, String foodName) {
        this.img = img;
        this.foodName = foodName;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
