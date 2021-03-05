package com.example.projekakhir.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.projekakhir.R;
import com.example.projekakhir.adapters.ItemCardViewAdapter;
import com.example.projekakhir.adapters.ItemGridAdapter;
import com.example.projekakhir.adapters.ItemListAdapter;
import com.example.projekakhir.models.Hewan;
import com.example.projekakhir.models.DataHewan;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registerActivity extends AppCompatActivity {
    EditText username,pass,email;
    TextView login,register;

    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.r_name);
        pass = findViewById(R.id.r_pass);
        email = findViewById(R.id.r_email);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

        preferences = getSharedPreferences("userinfo",0);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameValue = username.getText().toString();
                String passValue = pass.getText().toString();
                String emailValue = email.getText().toString();

             if(usernameValue.length()>1){
                 SharedPreferences.Editor editor = preferences.edit();
                 editor.putString("username",usernameValue);
                 editor.putString("pass",passValue);
                 editor.putString("email",emailValue);
                 editor.apply();
                 Toast.makeText(registerActivity.this,"user register",Toast.LENGTH_SHORT).show();
             }
             else{
                 Toast.makeText(registerActivity.this,"enter value in the field",Toast.LENGTH_SHORT).show();
             }


            }
        });

    }

    public void emptyField(){
        username.setText("");
        pass.setText("");
        email.setText("");
    }
}