package com.example.jesusalejandro.spaceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    Button btnInicio,btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInicio = (Button)findViewById(R.id.Main_Btn_Inicio);
        btnRegister = (Button)findViewById(R.id.Main_Btn_Register);

        btnInicio.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.Main_Btn_Inicio){
            startActivity(new Intent(MainActivity.this,Activity_menu.class));

        }
    }
}
