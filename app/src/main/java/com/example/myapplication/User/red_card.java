package com.example.myapplication.User;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.DataBaseHandler;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import java.util.ArrayList;

public class red_card extends AppCompatActivity {



    DataBaseHandler db;



    ArrayList<String> playedID, teamID, redcard, combined_redcard;
    ArrayAdapter<String> adapter;

    ListView list;

    @Override
    protected void onCreate(Bundle savedInsnacesState) {
        super.onCreate(savedInsnacesState);
        setContentView(R.layout.browse_redcard);
        list = findViewById(R.id.list_redcard);
        db = new DataBaseHandler(this);
        playedID = new ArrayList<>();
        teamID = new ArrayList<>();
        redcard = new ArrayList<>();
        combined_redcard = new ArrayList<>();


        displayRedcard();


        for(int i = 0 ; i < playedID.size() ; i++){
            combined_redcard.add(    "pID: " + playedID.get(i) + " tID : " + teamID.get(i) + " number of red cards : " +  redcard.get(i));
        }

        adapter = new ArrayAdapter<>(this,R.layout.item_redcard,R.id.item_redcard_redcard,combined_redcard);

        list.setAdapter(adapter);

    }




    void displayRedcard(){
        Cursor cursor = db.read_Redcard();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"No data", Toast.LENGTH_SHORT).show();
        } else {
            while(cursor.moveToNext()){
                playedID.add(cursor.getString(0));
                teamID.add(cursor.getString(1));
                redcard.add(cursor.getString(2));
            }
        }
    }

}
