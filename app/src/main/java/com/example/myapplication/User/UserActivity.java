package com.example.myapplication.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.DataBaseHandler;
import com.example.myapplication.R;

public class UserActivity extends AppCompatActivity {

    DataBaseHandler db;
    Button match_results,redCard,highestP;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

//        recyclerView = findViewById(R.id.recyclerView);
//        redCard = findViewById(R.id.btnPlayerRedCard);
        db=new DataBaseHandler(this);

        highestP = findViewById(R.id.btnPlayerWithHighsetGoal);
        highestP.setOnClickListener(v -> {
            String Data=db.highestGoal().get(0);
            TextView textView8 = findViewById(R.id.textView8);
            textView8.setText(Data);
        });
        match_results=findViewById(R.id.match_results);
        match_results.setOnClickListener((v -> {
            Intent intent = new Intent(UserActivity.this, com.example.myapplication.User.match_results.class);
            startActivity(intent);
        }));

    }
}