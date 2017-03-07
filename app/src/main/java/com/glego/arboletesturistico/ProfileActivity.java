package com.glego.arboletesturistico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}
