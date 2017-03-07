package com.glego.arboletesturistico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText[] dataText;
    private String[] message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dataText = new EditText[4];
        message = new String[4];

        dataText[0] = (EditText) findViewById(R.id.username);
        dataText[1] = (EditText) findViewById(R.id.password);
        dataText[2] = (EditText) findViewById(R.id.repassword);
        dataText[3] = (EditText) findViewById(R.id.email);

        message[0] = getString(R.string.empty_username);
        message[1] = getString(R.string.empty_password);
        message[2] = getString(R.string.empty_repassword);
        message[3] = getString(R.string.empty_email);
    }

    public void registerClicked(View view) {
        boolean isEmpty = false;
        for (int i = 0; i < 4; i++){
            if(dataText[i].getText().toString().isEmpty()) {
                Toast.makeText(this, message[i], Toast.LENGTH_SHORT).show();
                isEmpty = true;
            }

        }
        if(!isEmpty){
            if(dataText[1].getText().toString().equals(dataText[2].getText().toString())){
                Intent intent = new Intent();
                intent.putExtra("username", dataText[0].getText().toString());
                intent.putExtra("password", dataText[1].getText().toString());
                intent.putExtra("email", dataText[3].getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }else{
                Toast.makeText(this, R.string.password_error, Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void cancelClicked(View view) {
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
