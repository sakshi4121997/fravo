package com.example.hp.fruitsorder;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Random;
import java.util.logging.Handler;

class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.Holder> {
    int[] color;
    Context context;
    Vegetables vegetables;

    public MyAdapter2(int[] color, Context context, Vegetables vegetables) {
        this.color=color;
        this.context=context;
        this.vegetables=vegetables;
    }

    @NonNull
    @Override
    public MyAdapter2.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view,viewGroup,false);
        return new Holder(view);
    }
    Random rand=new Random();

    @Override
    public void onBindViewHolder(@NonNull MyAdapter2.Holder holder, int i) {
        int n=rand.nextInt(6);
        holder.color.setBackgroundColor(color[n]);
        Glide.with(context)
                .load(vegetables.images[i])
                .into(holder.imageView);
        Glide.with(context).load(vegetables.images[i]).placeholder(R.drawable.dummy).dontAnimate().into(holder.imageView);
        holder.name.setText(vegetables.names[i]);
        holder.dec.setText(vegetables.description[i]);
        holder.price.setText(vegetables.price[i]);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent;
                intent = new Intent(context, VegetableSellers.class);
            }
        });
    }

    @Override
    public int getItemCount() {
        return vegetables.images.length;
    }

    public class Holder extends RecyclerView.ViewHolder {
        LinearLayout color;
        ImageView imageView;
        TextView name;
        TextView dec;
        TextView price;
        Button button;
        public Holder(@NonNull View itemView) {
            super(itemView);
            color=itemView.findViewById(R.id.colorView);
            imageView=itemView.findViewById(R.id.itemImage);
            name=itemView.findViewById(R.id.name);
            dec=itemView.findViewById(R.id.description);
            price=itemView.findViewById(R.id.price);
            button=itemView.findViewById(R.id.add);
        }
    }
}
