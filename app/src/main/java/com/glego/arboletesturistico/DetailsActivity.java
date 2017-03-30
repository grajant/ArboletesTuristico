package com.glego.arboletesturistico;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.style.TextAlignment;


public class DetailsActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private String option;
    private String[] description;
    private int position;

    private TextView titleTextV;
    private TextViewEx descriptionTextV;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle extras = getIntent().getExtras();
        option = extras.getString("option");
        position = extras.getInt("position");

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        titleTextV = (TextView) findViewById(R.id.item_title);
        descriptionTextV = (TextViewEx) findViewById(R.id.description);
        imageView = (ImageView) findViewById(R.id.image);

        switch (option){
            case "hotel":
                description = new String[3];
                description = getResources().getStringArray(R.array.hotels_description);
                displayData(R.string.hotel_mirador, R.string.hotel_riviera, R.string.hotel_retiro,
                        R.drawable.h_mirador_detail, R.drawable.h_riviera_detail, R.drawable.h_retiro_detail);
                toolbar.setTitle(R.string.hotel_title);
                break;
            case "restaurant":
                description = new String[3];
                description = getResources().getStringArray(R.array.restaurants_description);
                displayData(R.string.restaurant_mirador, R.string.restaurant_nautilus, R.string.restaurant_punto,
                        R.drawable.restaurant_mirador, R.drawable.restaurant_nautiluz, R.drawable.r_punto_detail);
                toolbar.setTitle(R.string.restaurant_title);
                break;
            case "tour":
                description = new String[3];
                description = getResources().getStringArray(R.array.attractions_description);
                displayData(R.string.attraction_volcano, R.string.attraction_church, R.string.attraction_beach,
                        R.drawable.volcano, R.drawable.church, R.drawable.beaches);
                toolbar.setTitle(R.string.tour_title);
                break;
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /*if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(colorPrimaryDark);
        }*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            Intent intent = new Intent(DetailsActivity.this, PlacesActivity.class);
            intent.putExtra("option", option);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void displayData(int item1, int item2, int item3, int imageId1, int imageId2, int imageId3){
        switch (position){
            case 0:
                titleTextV.setText(getString(item1));
                imageView.setImageResource(imageId1);
                descriptionTextV.setText(description[position]);
                break;
            case 1:
                titleTextV.setText(getString(item2));
                imageView.setImageResource(imageId2);
                descriptionTextV.setText(description[position]);
                break;
            case 2:
                titleTextV.setText(getString(item3));
                imageView.setImageResource(imageId3);
                descriptionTextV.setText(description[position]);
                break;
        }
    }
}
