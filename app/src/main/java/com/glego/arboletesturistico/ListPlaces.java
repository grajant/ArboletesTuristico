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
        users.add(new ListPlaces(context.getString(R.string.hotel_mirador), context.getString(R.string.h_mirador_short_info),context.getString(R.string.h_mirador_short_detail), R.drawable.logo_h_mirador));
        users.add(new ListPlaces(context.getString(R.string.hotel_riviera), context.getString(R.string.h_riviera_short_info),context.getString(R.string.h_riviera_short_detail) , R.drawable.logo_h_riviera));
        users.add(new ListPlaces(context.getString(R.string.hotel_retiro), context.getString(R.string.h_retiro_short_info),context.getString(R.string.h_retiro_short_detail), R.drawable.hotel_retiro));
        return users;
    }

    public static ArrayList<ListPlaces> restaurantsValues(Context context) {
        ArrayList<ListPlaces> users = new ArrayList<>();
        users.add(new ListPlaces(context.getString(R.string.restaurant_mirador), context.getString(R.string.r_mirador_short_info),context.getString(R.string.r_mirador_short_detail), R.drawable.restaurant_mirador));
        users.add(new ListPlaces(context.getString(R.string.restaurant_nautilus), context.getString(R.string.r_nautilus_short_info),context.getString(R.string.r_nautilus_short_detail) , R.drawable.logo_nautilus));
        users.add(new ListPlaces(context.getString(R.string.restaurant_punto), context.getString(R.string.r_punto_short_info),context.getString(R.string.r_punto_short_detail), R.drawable.logo_punto_sabor));
        return users;
    }

    public static ArrayList<ListPlaces> attractionsValues(Context context) {
        ArrayList<ListPlaces> users = new ArrayList<>();
        users.add(new ListPlaces(context.getString(R.string.attraction_volcano), context.getString(R.string.a_volcano_short_info),context.getString(R.string.a_volcano_short_detail), R.drawable.volcano));
        users.add(new ListPlaces(context.getString(R.string.attraction_church), context.getString(R.string.a_church_short_info),context.getString(R.string.a_church_short_detail), R.drawable.church));
        users.add(new ListPlaces(context.getString(R.string.attraction_beach), context.getString(R.string.a_beach_short_info),context.getString(R.string.a_beach_short_detail), R.drawable.beaches));
        return users;
    }

}
