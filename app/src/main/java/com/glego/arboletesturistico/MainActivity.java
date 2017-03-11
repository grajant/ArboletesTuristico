package com.glego.arboletesturistico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Interpolator;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        extras = getIntent().getExtras();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.menu_profile:
                intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra("username", extras.getString("username"));
                intent.putExtra("email", extras.getString("email"));
                startActivity(intent);
                finish();
                break;
            case R.id.logout_menu:
                intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.hoteles_menu:
                intent = new Intent(MainActivity.this, PlacesActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return true;
    }
}
