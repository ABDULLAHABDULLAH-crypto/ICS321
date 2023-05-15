package com.example.myapplication.User;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.DataBaseHandler;
import com.example.myapplication.R;

public class AddPlayerActivity extends AppCompatActivity {
        EditText playerID , teamID , jerseyNumber , name,position,date , goal;
        Button addPlayer;
        String[] arrayOfPlayer;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        playerID = findViewById(R.id.editTextplayerID);
        teamID = findViewById(R.id.editTextTeam_ID);
        jerseyNumber = findViewById(R.id.editTextjerseyNumber);
        name = findViewById(R.id.editTextNameOfPlayer);
        position = findViewById(R.id.editTextText4position);

        date = findViewById(R.id.editTextdate);
        goal = findViewById(R.id.editTextGoal);
        addPlayer = findViewById(R.id.buttonAddPlayer);


        addPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseHandler myDB = new DataBaseHandler(AddPlayerActivity.this);
                myDB.add_player_approve(Integer.parseInt(playerID.getText().toString().trim()),
                        Integer.parseInt( teamID.getText().toString().trim()),
                        Integer.parseInt(jerseyNumber.getText().toString().trim()),
                        name.getText().toString().trim(),
                        position.getText().toString().trim(),
                        date.getText().toString().trim(),
                        Integer.parseInt(goal.getText().toString().trim()));
            }
        });
    }
}