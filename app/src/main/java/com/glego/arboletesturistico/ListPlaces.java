package com.glego.arboletesturistico;

import java.util.ArrayList;

/**
 * Created by HOME-I on 19/02/2017.
 */

public class ListPlaces {
    public String color;
    public String band;
    public int imageId;

    public ListPlaces(String color, String band, int imageId){
        this.color = color;
        this.band = band;
        this.imageId = imageId;
    }

    public static ArrayList<ListPlaces> defaultValues() {
        ArrayList<ListPlaces> users = new ArrayList<>();
        users.add(new ListPlaces("Marrón", "Primera banda", R.drawable.brown_color));
        users.add(new ListPlaces("Negro", "Segunda banda", R.drawable.black_color));
        users.add(new ListPlaces("Rojo", "Multiplicador", R.drawable.red_color));
        users.add(new ListPlaces("Dorado", "Tolerancia", R.drawable.golden_color));
        return users;
    }

    public static ArrayList<ListPlaces> firstBandValues(){
        ArrayList<ListPlaces> bands = new ArrayList<>();
        bands.add(new ListPlaces("Marrón", "1", R.drawable.brown_color));
        bands.add(new ListPlaces("Rojo", "2", R.drawable.red_color));
        bands.add(new ListPlaces("Naranja", "3", R.drawable.orange_color));
        bands.add(new ListPlaces("Amarillo", "4", R.drawable.yellow_color));
        bands.add(new ListPlaces("Verde", "5", R.drawable.green_color));
        bands.add(new ListPlaces("Azul", "6", R.drawable.blue_color));
        bands.add(new ListPlaces("Violeta", "7", R.drawable.violet_color));
        bands.add(new ListPlaces("Gris", "8", R.drawable.gray_color));
        bands.add(new ListPlaces("Blanco", "9", R.drawable.white_color));
        return bands;
    }

    public static ArrayList<ListPlaces> secondBandValues(){
        ArrayList<ListPlaces> bands = new ArrayList<>();
        bands.add(new ListPlaces("Negro", "0", R.drawable.black_color));
        bands.add(new ListPlaces("Marrón", "1", R.drawable.brown_color));
        bands.add(new ListPlaces("Rojo", "2", R.drawable.red_color));
        bands.add(new ListPlaces("Naranja", "3", R.drawable.orange_color));
        bands.add(new ListPlaces("Amarillo", "4", R.drawable.yellow_color));
        bands.add(new ListPlaces("Verde", "5", R.drawable.green_color));
        bands.add(new ListPlaces("Azul", "6", R.drawable.blue_color));
        bands.add(new ListPlaces("Violeta", "7", R.drawable.violet_color));
        bands.add(new ListPlaces("Gris", "8", R.drawable.gray_color));
        bands.add(new ListPlaces("Blanco", "9", R.drawable.white_color));
        return bands;
    }

    public static ArrayList<ListPlaces> multiplierBand(){
        ArrayList<ListPlaces> bands = new ArrayList<>();
        bands.add(new ListPlaces("Plateado", "x0.01", R.drawable.silver_color));
        bands.add(new ListPlaces("Dorado", "x0.1", R.drawable.golden_color));
        bands.add(new ListPlaces("Negro", "x1", R.drawable.black_color));
        bands.add(new ListPlaces("Marrón", "x10", R.drawable.brown_color));
        bands.add(new ListPlaces("Rojo", "x100", R.drawable.red_color));
        bands.add(new ListPlaces("Naranja", "x1000", R.drawable.orange_color));
        bands.add(new ListPlaces("Amarillo", "x10000", R.drawable.yellow_color));
        bands.add(new ListPlaces("Verde", "x100000", R.drawable.green_color));
        bands.add(new ListPlaces("Azul", "x1000000", R.drawable.blue_color));
        bands.add(new ListPlaces("Violeta", "x10000000", R.drawable.violet_color));
        return bands;
    }

    public static ArrayList<ListPlaces> toleranceBand(){
        ArrayList<ListPlaces> bands = new ArrayList<>();
        bands.add(new ListPlaces("Dorado", "±5%", R.drawable.golden_color));
        bands.add(new ListPlaces("Plateado", "±10%", R.drawable.silver_color));
        return bands;
    }
}
