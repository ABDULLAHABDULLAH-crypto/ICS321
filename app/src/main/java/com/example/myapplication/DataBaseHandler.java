package com.example.myapplication;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;
import java.util.ArrayList;

import Model.Utils.Utils;
public class DataBaseHandler  extends SQLiteOpenHelper {
    public static void main(String[] args) {


    }
    private SQLiteDatabase db=this.getReadableDatabase();
    private Context context ;


    private static final String DATABASE_NAME = "tournamentData.db";
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
//        // Player query
//        /*##############################################################*/
            String query_Player = "CREATE TABLE " + Utils.Player_Table +
                    " (" + Utils.Player_id + " INTEGER NOT NULL," +
                    Utils.team_id_Player+ " INTEGER NOT NULL," +
                    Utils.jersey_no+ " INTEGER NOT NULL," +
                    Utils.player_name+" VARCHAR"+"(40)"+ "NOT NULL," +
                    Utils.position_to_play+"CHAR NOT NULL," +
                    Utils.dt_of_bir+"DATE,"+
                    " PRIMARY KEY (" + Utils.Player_id + "," + Utils.team_id_Player + "));";
                    db.execSQL(query_Player);



////          Card Table
        String query_Card =
                "CREATE TABLE " + Utils.cardTable +
                        " (" + Utils.Player_id + " INTEGER, "+
                        Utils.redCard + " INTEGER , " +
                        Utils.yellowCard + " INTEGER ," +
                        "FOREIGN KEY (" + Utils.Player_id + ") REFERENCES " + Utils.Player_Table + " (" + Utils.Player_id + "));";
        db.execSQL(query_Card);


//        refree Table

        String query_referee = "CREATE TABLE " + Utils.refree_Table +
                " (" + Utils.main_referee_id + " INTEGER NOT NULL," +
                Utils.referee_name + " VARCHAR"+"(40)"+ "NOT NULL," +
                "PRIMARY KEY ( "+ Utils.main_referee_id + "))";

        db.execSQL(query_referee);

//        Match_played Table
        String Match_played_Table = "CREATE TABLE " + Utils.match_played_table +
                " (" + Utils.main_match_no + " INTEGER NOT NULL," +
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
                "PRIMARY KEY (" +Utils.main_match_no+") , " +
                "FOREIGN KEY ( "+ Utils.match_referee_id + ") REFERENCES " + TABLE_NAME + " (" + Utils.main_referee_id +" ),"+
                "FOREIGN KEY ( "+ Utils.venue_id + ") REFERENCES " + TABLE_NAME + " (" + Utils.main_venue_id +" ),"+
                "FOREIGN KEY ( "+ Utils.player_of_match + ") REFERENCES " + TABLE_NAME + " (" + Utils.Player_id+" ));";

        db.execSQL(Match_played_Table);

        //        Venue Table
        String query_Venue = "CREATE TABLE " + Utils.Venue_Table +
                " (" + Utils.main_venue_id + " INTEGER NOT NULL," +
                Utils.venue_name + " VARCHAR"+"(40)"+ "NOT NULL," +
                Utils.venue_status + " CHAR"+"(1)"+ "NOT NULL," +
                Utils.aud_capacity + " INTEGER NOT NULL," +
                "PRIMARY KEY ( "+ Utils.main_venue_id + "))";
        db.execSQL(query_Venue);

