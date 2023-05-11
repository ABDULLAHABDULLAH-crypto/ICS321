package com.example.myapplication.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.DataBaseHandler;
import com.example.myapplication.R;

public class AddTeamActivity extends AppCompatActivity {
    EditText idOfTheTournament ,  teamID ,  teamGroup ,  matchPlayed ,
     won ,  draw ,  lost , goalFor,  goalAgainst ,  goalDiff ,  points ,  groupPosition ;
    Button add;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_team);

        idOfTheTournament = findViewById(R.id.editTextTournamentID);
        teamID = findViewById(R.id.editTextTeamID);
        teamGroup = findViewById(R.id.editTextTeamGroup);
        matchPlayed = findViewById(R.id.editTextMatchPlayed);
        won = findViewById(R.id.editTextwon);
        draw = findViewById(R.id.editTextdraw);
        lost = findViewById(R.id.editTextlost);
        goalFor = findViewById(R.id.editTextGoalFor);
        goalAgainst = findViewById(R.id.editTextGoalAgainst);
        goalDiff = findViewById(R.id.editTextGoalDiffrent);
        points = findViewById(R.id.editTextPoints);
        groupPosition = findViewById(R.id.editTextGroupPosition);
        add = findViewById(R.id.btnAddTeam);

        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DataBaseHandler myDB = new DataBaseHandler(AddTeamActivity.this);
                myDB.add_team(
                        Integer.parseInt(idOfTheTournament.getText().toString().trim()),
                        Integer.parseInt(teamID.getText().toString().trim()),
                        teamGroup.getText().toString().trim(),
                        Integer.parseInt(matchPlayed.getText().toString().trim()),
                        Integer.parseInt(won.getText().toString().trim()),
                        Integer.parseInt(draw.getText().toString().trim()),
                        Integer.parseInt(lost.getText().toString().trim()),
                        Integer.parseInt(goalFor.getText().toString().trim()),
                        Integer.parseInt(goalAgainst.getText().toString().trim()),
                        Integer.parseInt(goalDiff.getText().toString().trim()),
                        Integer.parseInt(points.getText().toString().trim()),
                        Integer.parseInt(groupPosition.getText().toString().trim())

                );
            }
        });
    }
}