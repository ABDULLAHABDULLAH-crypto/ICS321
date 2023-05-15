package com.example.myapplication.User;

import android.annotation.SuppressLint;
import android.content.Context;
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
import com.example.myapplication.R;

import java.util.ArrayList;

public class Allmembers extends AppCompatActivity {


    static ArrayList<String> matches;


    DataBaseHandler db;
    Button button;
    ListView list_all;
    EditText editTextText2;
    ArrayList<String> list;

    ArrayList<String> CouchID, playerID, CaptainID, combined_allMember;


    String user;
    ArrayAdapter<String> adapter;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInsnacesState) {
        super.onCreate(savedInsnacesState);
        setContentView(R.layout.allmembers);
        list_all= findViewById(R.id.list_allmember);
        button=findViewById(R.id.button_allMembers);
        db = new DataBaseHandler(this);






        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                editTextText2=findViewById(R.id.editTextText_allMember);
                user= editTextText2.getText().toString().trim();

                list=db.read_allMembers(user);
                adapter=new ArrayAdapter<>(Allmembers.this,R.layout.item_allmembers ,R.id.item_allmember,list);


                list_all.setAdapter(adapter);


            }
        });




    }


}
