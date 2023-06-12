package com.example.a20f0196.project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20f0196.R;

import java.util.ArrayList;

public class diet2 extends RecyclerView.Adapter<diet2.ViewHolder> {


    ArrayList<String> main=new ArrayList<String>();

    ArrayList<Integer> img1=new ArrayList<Integer>();

    Context context;


    public diet2(ArrayList<String> main, ArrayList<Integer> img1,Context context) {
        this.main = main;

        this.img1 = img1;

        this.context = context;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.diet1, parent, false);
        return new ViewHolder(view);
    }




    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(main.get(position));

        holder.img1.setImageResource(img1.get(position));
        holder.card1.setOnClickListener(v -> {

            Intent intent=new Intent(context,stepsensorMainActivity.class);
            intent.putExtra("position",position);
            context.startActivity(intent);

        });

        // load image using Glide or any other image loading library
    }



    @Override
    public int getItemCount() {
        return main.size();
    }






    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img1;
        TextView textView;
        CardView card1;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img1 = itemView.findViewById(R.id.img111);

            textView = itemView.findViewById(R.id.nam1);
            card1=  itemView.findViewById(R.id.card1);

        }
    }
}
