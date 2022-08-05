package com.example.sample;

import androidx.annotation.Nullable;

public class MenuModel {
    private String menu_label;
    private int icon_label;
    private int menu_rank;

    public MenuModel(String menu_label, int icon_label, int menu_rank){
        this.menu_label = menu_label;
        this.icon_label = icon_label;
        this.menu_rank = menu_rank;
    }

    public String getMenu_label(){
        return menu_label;
    }

    public void setMenu_label(String menu_label) {
        this.menu_label = menu_label;
    }

    public int getIcon_label(){
        return icon_label;
    }

    public void setIcon_label(int icon_label) {
        this.icon_label = icon_label;
    }

    public int getMenu_rank(){
        return menu_rank;
    }

    public void setMenu_rank(int menu_rank) {
        this.menu_rank = menu_rank;
    }
}
