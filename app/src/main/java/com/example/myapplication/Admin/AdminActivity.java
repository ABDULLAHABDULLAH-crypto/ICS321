package com.example.myapplication.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.DataBaseHandler;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {
        Button addTournament, addTeam , selectCaptain ,deleteTournament,ApprovePlayer,log_out;
        ArrayList<String> PlayerID , TeamID,JerseyNumber,PlayerName,Position,Date , goals;
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
        log_out = findViewById(R.id.Log_Out_Admin);
        log_out.setOnClickListener((View) -> {
            Intent intent = new Intent(AdminActivity.this, MainActivity.class);
            startActivity(intent);
        });


        deleteTournament = findViewById(R.id.btnDeleteTourment2);
        deleteTournament.setOnClickListener((View) ->{
            Intent intent = new Intent(AdminActivity.this, DeleteActivity.class);
            startActivity(intent);
        });
        ApprovePlayer = findViewById(R.id.ApprovePlayer);
        ApprovePlayer.setOnClickListener((View)-> {
            DataBaseHandler myDB = new DataBaseHandler(AdminActivity.this);
            PlayerID = new ArrayList<>();
            TeamID = new ArrayList<>();
            JerseyNumber = new ArrayList<>();
            PlayerName = new ArrayList<>();
            Position = new ArrayList<>();
            Date = new ArrayList<>();
            goals = new ArrayList<>();
           Cursor cursor = myDB.add_player();

           if (cursor.getCount() == 0){
               Toast.makeText(View.getContext(), "No Player to approve", Toast.LENGTH_SHORT).show();
           }else {
               int i =0;
               while (cursor.moveToNext()){
                   PlayerID.add(cursor.getString(0));
                   TeamID.add(cursor.getString(1));
                   JerseyNumber.add(cursor.getString(2));
                   PlayerName.add(cursor.getString(3));
                   Position.add(cursor.getString(4));
                   Date.add(cursor.getString(5));
                   goals.add(cursor.getString(6));
                   myDB.add_player(
                           Integer.parseInt(PlayerID.get(i)),
                           Integer.parseInt(TeamID.get(i)),
                           Integer.parseInt(JerseyNumber.get(i)),
                           PlayerName.get(i).trim(),
                           Position.get(i).trim(),
                           Date.get(i).trim(),
                           Integer.parseInt(goals.get(i)));
                   i++;
               }
           }
        });

    }
}