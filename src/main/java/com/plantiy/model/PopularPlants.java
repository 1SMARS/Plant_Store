package com.plantiy.model;

import java.io.Serializable;

public class PopularPlants implements Serializable {
    String image;
    String name;
    String family;
    String type;
    String description;
    String price;

    public PopularPlants() {
    }

    public PopularPlants(String image, String name, String family, String type, String description, String price) {
        this.image = image;
        this.name = name;
        this.family = family;
        this.type = type;
        this.description = description;
        this.price = price;
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

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
