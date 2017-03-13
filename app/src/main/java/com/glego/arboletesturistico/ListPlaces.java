package com.glego.arboletesturistico;

import java.util.ArrayList;

/**
 * Created by HOME-I on 19/02/2017.
 */

public class ListPlaces {
    private String title;
    private String detail;
    private String price;
    private int imageId;

    public ListPlaces(String _name, String _detail, String _price, int _imageId){
        this.title = _name;
        this.detail = _detail;
        this.price = _price;
        this.imageId = _imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

    public String getPrice() {
        return price;
    }

    public int getImageId() {
        return imageId;
    }

    public static ArrayList<ListPlaces> defaultValues() {
        ArrayList<ListPlaces> users = new ArrayList<>();
        users.add(new ListPlaces("HOTEL MIRADOR", "Primera banda","15.000", R.drawable.hotel_mirador));
        users.add(new ListPlaces("HOTEL RETIRO", "Segunda banda","15.000" , R.drawable.hotel_retiro));
        users.add(new ListPlaces("HOTEL RIVIERA", "Multiplicador","15.000", R.drawable.hotel_riviera));
        return users;
    }


}
