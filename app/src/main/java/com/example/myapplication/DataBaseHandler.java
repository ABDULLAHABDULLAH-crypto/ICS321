package com.example.myapplication;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;
import Utils.Utils;
public class DataBaseHandler  extends SQLiteOpenHelper {

    private Context context ;


    private static final String DATABASE_NAME = "tournamentData";
    private static final int DATABASE_VERSION = 1;

    // tournament table
    /*##############################################################*/
    private static final String TABLE_NAME = "tournament";
    private static final String tr_id = "tr_id";
    private static final String tr_name = "tr_name";
    private static final String start_date = "start_date";
    private static final String end_date = "end_date";
    /*##############################################################*/
    // Team table
    /*##############################################################*/
    private static final String TABLE_NAME_Team = "team";
    private static final String team_id = "team_id";
    private static final String team_group = "team_group";
    private static final String match_played = "match_played";
    private static final String wonT = "won";
    private static final String drawT = "draw";
    private static final String lostT = "lost";
    private static final String goal_for = "goal_for";
    private static final String goal_against = "goal_against";
    private static final String goal_diff = "goal_diff";
    private static final String pointsT = "points";
    private static final String group_position = "group_position";
    /*##############################################################*/


    public DataBaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //tournament query
        /*##############################################################*/
        String query_tournament =
                "CREATE TABLE " + TABLE_NAME +
                        " (" + tr_id + " INTEGER PRIMARY KEY, "+
                                tr_name + " TEXT, " +
                                start_date + " TEXT, " +
                                end_date + " TEXT);";
        db.execSQL(query_tournament);

        // Team query
        /*##############################################################*/
        String query_team = "CREATE TABLE " + TABLE_NAME_Team +
                " (" + tr_id + " INTEGER ," +
                team_id + " INTEGER ," +
                team_group + " TEXT ," +
                match_played + " INTEGER ," +
                wonT + " INTEGER ," +
                drawT + " INTEGER ," +
                lostT + " INTEGER , "+
                goal_for + " INTEGER ," +
                goal_against + " INTEGER ," +
                goal_diff + " INTEGER ,"+
                pointsT + " INTEGER ," +
                group_position + " INTEGER," +
                "PRIMARY KEY (" +team_id + "," + tr_id + ") , " +
                "FOREIGN KEY ( "+ tr_id + ") REFERENCES " + TABLE_NAME + " (" + tr_id +" ));";

        db.execSQL(query_team);

        // Player query
        /*##############################################################*/
        String query_plyer = "CREATE TABLE " + Utils.Plyer_Table +
                " (" + Utils.plyer_id + " INTEGER NOT NULL," +
                Utils.team_id + " INTEGER NOT NULL," +
                Utils.jersey_no+ " INTEGER NOT NULL," +
                Utils.player_name+" VARCHAR"+"(40)"+ "NOT NULL," +
                Utils.position_to_play+"CHAR NOT NULL," +
                Utils.dt_of_bir+"DATE,"+
                "PRIMARY KEY (" +Utils.plyer_id + "," + Utils.team_id + ") , " +
                "FOREIGN KEY ( "+ Utils.team_id + ") REFERENCES " + Utils.Plyer_Table + " (" + Utils.team_id +" ));";

        db.execSQL(query_plyer);
//        refree Table
        String query_referee = "CREATE TABLE " + Utils.refree_Table +
                " (" + Utils.main_referee_id + " INTEGER NOT NULL," +
                Utils.referee_name + " VARCHAR"+"(40)"+ "NOT NULL," +
                "PRIMARY KEY ( "+ Utils.team_id + "))";
        db.execSQL(query_referee);

//        Match_plyed Table
        String Match_plyed_Table = "CREATE TABLE " + Utils.match_played_table +
                " (" + Utils.match_no + " INTEGER NOT NULL," +
                Utils.play_stage+ " CHAR"+"(1)"+"NOT NULL," +
                Utils.play_date + " DATE NOT NULL ," +
                Utils.results + " CHAR"+"(5)"+"NOT NULL,"+
                Utils.decided_by + " CHAR"+"(1)"+"NOT NULL,"+
                Utils.goal_score + " CHAR"+"(5)"+"NOT NULL," +
                Utils.venue_id + " INTEGER NOT NULL, "+
                Utils.match_referee_id + " INTEGER NOT NULL," +
                Utils.audience + " INTEGER NOT NULL," +
                Utils.player_of_match + " INTEGER NOT NULL,"+
                Utils.stop1_sec + " INTEGER NOT NULL," +
                Utils.stop2_sec + " INTEGER NOT NULL," +
                "PRIMARY KEY (" +Utils.match_no+") , " +
                "FOREIGN KEY ( "+ Utils.match_referee_id + ") REFERENCES " + TABLE_NAME + " (" + Utils.main_referee_id +" ),"+
                "FOREIGN KEY ( "+ Utils.venue_id + ") REFERENCES " + TABLE_NAME + " (" + Utils.main_venue_id +" ),"+
                "FOREIGN KEY ( "+ Utils.player_of_match + ") REFERENCES " + TABLE_NAME + " (" + Utils.plyer_id+" ));";

        db.execSQL(Match_plyed_Table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_Team);
        db.execSQL("DROP TABLE IF EXISTS " + Utils.Plyer_Table);
        db.execSQL("DROP TABLE IF EXISTS " + Utils.Plyer_Table);
        db.execSQL("DROP TABLE IF EXISTS " + Utils.Venue_Table);
        db.execSQL("DROP TABLE IF EXISTS " + Utils.match_played_table);
        onCreate(db);
    }
    public void addTournament(int id , String name , String startD , String endD){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(tr_id , id);
        cv.put(tr_name , name);
        cv.put(start_date , startD);
        cv.put(end_date , endD);
       long result =  db.insert(TABLE_NAME, null, cv);
       if (result == -1){
           Toast.makeText(context, "Failed to insert Tournament", Toast.LENGTH_SHORT).show();
       } else {
           Toast.makeText(context, "Added successfully", Toast.LENGTH_SHORT).show();
       }
    }

    public void add_team (int idOfTheTournament , int teamID , String teamGroup , int matchPlayed ,
                         int won , int draw , int lost ,int goalFor, int goalAgainst , int goalDiff , int points , int groupPosition){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(tr_id , idOfTheTournament);
        cv.put(team_id, teamID);
        cv.put(team_group, teamGroup);
        cv.put(match_played,matchPlayed);
        cv.put(wonT,won);
        cv.put(drawT,draw);
        cv.put(lostT,lost);
        cv.put(goal_for,goalFor);
        cv.put(goal_against, goalAgainst);
        cv.put(goal_diff, goalDiff);
        cv.put(pointsT,points);
        cv.put(group_position,groupPosition);
        long result =  db.insert(TABLE_NAME_Team, null, cv);
        if (result == -1){
            Toast.makeText(context, "Failed to insert Team", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added successfully", Toast.LENGTH_SHORT).show();
        }


    }

}
