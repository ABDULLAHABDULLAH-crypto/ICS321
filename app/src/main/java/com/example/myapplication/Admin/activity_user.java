package com.example.myapplication.Admin;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.DataBaseHandler;
import com.example.myapplication.R;

import java.util.ArrayList;

public class activity_user extends AppCompatActivity {


    DataBaseHandler db;
    ListView listView;
    Button Match_results;

    Button match_results;
    @Override
    protected void onCreate(Bundle savedInsnacesState) {
        super.onCreate(savedInsnacesState);
        setContentView(R.layout.activity_user);
        listView=findViewById(R.id.recyclerView);
        ArrayList<String> list=db.Query_browse_all_Tournament("Faculty");
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.activity_user);
        listView.setAdapter(adapter);

    }



}
