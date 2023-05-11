package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView ;
    Button redCard;
    Button highestP;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);


        recyclerView = findViewById(R.id.recyclerView);
        redCard = findViewById(R.id.btnPlayerRedCard);
        highestP = findViewById(R.id.btnPlayerWithHighsetGoal);

    }
}