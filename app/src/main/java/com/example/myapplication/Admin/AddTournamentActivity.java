package com.example.myapplication.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.DataBaseHandler;
import com.example.myapplication.R;

public class AddTournamentActivity extends AppCompatActivity {
        EditText id, name , startDate, endDate ;
        Button add ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tournament);

        id = findViewById(R.id.editTextID);
        name = findViewById(R.id.editTextName);
        startDate = findViewById(R.id.editTextStartDate);
        endDate = findViewById(R.id.editTextEnd_Date);

        add = findViewById(R.id.btnAddTourment2);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseHandler myDB = new DataBaseHandler(AddTournamentActivity.this);
                myDB.addTournament(
                        Integer.parseInt(id.getText().toString().trim()),
                        name.getText().toString().trim(),
                        startDate.getText().toString().trim(),
                        endDate.getText().toString().trim());
            }
        });
    }
}