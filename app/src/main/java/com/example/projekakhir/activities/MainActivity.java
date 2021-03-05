package com.example.projekakhir.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {

    EditText username,pass;
    TextView login,register;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.l_name);
        pass = findViewById(R.id.l_pass);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

        preferences = getSharedPreferences("userinfo",0);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameValue = username.getText().toString();
                String passValue = pass.getText().toString();

                String registeredusername = preferences.getString("username","");
                String registeredpass = preferences.getString("pass","");


                if(usernameValue.equals(registeredusername) && passValue.equals(registeredpass)){
                    Intent intent =  new Intent(MainActivity.this,homeActivity.class);
                    startActivity(intent);
                }

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,registerActivity.class);
                startActivity(intent);
            }
        });

    }
}