package com.example.hp.fruitsorder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Random;

class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.Holder> {
    int[] color;
    Context context;
    Fruits fruits;
    ItemAdapter(int[] color,Context context, Fruits fruits){
        this.color=color;
        this.context=context;
        this.fruits=fruits;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.view,viewGroup,false);
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
        holder.name.setText(fruits.names[i]);
        holder.dec.setText(fruits.description[i]);
        holder.price.setText(fruits.price[i]);

    }

    @Override
    public int getItemCount() {
        return fruits.images.length;
    }

    public class Holder extends RecyclerView.ViewHolder {
        LinearLayout color;
        ImageView imageView;
        TextView name;
        TextView dec;
        TextView price;
        public Holder(@NonNull View itemView) {
            super(itemView);
            color=itemView.findViewById(R.id.colorView);
            imageView=itemView.findViewById(R.id.itemImage);
            name=itemView.findViewById(R.id.name);
            dec=itemView.findViewById(R.id.description);
            price=itemView.findViewById(R.id.price);
        }
    }
}