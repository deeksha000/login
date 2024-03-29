package com.example.lp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lp3.Success;

public class LoginActivity extends AppCompatActivity {
    EditText username , password;
    int attempts=0;
    Button sign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.uid);
        password = findViewById(R.id.password);
        sign = findViewById(R.id.btn);

    }
    public void signin(View v)
    {
        Bundle b = getIntent().getExtras();
        String uname = b.getString("uid");
        String psswd = b.getString("pwd");
        if(username.getText().toString().equals(uname) && password.getText().toString().equals(psswd))
        {
            Toast.makeText(this,"Login successful",Toast.LENGTH_LONG).show();
            attempts =0;
            Intent i = new Intent(this, Success.class);
            startActivity(i);

        }
        else
        {
            Toast.makeText(this,"Login unsuccessful", Toast.LENGTH_LONG).show();
            attempts++;
            if(attempts ==3 )
                sign.setEnabled(false);
        }

    }
}