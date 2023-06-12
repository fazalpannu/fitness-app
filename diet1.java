package com.example.a20f0196.project;

import android.content.Context;
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

public class diet1 extends RecyclerView.Adapter<diet1.ViewHolder>{


    ArrayList<String> main=new ArrayList<String>();

    ArrayList<Integer> img1=new ArrayList<Integer>();
    ArrayList<String> sub=new ArrayList<String>();

    ArrayList<Integer> img2=new ArrayList<Integer>();

    Context context;


    public diet1(ArrayList<String> main,ArrayList<String> sub, ArrayList<Integer> img1, ArrayList<Integer> img2,Context context) {
        this.main = main;

        this.img1 = img1;
        this.sub = sub;

        this.img2 = img2;

        this.context = context;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.diet2, parent, false);
        return new ViewHolder(view);
    }




    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView1.setText(main.get(position));

        holder.img1.setImageResource(img1.get(position));
        holder.textView2.setText(sub.get(position));

        holder.img2.setImageResource(img2.get(position));

        // load image using Glide or any other image loading library
    }



    @Override
    public int getItemCount() {
        return main.size();
    }






    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img1,img2;
        TextView textView1,textView2;
        CardView card1;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img1 = itemView.findViewById(R.id.img111);

            textView1 = itemView.findViewById(R.id.nam1);
            img2 = itemView.findViewById(R.id.sub211);

            textView2 = itemView.findViewById(R.id.id1);


        }
    }
}
