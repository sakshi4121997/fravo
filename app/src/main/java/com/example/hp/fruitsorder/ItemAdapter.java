package com.example.hp.fruitsorder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.Random;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.Holder> {
    int[] color;
    Context context;
    Fruits fruits;
    ItemAdapter(int[] color, Context context, Fruits fruits)
    {
        this.context=context;
        this.color=color;
        this.fruits=fruits;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_view,viewGroup,false);
        return new Holder(view);
    }

    Random rand = new Random();


    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        int n = rand.nextInt(6);
        holder.color.setBackgroundColor(color[n]);
        Glide.with(context)
                .load(fruits.images[i])
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return fruits.images.length;
    }

    public class Holder extends RecyclerView.ViewHolder {
        LinearLayout color;
        ImageView imageView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            color=itemView.findViewById(R.id.colorView);
            imageView=itemView.findViewById(R.id.itemImage);
        }
    }
}
