package com.glego.arboletesturistico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditT;
    private EditText passwordEditT;

    private String localUsername;
    private String localPassword;
    private String username;
    private String password;
    private String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameEditT = (EditText) findViewById(R.id.username);
        passwordEditT = (EditText) findViewById(R.id.password);
    }

    public void registerClicked(View view) {
        Intent intent =  new Intent(LoginActivity.this, RegisterActivity.class);
        startActivityForResult(intent, 1);
    }

    public void loginClicked(View view) {
        localUsername = usernameEditT.getText().toString();
        localPassword = passwordEditT.getText().toString();
        /**** Check every condition before logging in ******/
        if(!localUsername.isEmpty() && !localPassword.isEmpty()){   //Check that no field is empty
            if(localUsername.equals(username)){     // Check whether users match
                if(localPassword.equals(password)){ // If users match check whether passwords match
                    Intent intent =  new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("email", email);
                    startActivity(intent);
                    finish();
                }else{ //Password incorrect
                    Toast.makeText(this, R.string.password_incorrect, Toast.LENGTH_SHORT).show();
                }
            }else {     // User incorrect
                Toast.makeText(this, R.string.user_error, Toast.LENGTH_SHORT).show();
            }
        }else {     // Both user and password fields are empty
            if(localUsername.isEmpty())
                Toast.makeText(this, R.string.empty_username, Toast.LENGTH_SHORT).show();
            if(localPassword.isEmpty())
                Toast.makeText(this, R.string.empty_password, Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1 && resultCode == RESULT_OK){
            Toast.makeText(this, R.string.registration_ok, Toast.LENGTH_SHORT).show();
            username = data.getExtras().getString("username");
            password = data.getExtras().getString("password");
            email = data.getExtras().getString("email");
        }
        if(requestCode == 1 && resultCode == RESULT_CANCELED){
            Toast.makeText(this, R.string.registration_failed, Toast.LENGTH_SHORT).show();
        }
    }
}
