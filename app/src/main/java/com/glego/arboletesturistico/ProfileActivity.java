package com.glego.arboletesturistico;

import android.content.Intent;
import android.support.design.widget.NavigationView;
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
        setContentView(R.layout.activity_profile);

        usernameTextView = (TextView) findViewById(R.id.username);
        emailTextView = (TextView) findViewById(R.id.email);

        extras = getIntent().getExtras();

        usernameTextView.setText(extras.getString("username"));
        emailTextView.setText(extras.getString("email"));

        MenuItem item = navigationView.getMenu().getItem(1);
        item.setChecked(true);
    }

    @Override
    protected String toolbarTitle() {
        return getString(R.string.profile);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }*/

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.main_page_menu:
                intent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.logout_menu:
                intent = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }*/
}
