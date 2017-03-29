package com.glego.arboletesturistico;

import android.content.Intent;
import android.os.Build;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private String option;
    private int position;

    private TextView titleTextV;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle extras = getIntent().getExtras();
        option = extras.getString("option");
        position = extras.getInt("position");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        titleTextV = (TextView) findViewById(R.id.item_title);
        imageView = (ImageView) findViewById(R.id.image);

        switch (option){
            case "hotel":
                displayData(R.string.hotel_mirador, R.string.hotel_retiro, R.string.hotel_riviera,
                        R.drawable.hotel_mirador, R.drawable.hotel_retiro, R.drawable.hotel_riviera);
                break;
            case "restaurant":
                displayData(R.string.restaurant_mirador, R.string.restaurant_nautilus, R.string.restaurant_punto,
                        R.drawable.restaurant_mirador, R.drawable.restaurant_nautiluz, R.drawable.restaurant_punto_sabor);
                break;
            case "tour":
                displayData(R.string.attraction_volcano, R.string.attraction_church, R.string.attraction_beach,
                        R.drawable.volcano, R.drawable.church, R.drawable.beaches);
                break;
        }

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
                imageView.setBackgroundResource(imageId1);
                break;
            case 1:
                titleTextV.setText(getString(item2));
                imageView.setBackgroundResource(imageId2);
                break;
            case 2:
                titleTextV.setText(getString(item3));
                imageView.setBackgroundResource(imageId3);
                break;
        }
    }
}
