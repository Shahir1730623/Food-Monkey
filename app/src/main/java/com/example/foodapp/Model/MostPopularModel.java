package com.example.foodapp.Model;

public class MostPopularModel {
    int img;
    String foodName;

    public MostPopularModel(int image, String foodName) {
        this.img = image;
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
