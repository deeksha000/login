		package com.example.lp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText uid,pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pwd = findViewById(R.id.pwd);
        uid = findViewById(R.id.uid);

    }
    public void signup(View v)
    {
        if(pwd.getText().toString().length() > 8 && validatepwd(pwd.getText().toString()))
        {
            Toast.makeText(this,"Sign up successful",Toast.LENGTH_LONG).show();
            Intent i = new Intent(this,LoginActivity.class);
            Bundle b = new Bundle();
            b.putString("uid",uid.getText().toString());
            b.putString("pwd",pwd.getText().toString());
            i.putExtras(b);
            startActivity(i);
        }
        else
        {
            Toast.makeText(this,"Password is not meeting all the constraints",Toast.LENGTH_LONG).show();
        }
    }
    public boolean validatepwd(String password)
    {
        Pattern ptrn ;
        Matcher mat;
        String passwordptrn = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[<>/@$%#*+=])(?=\\S+$).{8,}$";
        ptrn = Pattern.compile(passwordptrn);
        mat= ptrn.matcher(password);
        return mat.matches();
    }
}