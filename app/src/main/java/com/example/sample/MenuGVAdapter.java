package com.example.sample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MenuGVAdapter extends ArrayAdapter<MenuModel>
{
    public MenuGVAdapter(@NonNull Context context, ArrayList<MenuModel> menuModelArrayList){
        super(context, 0, menuModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item,parent,false);
        }
        MenuModel menuModel = getItem(position);
        TextView menuTV = listItemView.findViewById(R.id.idLabel);
        ImageView menuIV = listItemView.findViewById(R.id.idIcon);
        menuTV.setText(menuModel.getMenu_label());
        menuIV.setImageResource(menuModel.getIcon_label());

        return listItemView;
    }
}
