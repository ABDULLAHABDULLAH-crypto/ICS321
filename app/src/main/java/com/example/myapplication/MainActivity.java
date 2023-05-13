package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
//import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.myapplication.Admin.AdminActivity;
import com.example.myapplication.Admin.activity_user;
import com.example.myapplication.User.UserActivity;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView ;
    Button redCard ,highestP,logIn;
    RadioButton userRadioButton,adminRadioButton;
    DataBaseHandler db;
//    SQLiteDatabase database;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        db=new DataBaseHandler(this);
        recyclerView = findViewById(R.id.recyclerView);
        redCard = findViewById(R.id.btnPlayerRedCard);
        highestP = findViewById(R.id.btnPlayerWithHighsetGoal);

        userRadioButton = findViewById(R.id.radioButtonUser);
        adminRadioButton = findViewById(R.id.radioButtonAdmin);

        logIn = findViewById(R.id.btnLogin);
        logIn.setOnClickListener((View) -> {
            if(adminRadioButton.isChecked()) {
                Intent intent = new Intent(MainActivity.this, AdminActivity.class);
                startActivity(intent);
            } else if(userRadioButton.isChecked()){
            Intent intent = new Intent(MainActivity.this , UserActivity.class);
            startActivity(intent);
                }
        });



    }


}