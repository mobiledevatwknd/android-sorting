package com.example.sample;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataViewHolder extends RecyclerView.ViewHolder {
    ImageView recyclerImage;
    TextView recyclerLabel;
    View view;

    public DataViewHolder(@NonNull View itemView) {
        super(itemView);
        recyclerImage = (ImageView) itemView.findViewById(R.id.recycler_image);
        recyclerLabel = (TextView) itemView.findViewById(R.id.recycler_label);
        view = itemView;
    }
}
