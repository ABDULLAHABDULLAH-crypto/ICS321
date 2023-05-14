package com.example.myapplication.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.DataBaseHandler;
import com.example.myapplication.R;

public class DeleteActivity extends AppCompatActivity {
    EditText TournamentID ;
    Button delete ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        TournamentID = findViewById(R.id.editTextDeleteT_ID);
        delete = findViewById(R.id.btnDelete);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseHandler myDb = new DataBaseHandler(DeleteActivity.this);
                myDb.deleteTournament(Integer.parseInt(TournamentID.getText().toString().trim()));
            }
        });

    }
}