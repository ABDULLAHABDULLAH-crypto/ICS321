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

    public CustomAdapter(Context context, ArrayList<String> matches, ArrayList<String> results) {
        this.context = context;
        this.matches = matches;
        this.result = results;
    }

    private Context context;
        private ArrayList<String> matches,result;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.match_result,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.match.setText(String.valueOf(matches.get(position)));
             holder.result.setText(String.valueOf(result.get(position)));
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView match,result;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
//            match=itemView.findViewById(R.id.match_id);
//            result=itemView.findViewById(R.id.result_id);
        }
    }
}