  // plying_position query
        String query_plying_position = "CREATE TABLE " + Utils.playing_position_Table +
                " (" + Utils.position_id + "  CHAR"+"(2)"+ " NOT NULL, " +
                Utils.position_desc + " VARCHAR"+"(15)"+ " NOT NULL, " +
                " PRIMARY KEY ( " + Utils.position_id+ " )) ";
        db.execSQL(query_plying_position);

//        coach query
        String query_coach = "CREATE TABLE " + Utils.coach_table +
                " (" + Utils.coach_id + " INTEGER NOT NULL," +
                Utils.coach_name + " VARCHAR"+"(15)"+ "NOT NULL," +
                "PRIMARY KEY ( "+ Utils.coach_id+ "))";
        db.execSQL(query_coach);


//          match_details query
        String match_details_query = "CREATE TABLE " + Utils.match_details_Table +
                " (" + Utils.match_no_match_details + " INTEGER NOT NULL," +
                Utils.team_id_match_details+ " INTEGER NOT NULL," +
                Utils.play_stage_match_details + " CHAR"+"(1)"+"NOT NULL,"+
                Utils.win_lose + " CHAR"+"(1)"+"NOT NULL,"+
                Utils.decided_by + " CHAR"+"(1)"+"NOT NULL," +
                Utils.goal_score+ " INTEGER NOT NULL," +
                Utils.penalty_score + " INTEGER,"+
                Utils.asst_ref + " INTEGER NOT NULL," +
                Utils.player_gk + " INTEGER NOT NULL," +
                "PRIMARY KEY (" +Utils.match_no_match_details+","+Utils.team_id_match_details+") , " +
                "FOREIGN KEY ( "+ Utils.team_id_match_details + ") REFERENCES " + TABLE_NAME + " (" + team_id+" ),"+
                "FOREIGN KEY ( "+ Utils.asst_ref + ") REFERENCES " + TABLE_NAME + " (" + Utils.asst_ref +" ),"+
                "FOREIGN KEY ( "+ Utils.asst_ref + ") REFERENCES " + TABLE_NAME + " (" + Utils.asst_ref +" ),"+
                "FOREIGN KEY ( "+ Utils.match_no_match_details + ") REFERENCES " + TABLE_NAME + " (" + Utils.match_no+" ));";

        db.execSQL(match_details_query);
//
//
//
//        // goal_details query
//
//
        String query_goal_details = "CREATE TABLE " + Utils.goal_details_table +
                " (" + Utils.goal_id + " INTEGER NOT NULL,"
                + Utils.match_no + " INTEGER NOT NULL,"
                + Utils.player_id_goal_details + " INTEGER NOT NULL,"
                + Utils.team_id_goal_details + " INTEGER NOT NULL,"
                + Utils.goal_time + " INTEGER NOT NULL,"
                + Utils.goal_type + " CHAR"+"(1)"+"NOT NULL,"
                + Utils.play_stage + " CHAR"+"(1)"+"NOT NULL,"
                + Utils.goal_schedule + " CHAR"+"(2)"+"NOT NULL,"
                + Utils.goal_half + " INTEGER, "
                + "PRIMARY KEY (" + Utils.goal_id + "), "
                + "FOREIGN KEY ( "+ Utils.team_id_goal_details + ") REFERENCES " + TABLE_NAME + " (" + team_id + "), "
                + "FOREIGN KEY ( "+ Utils.player_id_goal_details + ") REFERENCES " + TABLE_NAME + " (" + Utils.Player_id + "), "
                + "FOREIGN KEY ( "+ Utils.match_no_goal_details + ") REFERENCES " + TABLE_NAME + " (" + Utils.match_no + "));";


        db.execSQL(query_goal_details);
//
//
//
//
//        // penalty_shootout query
//
        String penalty_shootout_query = "CREATE TABLE " + Utils.penalty_shootout_Table +
                " (" + Utils.kick_id + " INTEGER NOT NULL,"
                + Utils.match_no + " INTEGER NOT NULL,"
                + Utils.team_id_penalty_shootout + " INTEGER NOT NULL,"
                + Utils.player_id_penalty_shootout + " INTEGER NOT NULL,"
                + Utils.score_goal + " CHAR"+"(1)"+"NOT NULL,"
                + Utils.kick_no + " INTEGER NOT NULL,"
                + "PRIMARY KEY (" + Utils.kick_id + "), "
                + "FOREIGN KEY ( "+ Utils.team_id_penalty_shootout + ") REFERENCES " + TABLE_NAME + " (" + team_id + "), "
                + "FOREIGN KEY ( "+ Utils.player_id_penalty_shootout + ") REFERENCES " + TABLE_NAME + " (" + Utils.Player_id + "), "
                + "FOREIGN KEY ( "+ Utils.match_no_penalty_shootout + ") REFERENCES " + TABLE_NAME + " (" + Utils.match_no + "));";

