package com.example.myapplication.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.User.UserActivity;

public class AdminActivity extends AppCompatActivity {
        Button addTournament, addTeam , selectCaptain ,deleteTournament,Log_out;
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


        deleteTournament = findViewById(R.id.btnDeleteTourment2);
        deleteTournament.setOnClickListener((View) ->{
            Intent intent = new Intent(AdminActivity.this, DeleteActivity.class);
            startActivity(intent);
        });
        Log_out=findViewById(R.id.Log_Out_Admin);
        Log_out.setOnClickListener(v->{
            Intent intent = new Intent(AdminActivity.this, MainActivity.class);
            startActivity(intent);
        });


    }


}