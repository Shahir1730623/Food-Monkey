package com.example.foodapp.Model;

public class AllRestaurantsModel {
    String name,type,imgUrl;
    int deliveryCharge,deliveryTime,discount,orders,totalRatingValue,rating;

    public AllRestaurantsModel(String name, String type, String imgUrl, int deliveryCharge, int deliveryTime, int discount, int orders, int totalRatingValue, int rating) {
        this.name = name;
        this.type = type;
        this.deliveryCharge = deliveryCharge;
        this.deliveryTime = deliveryTime;
        this.discount = discount;
        this.imgUrl = imgUrl;
        this.orders = orders;
        this.totalRatingValue = totalRatingValue;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(int deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public int getTotalRatingValue() {
        return totalRatingValue;
    }

    public void setTotalRatingValue(int totalRatingValue) {
        this.totalRatingValue = totalRatingValue;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
