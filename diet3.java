package com.example.a20f0196.project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20f0196.R;

import java.util.ArrayList;
import java.util.HashMap;

public class diet3 extends RecyclerView.Adapter<diet3.ViewHolder>{
    ArrayList<HashMap<String, String>> main = new ArrayList<HashMap<String, String>>();


    Context context;


    public diet3(ArrayList<HashMap<String, String>> main,Context context) {
        this.main = main;



        this.context = context;
    }




    @NonNull
    @Override
    public diet3.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.diet3, parent, false);
        return new diet3.ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull diet3.ViewHolder holder, int position) {
        HashMap<String, String> item = main.get(position);

        // Set the values from the HashMap to the corresponding TextViews in the ViewHolder
        holder.name.setText("Name : " + item.get("Name"));
        holder.id.setText("Id : " + item.get("id"));
        holder.weight.setText("Weight : " + item.get("Weight"));
        holder.height.setText("Height : " + item.get("Height"));
        holder.age.setText("Age : " + item.get("Age"));

        holder.card1.setOnClickListener(v -> {
            Intent intent = new Intent(context, updatedeleteMainActivity.class);
            intent.putExtra("id", String.valueOf(position+1));
            context.startActivity(intent);
        });

        // Load image using Glide or any other image loading library
    }




    @Override
    public int getItemCount() {
        return main.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {


        TextView name,id,weight,height,age;
        CardView card1;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);



            name=itemView.findViewById(R.id.nam1);
            id=itemView.findViewById(R.id.id1);
            age=itemView.findViewById(R.id.age);
            weight=itemView.findViewById(R.id.weight);
            height=itemView.findViewById(R.id.height);
            card1=  itemView.findViewById(R.id.card1);

        }
    }
}
