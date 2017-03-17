package com.glego.arboletesturistico;


import android.os.Bundle;
import android.view.MenuItem;


public class MainActivity extends DrawerActivity {

    //private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        extras = getIntent().getExtras();

        MenuItem item = navigationView.getMenu().getItem(0);
        item.setChecked(true);
    }

    @Override
    protected String toolbarTitle() {
        return getString(R.string.home);
    }
}
