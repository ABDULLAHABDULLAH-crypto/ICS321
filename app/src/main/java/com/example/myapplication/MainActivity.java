package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.myapplication.Admin.AdminActivity;

import com.example.myapplication.User.UserActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button redCard ,highestP,logIn;
    RadioButton userRadioButton,adminRadioButton;
    DataBaseHandler db;

    ListView list;


    ArrayList<String> playedID, teamID, redcard;
    ArrayList<String> combined_redcard;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        db=new DataBaseHandler(this);
        db.insertData();


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