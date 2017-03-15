package com.glego.arboletesturistico;

import android.content.Context;

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

    public static ArrayList<ListPlaces> hotelsValues(Context context) {
        ArrayList<ListPlaces> users = new ArrayList<>();
        users.add(new ListPlaces(context.getString(R.string.hotel_mirador), "Primera banda","15.000", R.drawable.hotel_mirador));
        users.add(new ListPlaces(context.getString(R.string.hotel_riviera), "Segunda banda","15.000" , R.drawable.hotel_retiro));
        users.add(new ListPlaces(context.getString(R.string.hotel_retiro), "Multiplicador","15.000", R.drawable.hotel_riviera));
        return users;
    }

    public static ArrayList<ListPlaces> restaurantsValues(Context context) {
        ArrayList<ListPlaces> users = new ArrayList<>();
        users.add(new ListPlaces(context.getString(R.string.restaurant_mirador), "Primera banda","15.000", R.drawable.restaurant_mirador));
        users.add(new ListPlaces(context.getString(R.string.restaurant_nautilus), "Segunda banda","15.000" , R.drawable.restaurant_nautiluz));
        users.add(new ListPlaces(context.getString(R.string.restaurant_punto), "Multiplicador","15.000", R.drawable.restaurant_punto_sabor));
        return users;
    }

    public static ArrayList<ListPlaces> attractionsValues(Context context) {
        ArrayList<ListPlaces> users = new ArrayList<>();
        users.add(new ListPlaces(context.getString(R.string.attraction_volcano), "Primera banda","15.000", R.drawable.volcano));
        users.add(new ListPlaces(context.getString(R.string.attraction_church), "Segunda banda","15.000" , R.drawable.church));
        users.add(new ListPlaces(context.getString(R.string.attraction_beach), "Multiplicador","15.000", R.drawable.beaches));
        return users;
    }

}