        db.execSQL(penalty_shootout_query);


//        // player_booked Table
//
        String player_booked_query = "CREATE TABLE " + Utils.Player_booked_Table +
                " (" + Utils.match_no_Player_booked + " INTEGER NOT NULL,"
                + Utils.team_id_Player_booked + " INTEGER NOT NULL,"
                + Utils.player_id_Player_booked + " INTEGER NOT NULL,"
                + Utils.booking_time + " INTEGER NOT NULL,"
                + Utils.sent_off + " CHAR"+"(1)"+"NOT NULL,"
                + Utils.play_schedule + " CHAR"+"(2)"+"NOT NULL,"
                + Utils.play_half + " INTEGER NOT NULL,"
                + "PRIMARY KEY (" + Utils.match_no + ", " + Utils.team_id_Player_booked + ", " + Utils.player_id_Player_booked + "), "
                + "FOREIGN KEY ( "+ Utils.team_id_Player_booked + ") REFERENCES " + TABLE_NAME + " (" + team_id + "), "
                + "FOREIGN KEY ( "+ Utils.player_id_Player_booked + ") REFERENCES " + TABLE_NAME + " (" + Utils.Player_id + "), "
                + "FOREIGN KEY ( "+ Utils.match_no + ") REFERENCES " + TABLE_NAME + " (" + Utils.match_no + "));";

        db.execSQL(player_booked_query);


//        // match_captain Table
//
        String match_captain_query = "CREATE TABLE " + Utils.match_captain_Table +
                " (" + Utils.match_no_match_captain + " INTEGER NOT NULL,"
                + Utils.team_id_match_captain + " INTEGER NOT NULL,"
                + Utils.player_id_match_captain + " INTEGER NOT NULL,"
                + "PRIMARY KEY (" + Utils.match_no + ", " + Utils.team_id_match_captain + "), "
                + "FOREIGN KEY (" + Utils.team_id_match_captain + ") REFERENCES " + TABLE_NAME + " (" + team_id + "), "
                + "FOREIGN KEY (" + Utils.player_id_match_captain + ") REFERENCES " + TABLE_NAME + " (" + Utils.Player_id + "), "
                + "FOREIGN KEY (" + Utils.match_no + ") REFERENCES " + TABLE_NAME + " (" + Utils.match_no + "));";

        db.execSQL(match_captain_query);

//        //team_coaches Table
//
        String query_team_coaches = "CREATE TABLE " + Utils.team_coaches_Table +
                " (" + Utils.team_id_team_coaches + " INTEGER NOT NULL,"
                + Utils.tr_id + " INTEGER NOT NULL,"
                + Utils.coach_id + " INTEGER NOT NULL,"
                + "PRIMARY KEY (" + Utils.team_id_team_coaches + ", " + Utils.tr_id + "), "
                + "FOREIGN KEY (" + Utils.team_id_team_coaches + ") REFERENCES " + TABLE_NAME + " (" + team_id + "), "
                + "FOREIGN KEY (" + Utils.tr_id + ") REFERENCES " + TABLE_NAME + " (" + Utils.tr_id + "), "
                + "FOREIGN KEY (" + Utils.coach_id + ") REFERENCES " + TABLE_NAME + " (" + Utils.coach_id + "));";

        db.execSQL(query_team_coaches);

//        //penalty_gk Table
//
        String query_penalty_gk = "CREATE TABLE " + Utils.penalty_gk_Table +
                " (" + Utils.match_no_penalty_gk + " INTEGER NOT NULL,"
                + Utils.team_id_penalty_gk + " INTEGER NOT NULL,"
                + Utils.player_gk + " INTEGER NOT NULL,"
                + "PRIMARY KEY (" + Utils.match_no_penalty_gk + ", " + Utils.team_id_penalty_gk + "), "
                + "FOREIGN KEY (" + Utils.team_id_penalty_gk + ") REFERENCES " + TABLE_NAME + " (" + team_id + "), "
                + "FOREIGN KEY (" + Utils.player_gk + ") REFERENCES " + TABLE_NAME + " (" + Utils.Player_id + "), "
                + "FOREIGN KEY (" + Utils.match_no_penalty_gk + ") REFERENCES " + TABLE_NAME + " (" + Utils.match_no + "));";

