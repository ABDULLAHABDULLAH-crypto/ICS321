package com.example.myapplication.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class AdminActivity extends AppCompatActivity {
        Button addTournament, addTeam , selectCaptain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        addTournament = findViewById(R.id.btnAddTourment);
        addTournament.setOnClickListener((View) -> {
                Intent intent = new Intent(AdminActivity.this, AddTournamentActivity.class);
                startActivity(intent);
        });

        addTeam = findViewById(R.id.AddTeam);
        addTeam.setOnClickListener((View)->{
            Intent intent = new Intent(AdminActivity.this , AddTeamActivity.class);
            startActivity(intent);
        });

        selectCaptain = findViewById(R.id.TeamCaption);
        selectCaptain.setOnClickListener((View) -> {
            Intent intent = new Intent(AdminActivity.this, CaptainActivity.class);
            startActivity(intent);
        });


    }


}