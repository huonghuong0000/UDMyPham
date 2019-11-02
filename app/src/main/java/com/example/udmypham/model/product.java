package com.example.udmypham.model;

public class product {
    public int ID;
    public int id_category;
    public String namesp;
    public Integer pricesp;
    public String imagesp;
    public String detailsp;

    public product(int ID, int id_category, String namesp, Integer pricesp, String imagesp, String detailsp) {
        this.ID = ID;
        this.id_category = id_category;
        this.namesp = namesp;
        this.pricesp = pricesp;
        this.imagesp = imagesp;
        this.detailsp = detailsp;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getNamesp() {
        return namesp;
    }

    public void setNamesp(String namesp) {
        this.namesp = namesp;
    }

    public Integer getPricesp() {
        return pricesp;
    }

    public void setPricesp(Integer pricesp) {
        this.pricesp = pricesp;
    }

    public String getImagesp() {
        return imagesp;
    }

    public void setImagesp(String imagesp) {
        this.imagesp = imagesp;
    }

    public String getDetailsp() {
        return detailsp;
    }

    public void setDetailsp(String detailsp) {
        this.detailsp = detailsp;
    }
}
