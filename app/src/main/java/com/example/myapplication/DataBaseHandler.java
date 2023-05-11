package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DataBaseHandler  extends android.database.sqlite.SQLiteOpenHelper {

    private Context context ;
    private static final String DATABASE_NAME = "tournament";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "tournament";
    private static final String tr_id = "tr_id";
    private static final String tr_name = "tr_name";
    private static final String start_date = "start_date";
    private static final String end_date = "end_date";

    public DataBaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query_tournament =
                "CREATE TABLE " + TABLE_NAME +
                        " (" + tr_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                                tr_name + " TEXT, " +
                                start_date + " TEXT, " +
                                end_date + " TEXT);";
        db.execSQL(query_tournament);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}
