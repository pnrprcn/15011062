package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    List<Lectures> lecturesList;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtders;
        public TextView txtnot;
        public CardView crd1;

        public ViewHolder(View v){
            super(v);
            txtders = (TextView)v.findViewById(R.id.dersadi);
            txtnot = (TextView)v.findViewById(R.id.dersnotu);
            crd1 = (CardView)v.findViewById(R.id.cards);


        }
    }

    public MyAdapter(List<Lectures> lecturesList){
        this.lecturesList = lecturesList;
    }

    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviews,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    public void onBindViewHolder(ViewHolder holder, int position){
        holder.txtders.setText(lecturesList.get(position).getDersAdi());
        holder.txtnot.setText(lecturesList.get(position).getDersNotu());

    }

    public int getItemCount(){
        return lecturesList.size();}

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}
