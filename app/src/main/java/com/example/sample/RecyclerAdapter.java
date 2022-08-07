package com.example.sample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<DataViewHolder> {
    Context context;
    ArrayList<MenuModel> menuArray;

    public RecyclerAdapter(Context context, ArrayList<MenuModel> menuArray) {
        this.context = context;
        this.menuArray = menuArray;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_card,parent,false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        MenuModel menuModelObject = menuArray.get(position);
        holder.recyclerImage.setImageResource(menuModelObject.getIcon_label());
        holder.recyclerLabel.setText(menuModelObject.getMenu_label());
    }

    @Override
    public int getItemCount() {
        return menuArray.size();
    }
}
