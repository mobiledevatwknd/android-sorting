package com.example.sample;

public class MenuModel {
    private String menu_label;
    private int icon_label;

    public MenuModel(String menu_label, int icon_label){
        this.menu_label = menu_label;
        this.icon_label = icon_label;
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
}
