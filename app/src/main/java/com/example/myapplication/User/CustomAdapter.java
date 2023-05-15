package com.example.myapplication.User;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {



    private Context context;
    private ArrayList<String> player_ID, team_ID, red_card;


    public CustomAdapter(Context context,
                  ArrayList player_ID,
                  ArrayList team_ID,
                  ArrayList red_card){
        this.context = context;
        this.player_ID = player_ID;
        this.red_card = red_card;
        this.team_ID = team_ID;
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.browse_redcard, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.player_id.setText(String.valueOf(player_ID.get(position)));
        holder.team_id.setText(String.valueOf(team_ID.get(position)));
        holder.redCard.setText(String.valueOf(red_card.get(position)));
    }

    @Override
    public int getItemCount() {
        return player_ID.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView player_id, team_id, redCard;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
//            player_id = itemView.findViewById(R.id.item_redcard_player_id);
//            team_id = itemView.findViewById(R.id.item_redcard_team_id);
//            redCard = itemView.findViewById(R.id.item_redcard_redcard);

        }
    }
}
