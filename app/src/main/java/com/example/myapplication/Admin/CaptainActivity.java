package com.example.myapplication.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.DataBaseHandler;
import com.example.myapplication.R;

public class CaptainActivity extends AppCompatActivity {
    EditText MatchNumber , TeamID, PlayerID;
    Button addCaptain;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captain);

        MatchNumber = findViewById(R.id.editTextMatchN);
        TeamID = findViewById(R.id.editTextTeamIDForCaptain);
        PlayerID = findViewById(R.id.editTextPlayerID);
        addCaptain = findViewById(R.id.btnSelectCaptain);

        addCaptain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseHandler myDB = new DataBaseHandler(CaptainActivity.this);
                myDB.selectCaptain(
                        Integer.parseInt(MatchNumber.getText().toString().trim()),
                        Integer.parseInt(TeamID.getText().toString().trim()),
                        Integer.parseInt(PlayerID.getText().toString().trim()));
            }
        });

    }
}