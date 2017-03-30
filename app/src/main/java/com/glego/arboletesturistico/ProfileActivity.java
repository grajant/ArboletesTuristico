package com.glego.arboletesturistico;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class ProfileActivity extends DrawerActivity{
    private TextView usernameTextView;
    private TextView emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        extras = getIntent().getExtras();
        setContentView(R.layout.activity_profile);

        usernameTextView = (TextView) findViewById(R.id.username);
        emailTextView = (TextView) findViewById(R.id.email);



        usernameTextView.setText(extras.getString("username"));
        emailTextView.setText(extras.getString("email"));

        MenuItem item = navigationView.getMenu().getItem(1);
        item.setChecked(true);
    }

    @Override
    protected String toolbarTitle() {
        return getString(R.string.profile);
    }

    @Override
    public void onBackPressed() {
        if (fullLayout.isDrawerOpen(GravityCompat.START)) {
            fullLayout.closeDrawer(GravityCompat.START);
        } else {
            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
            intent.putExtra("username", extras.getString("username"));
            intent.putExtra("email", extras.getString("email"));
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
