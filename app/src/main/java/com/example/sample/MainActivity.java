package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Bundle bundle = new Bundle();
    bundle.putInt("some_int", 0);
    CustomView menuView = new CustomView();
    getSupportFragmentManager().beginTransaction()
        .setReorderingAllowed(true)
        .add(menuView, "")
        .commit();

    menuView = (CustomView) getSupportFragmentManager().findFragmentById(R.id.container_custom_view);
    // TODO: pre-defined sort
    menuView.sortDesc();


    // TODO: custom sort
    menuView.customOrder(new MenuInterface() {
      @Override
      public ArrayList<MenuModel> customSort(ArrayList<MenuModel> menuModels) {
        ArrayList<MenuModel> newMenu = new ArrayList<>();
        newMenu.add(menuModels.get(0));
        newMenu.add(menuModels.get(2));
        newMenu.add(menuModels.get(1));
        return newMenu;
      }
    });
  }
}