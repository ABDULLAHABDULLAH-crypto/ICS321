package com.example.myapplication.User;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DataBaseHandler;
import com.example.myapplication.R;

import java.util.ArrayList;

public class match_results extends AppCompatActivity {


    static ArrayList<String> matches;


    DataBaseHandler db;
    Button button;
    ListView list_match;
    EditText editTextText2;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInsnacesState) {
        super.onCreate(savedInsnacesState);
        setContentView(R.layout.match_result);
        list_match= findViewById(R.id.list_match);
        button=findViewById(R.id.button);
        editTextText2=findViewById(R.id.editTextText2);
        String user=editTextText2.toString();
        db = new DataBaseHandler(this);
        list=db.getAllmatches(user);

        adapter=new ArrayAdapter<String>(this,R.layout.item ,R.id.textView7,list);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list_match.setAdapter(adapter);

            }
        });

    }



}
