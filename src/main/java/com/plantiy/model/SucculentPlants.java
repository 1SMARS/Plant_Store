package com.plantiy.model;

import java.io.Serializable;

public class SucculentPlants implements Serializable {
    String image;
    String name;
    String family;
    String description;
    String price;
    String type;

    public SucculentPlants() {
    }

    public SucculentPlants(String name, String description, String family, String price, String image, String type) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
        this.family = family;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
