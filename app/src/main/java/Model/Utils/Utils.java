package Model.Utils;

public class Utils {

// Venue table
    public static String Venue_Table="plyer";
    public static String main_venue_id="plyer_id";
    public static String venue_name="plyer_id";
    public static String venue_status="venue_status";
    public static String aud_capacity="aud_capacity";




    /// Player table variables
    public static String Player_Table="plyer";
    public static String Player_id="plyer_id";
    public static  String team_id_Player = "team_id";
    public static  String jersey_no = "jersey_no";
    public static  String player_name = "player_name";
    public static String position_to_play="position_to_play";
    public static String dt_of_bir="dt_of_bir";



// referee Table
    public static String refree_Table="referee";
    public static String main_referee_id="referee_id";
    public static String referee_name="referee_name";
    
    //    asst_referee Table
    public static String asst_referee_Table="asst_referee";
    public static String main_asst_ref_id="asst_ref_id";
    public static String asst_ref_name="asst_ref_name";

    

//  match_played Table
    public static String  match_played_table=" match_played";
    public static String main_match_no="match_no";
    public static String play_stage="play_stage";
    public static  String play_date = "play_date";
    public static  String results = "results";
    public static  String decided_by = "decided_by";
    public static String goal_score="goal_score";
    public static String venue_id="venue_id";
    public static  String match_referee_id = "match_referee_id";
    public static  String audience = "audience";
    public static  String player_of_match = "player_of_match";
    public static String stop1_sec="stop1_sec";
    public static String stop2_sec="stop2_sec";
//    Coach Table
    public static String  coach_table=" coach";
    public static String coach_id="coach_id";
    public static String coach_name="coach_name";

//  asst_referee_Table
//    public static String  asst_referee_Table=" asst_referee";       ??????????????????????????????
//    public static String asst_ref_id="asst_ref_id";                 ?????????????????????????????? duplicated

//    match_details_Table
    public static String match_details_Table="match_details";
    public static String match_no_match_details="match_no";
    public static String team_id_match_details="team_id";
    public static String play_stage_match_details="play_stage";
    public static String match_no = "match_no";
    public static  String team_id_match = "team_id";
    public static String win_lose="win_lose";
    public static  String penalty_score = "penalty_score";
    public static  String asst_ref = "asst_ref";
    public static String player_gk="player_gk";

//    goal_details

    public static String goal_details_table="goal_details";
    public static String goal_id = "goal_id";
    public static String match_no_goal_details="match_no";
    public static  String player_id_goal_details = "player_id";
    public static String team_id_goal_details="team_id";
    public static  String goal_time = "goal_time";
    public static  String goal_type = "goal_type";
    public static String play_stage_goal_details="play_stage";
    public static  String goal_schedule = "goal_schedule";
    public static  String goal_half = "goal_half";


//  penalty_shootout Table

    public static String penalty_shootout_Table="penalty_shootout";
    public static String kick_id = "kick_id";
    public static String match_no_penalty_shootout="match_no";
    public static  String player_id_penalty_shootout = "player_id";
    public static String team_id_penalty_shootout="team_id";
    public static  String score_goal = "score_goal";
    public static  String kick_no = "kick_no";

// player_booked Table

    public static String Player_booked_Table="player_booked";
    public static String booking_time = "booking_time";
    public static String match_no_Player_booked="match_no";
    public static  String player_id_Player_booked = "player_id";
    public static String team_id_Player_booked="team_id";
    public static  String sent_off = "sent_off";
    public static  String play_schedule = "play_schedule";
    public static  String play_half = "play_half";


//    player_in_out Table
    public static String player_in_out_Table="player_in_out";
    public static String match_no_player_in_out="match_no";
    public static  String player_id_player_in_out = "player_id";
    public static String team_id_player_in_out="team_id";
    public static  String time_in_out = "time_in_out";

    public static  String in_out = "time_in_out";

    public static  String play_schedule_player_in_out = "play_schedule";
    public static  String play_half_player_in_out = "play_half";

//    match_captain Table
    public static String match_captain_Table="match_captain";
    public static String match_no_match_captain="match_no";
    public static  String player_id_match_captain = "player_id";
    public static String team_id_match_captain="team_id";

// team_coaches Table
    public static String team_coaches_Table="team_coaches";
    public static String match_no_team_coaches="match_no";
    public static  String player_id_team_coaches = "player_id";
    public static String team_id_team_coaches="team_id";

//    penalty_gk Table
    public static String penalty_gk_Table="penalty_gk";
    public static String match_no_penalty_gk="match_no";
    public static  String player_id_penalty_gk = "player_gk";
    public static String team_id_penalty_gk="team_id";

//    playing_position Table
    public static String playing_position_Table="playing_position";
    public static String position_id="position_id";
    public static  String position_desc = "position_desc";





}
