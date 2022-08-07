package com.example.sample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MenuController extends AppCompatActivity {
    ArrayList<MenuModel> Array = MenuArray();

    private final Context context;
    Activity activity;
    GridView menuGV;
    public MenuController(Context context,Activity activity){
        super();
        this.context=context;
        this.activity=activity;
    }

    public void MenuConstructor(){
        menuGV = (GridView) activity.findViewById(R.id.my_recycler_view);
     MenuGVAdapter adapter = new MenuGVAdapter(context, Array);
    menuGV.setAdapter(adapter);
    }

    public ArrayList<MenuModel> MenuArray(){
        ArrayList<MenuModel> menuModelArrayList = new ArrayList<MenuModel>();
        menuModelArrayList.add(new MenuModel("Telepon dan Air", R.drawable.ic_imkas_phone,5));
        menuModelArrayList.add(new MenuModel("Listrik", R.drawable.ic_imkas_pln,2));
        menuModelArrayList.add(new MenuModel("Voucher Game", R.drawable.ic_imkas_game,1));
        menuModelArrayList.add(new MenuModel("Donasi", R.drawable.ic_imkas_duit,6));
        menuModelArrayList.add(new MenuModel("Asuransi", R.drawable.ic_imkas_insurance,4));
        menuModelArrayList.add(new MenuModel("BPJS", R.drawable.ic_imkas_bpjs,3));
        menuModelArrayList.add(new MenuModel("Multifinanace", R.drawable.ic_imkas_multifinance,7));
        return menuModelArrayList;
    }

    public void SortAsc(){
        Collections.sort(Array, new Comparator<MenuModel>() {
            @Override
            public int compare(MenuModel obj1, MenuModel obj2) {
                return obj1.getMenu_rank() - obj2.getMenu_rank();
            }
        });
    }
    public void SortDesc(){
        Collections.sort(Array, new Comparator<MenuModel>() {
            @Override
            public int compare(MenuModel obj1, MenuModel obj2) {
                return obj2.getMenu_rank() - obj1.getMenu_rank();
            }
        });
    }
    public void SortAscName(){
        Collections.sort(Array, new Comparator<MenuModel>() {
            @Override
            public int compare(MenuModel obj1, MenuModel obj2) {
                return obj1.getMenu_label().compareTo(obj2.getMenu_label());
            }
        });
    }

    public void CustomMethod(ArrayList<MenuModel> m){
        Array = m;
    };


}