        db.execSQL(query_penalty_gk);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_Team);
        db.execSQL("DROP TABLE IF EXISTS " + Utils.Venue_Table);
        db.execSQL("DROP TABLE IF EXISTS " + Utils.match_played_table);
        db.execSQL("DROP TABLE IF EXISTS " + Utils.refree_Table);
        db.execSQL("DROP TABLE IF EXISTS " + Utils.playing_position_Table);
        db.execSQL("DROP TABLE IF EXISTS " + Utils.coach_table);
        db.delete("play",null,null);
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

    public void add_player (int player_id , int teamID , int jersey_no , String player_name ,
                         String position_to_play , String dt_of_bir ){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
        cv.put(Utils.Player_id , player_id);
        cv.put(Utils.team_id_Player, teamID);
        cv.put(Utils.jersey_no , jersey_no);
        cv.put(Utils.results, player_name);
        cv.put(Utils.position_to_play, position_to_play);
        cv.put(Utils.dt_of_bir, dt_of_bir);

        long result =  db.insert(Utils.Player_Table, null, cv);
        if (result == -1){
            Toast.makeText(context, "Failed to insert add_player", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added successfully", Toast.LENGTH_SHORT).show();
        }
    }

    public void add_team (  int teamID, int idOfTheTournament , String teamGroup , int matchPlayed ,
                          int won , int draw , int lost ,int goalFor, int goalAgainst , int goalDiff , int points , int groupPosition){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(tr_id , idOfTheTournament);
        cv.put(team_id, teamID);
        cv.put(team_group, teamGroup);
        cv.put(match_played,matchPlayed);
        cv.put(wonT,won);
        cv.put(drawT,draw);
        cv.put(lostT,lost);                              // !!! re added by osama !!!
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


    public void add_played_match(int match_no , String play_stage , String play_date , String results ,
                          String decided_by , String goal_score , int venue_id ,int referee_id, int audience , int player_of_match , int stop1_sec , int stop2_sec){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Utils.main_match_no , match_no);
        cv.put(Utils.play_stage, play_stage);
        cv.put(Utils.play_date , play_date);
        cv.put(Utils.results, results);
        cv.put(Utils.decided_by , decided_by);
        cv.put(Utils.goal_score, goal_score);
        cv.put(Utils.venue_id , venue_id);
        cv.put(Utils.match_referee_id, referee_id);
        cv.put(Utils.audience , audience);
        cv.put(Utils.player_of_match, player_of_match);
        cv.put(Utils.stop1_sec , stop1_sec);
        cv.put(Utils.stop2_sec, stop2_sec);

        long result =  db.insert(Utils.match_played_table, null, cv);
        if (result == -1){
            Toast.makeText(context, "Failed to insert add_played_match", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added successfully", Toast.LENGTH_SHORT).show();
        }
    }

    public void selectCaptain (int matchID , int teamID , int playerID){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Utils.match_no_match_captain , matchID);
        cv.put(Utils.team_id_match_captain , teamID);
        cv.put(Utils.player_id_match_captain , playerID);
        long result =  db.insert(Utils.match_captain_Table, null, cv);
        if (result == -1){
            Toast.makeText(context, "Failed to insert Captain", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added successfully", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteTournament(int tournamentID){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + tr_id + " = "+ tournamentID + "  ; "  );
        Toast.makeText(context, "Deleted successfully", Toast.LENGTH_SHORT).show();

    }

    public void insertData(){
        String[] insert ={

                "INSERT INTO tournament VALUES (1, 'Faculty Tournament', '2023-03-10', '2023-03-25');",
                "INSERT INTO tournament VALUES (2, 'Open Tournament', '2023-03-15', '2023-03-30');",
                "INSERT INTO tournament VALUES (3, 'Student Tournament', '2022-12-10', '2022-12-02');",
                "INSERT INTO tournament VALUES (4, 'Staff Tournament', '2023-02-15', '2023-02-25');",
                "INSERT INTO tournament VALUES (5, 'Annual Tournament', '2023-01-01', '2023-01-15');",


                "INSERT INTO team VALUES (1214,1,'A',3,0,3,0,4,4,0,3,1);",
                "INSERT INTO team VALUES (1215,1,'B',3,1,1,1,3,4,-1,4,2);",
                "INSERT INTO team VALUES (1216,2,'C',3,1,1,1,0,0,0,4,2);",
                "INSERT INTO team VALUES (1217,2,'A',3,1,1,1,1,4,-3,4,1);",
                "INSERT INTO team VALUES (1216,3,'A',3,1,1,1,2,4,-2,4,3);",
                "INSERT INTO team VALUES (1217,3,'B',3,1,1,1,4,2,2,4,1);",
                "INSERT INTO team VALUES (1218,3,'C',3,1,1,1,1,2,-1,4,2);",



                "INSERT INTO venue VALUES (11, 'Main Stadium', 'Y', 20000);",
                "INSERT INTO venue VALUES (22, 'Indoor Stadium', 'Y', 1000);",
                "INSERT INTO venue VALUES (33, 'Jabal Field', 'N', 500);",
                "INSERT INTO venue VALUES (44, 'Student Field', 'Y', 2000);",


                "INSERT INTO playing_position VALUES ('GK', 'Goalkeepers');",
                "INSERT INTO playing_position VALUES ('DF', 'Defenders');",
                "INSERT INTO playing_position VALUES ('MF', 'Midfielders');",
                "INSERT INTO playing_position VALUES ('FD', 'Forwards');",


                "INSERT INTO player VALUES (1001,1214,1, 'Ahmed', 'GK', '1999-03-10');",
                "INSERT INTO player VALUES (1008,1214,2, 'Khalid', 'DF', '1977-02-12');",
                "INSERT INTO player VALUES (1007,1215,1, 'Majid', 'DF', '1998-02-20');",
                "INSERT INTO player VALUES (1016,1214,3, 'Saeed', 'MF', '1999-08-05');",
                "INSERT INTO player VALUES (1013,1215,5, 'Fahd', 'MF', '1997-07-27');",
                "INSERT INTO player VALUES (1010,1215,6, 'Mohammed', 'DF', '1992-11-20');",
                "INSERT INTO player VALUES (1004,1215,7, 'Ali', 'DF', '1995-10-11');",
                "INSERT INTO player VALUES (1012,1215,8, 'Raed', 'MF', '1997-01-05');",
                "INSERT INTO player VALUES (1017,1215,9, 'Mousa', 'MF', '1996-12-17');",
                "INSERT INTO player VALUES (1023,1216,1, 'Naeem', 'GK', '1991-05-27');",
                "INSERT INTO player VALUES (1022,1216,4, 'Yasir', 'FD', '1998-07-15');",
                "INSERT INTO player VALUES (1003,1217,2, 'Nasr', 'GK', '1997-09-25');",
                "INSERT INTO player VALUES (1015,1217,13, 'Ashraf', 'MF', '1994-01-16');",
                "INSERT INTO player VALUES (1019,1217,14, 'Hassan', 'MF', '1991-03-28');",
                "INSERT INTO player VALUES (1009,1217,15, 'Abdullah', 'DF', '1996-06-09');",
                "INSERT INTO player VALUES (1021,1217,16, 'Bassam', 'FD', '1999-07-27');",


                "INSERT INTO referee VALUES (7001,'Hassan');",
                "INSERT INTO referee VALUES (7002,'Robert');",
                "INSERT INTO referee VALUES (7003,'Fayez');",
                "INSERT INTO referee VALUES (7004, 'Mark');",
                "INSERT INTO referee VALUES (7005,'Ahmad');",
                "INSERT INTO referee VALUES (7006,'Faisal');",
                "INSERT INTO referee VALUES (7007,'Noman');",


                "INSERT INTO match_played VALUES (1, 'G', '2020-03-11', 'WIN', 'N', '2-1',11,7001,5113,1015,131,242);",
                "INSERT INTO match_played VALUES (2, 'G', '2020-03-11', 'DRAW', 'N', '1-1',22,7002,510,1003,111,272);",
                "INSERT INTO match_played VALUES (3, 'G', '2020-03-11', 'DRAW', 'N', '1-1',33,7002,510,1003,111,272);",
                "INSERT INTO match_played VALUES (4, 'G', '2020-03-11', 'DRAW', 'N', '1-1',11,7002,510,1003,111,272);",
                "INSERT INTO match_played VALUES (5, 'G', '2020-03-11', 'DRAW', 'N', '1-1',44,7002,510,1003,111,272);",
                "INSERT INTO match_played VALUES (6, 'G', '2020-03-11', 'DRAW', 'N', '1-1',22,7002,510,1003,111,272);",
                "INSERT INTO match_played VALUES (7, 'G', '2020-03-11', 'DRAW', 'N', '1-1',33,7002,510,1003,111,272);",


                "INSERT INTO coach VALUES (9001,'Carlos');",
                "INSERT INTO coach VALUES (9003,'Farhan');",
                "INSERT INTO coach VALUES (9002,'Jameel');",



                "INSERT INTO match_details VALUES (1, 1214, 'G', 'W', 'N', 1, 0,3001,1001);",

                "INSERT INTO match_details VALUES (2, 1215, 'G', 'W', 'N', 2, 0,3004,1003);",
                "INSERT INTO match_details VALUES (2, 1217, 'G', 'L', 'N', 2, 0,3003,1023);",
                "INSERT INTO match_details VALUES (1, 1216, 'G', 'L', 'N', 1, 0,3001,1001);",
                "INSERT INTO match_details VALUES (3, 1218, 'G', 'W', 'N', 2, 0,3005,1023);",


                "INSERT INTO goal_details VALUES (1, 1, 1008, 1214, 72, 'N', 'G', 'NT',2);",
                "INSERT INTO goal_details VALUES (2, 1, 1013, 1214, 82, 'N', 'G', 'NT',2);",
                "INSERT INTO goal_details VALUES (3, 1, 1007, 1214, 72, 'N', 'G', 'NT',2);",
                "INSERT INTO goal_details VALUES (4, 1, 1004, 1214, 12, 'N', 'G', 'NT',1);",
                "INSERT INTO goal_details VALUES (5, 1, 1017, 1214, 15, 'N', 'G', 'NT',1);",
                "INSERT INTO goal_details VALUES (6, 1, 1019, 1214, 32, 'N', 'G', 'NT',1);",



                "INSERT INTO penalty_shootout VALUES (1, 1, 1215, 1019, 'N', 1);",
                "INSERT INTO penalty_shootout VALUES (2, 5, 1217, 1009, 'Y', 4);",

                "INSERT INTO player_booked VALUES (1, 1215, 1019, 36, 'N','NT', 1);",
                "INSERT INTO player_booked VALUES (1, 1217, 1023, 76, 'Y','NT', 2);",


                "INSERT INTO match_captain VALUES (1, 1214, 1019);",
                "INSERT INTO match_captain VALUES (2, 1215, 1023);",

                "INSERT INTO team_coaches VALUES (1214, 2, 9001);",
                "INSERT INTO team_coaches VALUES (1215, 3, 9003);",

                "INSERT INTO penalty_gk VALUES (1, 1214, 1023);",
                "INSERT INTO penalty_gk VALUES (1, 1215, 1007);",


                "INSERT INTO Card VALUES (1001,1,3);",
                "INSERT INTO Card VALUES (1008,3,3);",
                "INSERT INTO Card VALUES (1001,0,1);",

        };
        for (int i = 0 ;insert.length> i ; i++){
            db.execSQL(insert[i]);
        }
    }


//    Browse all match results of a given tournament sorted by date.
   Cursor read_match_result(){
        String query="SELECT * FROM tournament,Match_played WHERE tr_name='Student' ORDER BY play_date;";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=null;
        if(db!=null){
            cursor=db.rawQuery(query,null);
        }

    return cursor;
   }
}
