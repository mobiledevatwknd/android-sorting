package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView menuGV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuGV = findViewById(R.id.idGVMenu);

        ArrayList<MenuModel> menuModelArrayList = new ArrayList<MenuModel>();
        menuModelArrayList.add(new MenuModel("Telepon dan Air", R.drawable.ic_imkas_phone));
        menuModelArrayList.add(new MenuModel("Listrik", R.drawable.ic_imkas_pln));
        menuModelArrayList.add(new MenuModel("Voucher Game", R.drawable.ic_imkas_game));
        menuModelArrayList.add(new MenuModel("Donasi", R.drawable.ic_imkas_duit));
        menuModelArrayList.add(new MenuModel("Asuransi", R.drawable.ic_imkas_insurance));
        menuModelArrayList.add(new MenuModel("BPJS", R.drawable.ic_imkas_bpjs));
        menuModelArrayList.add(new MenuModel("Multifinanace", R.drawable.ic_imkas_multifinance));

        MenuGVAdapter adapter = new MenuGVAdapter(this, menuModelArrayList);
        menuGV.setAdapter(adapter);
    }
}