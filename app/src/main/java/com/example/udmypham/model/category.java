package com.example.udmypham.model;

public class category {
    public  int ID;
    public String Tenloaisp;
    public  String Image;

    public  category(int id, String tenloaisp, String image){
        ID= id;
        Tenloaisp = tenloaisp;
        Image = image;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenloaisp() {
        return Tenloaisp;
    }

    public void setTenloaisp(String tenloaisp) {
        Tenloaisp = tenloaisp;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
