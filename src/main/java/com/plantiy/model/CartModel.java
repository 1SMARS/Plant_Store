package com.plantiy.model;

public class CartModel {
    String plantName;
    String plantImage;
    String plantPrice;
    String totalQuantity;
    int totalPrice;

    public CartModel() {
    }

    public CartModel(String plantName, String plantImage, String plantPrice, String totalQuantity, int totalPrice) {
        this.plantName = plantName;
        this.plantImage = plantImage;
        this.plantPrice = plantPrice;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantImage() {
        return plantImage;
    }

    public void setPlantImage(String plantImage) {
        this.plantImage = plantImage;
    }

    public String getPlantPrice() {
        return plantPrice;
    }

    public void setPlantPrice(String plantPrice) {
        this.plantPrice = plantPrice;
    }

    public String getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(String totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
