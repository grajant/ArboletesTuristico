package com.glego.arboletesturistico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class ProfileActivity extends AppCompatActivity {

    private TextView usernameTextView;
    private TextView emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        usernameTextView = (TextView) findViewById(R.id.username);
        emailTextView = (TextView) findViewById(R.id.email);

        Bundle extras = getIntent().getExtras();

        usernameTextView.setText(extras.getString("username"));
        emailTextView.setText(extras.getString("email"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.main_page_menu:
                intent = new Intent(ProfileActivity.this, MainActivity.class);
                intent.putExtra("username", usernameTextView.getText().toString());
                intent.putExtra("email", emailTextView.getText().toString());
                startActivity(intent);
                finish();
                break;
            case R.id.logout_menu:
                intent = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.hoteles_menu:
                intent = putPlacesExtras("hotel");
                startActivity(intent);
                finish();
                break;
            case R.id.bars_menu:
                intent = putPlacesExtras("restaurant");
                startActivity(intent);
                finish();
                break;
            case R.id.tourist_menu:
                intent = putPlacesExtras("tour");
                startActivity(intent);
                finish();
                break;
        }
        return true;
    }

    private Intent putPlacesExtras(String place){
        Intent intent = new Intent(ProfileActivity.this, PlacesActivity.class);
        intent.putExtra("option", place);
        intent.putExtra("username", usernameTextView.getText().toString());
        intent.putExtra("email", emailTextView.getText().toString());
        return intent;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
        intent.putExtra("username", usernameTextView.getText().toString());
        intent.putExtra("email", emailTextView.getText().toString());
        startActivity(intent);
        finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
