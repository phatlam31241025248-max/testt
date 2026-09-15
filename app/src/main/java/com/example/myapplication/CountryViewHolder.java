package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private MyAdapter madapter;
    public TextView tid;
    public TextView tcountry;

    public CountryViewHolder(@NonNull View itemView, MyAdapter adapter) {
        super(itemView);
        this.madapter = adapter;
        this.tid = itemView.findViewById(R.id.tid);
        this.tcountry = itemView.findViewById(R.id.tcountry);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}