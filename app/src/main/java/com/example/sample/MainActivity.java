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

    GridView menuGV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bundle = new Bundle();
        bundle.putInt("some_int", 0);
        CustomView menuGrid = new CustomView();
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
//                .add(R.id.container_custom_view, CustomView.class, bundle)
                .add(menuGrid,"")
                .commit();

//        menuGrid = (CustomView) getSupportFragmentManager().findFragmentById(R.id.container_custom_view);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                menuGrid.customOrder(new MenuInterface() {
                    @Override
                    public ArrayList<MenuModel> customSort(ArrayList<MenuModel> menuModels) {
                        ArrayList<MenuModel> newX = new ArrayList<>();
                        newX.add(menuModels.get(0));
                        return newX;
                    }
                });
            }
        };
        ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();
        worker.schedule(task, 3, TimeUnit.SECONDS);

//        menuGV = findViewById(R.id.idGVMenu);
//
//        ArrayList<String> MenuLabel = new ArrayList<String>();
//        MenuLabel.add("Telepon dan Air");
//        MenuLabel.add("Listrik");
//        MenuLabel.add("Voucher Game");
//        MenuLabel.add("Donasi");
//        MenuLabel.add("Asuransi");
//        MenuLabel.add("BPJS");
//        MenuLabel.add("Multifinanace");

//        MenuController controller = new MenuController(MainActivity.this,this);
//        controller.SortAsc();
//        controller.SortDesc();
//        controller.SortAscName();
//        controller.CustomMethod(mySortingMethod(controller.Array));
//        controller.MenuConstructor();
//
//        Collections.sort(MenuLabel);
//        Log.d("menulabel", String.valueOf(MenuLabel));

//        Collections.sort(menuModelArrayList, new Comparator<MenuModel>() {
//            @Override
//            public int compare(MenuModel lhs, MenuModel rhs) {
//                return lhs.getMenu_label().compareTo(rhs.getMenu_label());
//            }
//        });
        //asc
//        Collections.sort(menuArray, new Comparator<MenuModel>() {
//            @Override
//            public int compare(MenuModel obj1, MenuModel obj2) {
//                return obj1.getMenu_rank() - obj2.getMenu_rank();
//            }
//        });
//        //desc
//        Collections.sort(menuArray, new Comparator<MenuModel>() {
//            @Override
//            public int compare(MenuModel obj1, MenuModel obj2) {
//                return obj2.getMenu_rank() - obj1.getMenu_rank();
//            }
//        });

//        MenuGVAdapter adapter = new MenuGVAdapter(this, menuArray);
//        menuGV.setAdapter(adapter);
    }

    protected ArrayList<MenuModel> mySortingMethod(ArrayList<MenuModel> myArray){
//        Log.d("myArray", String.valueOf(myArray));
        //CustomCode
        Log.d("myarray", String.valueOf(myArray.size()));
        for(int i =0; i<myArray.size(); i++){
            MenuModel element = myArray.get(i);
           String label = element.getMenu_label();
            Log.d("myarray",label);
//            if(label.contains("Dona")){
//                myArray.remove(i);
//            }
//            if(label.contains("Asuran")){
//                myArray.remove(i);
//            }
        }

        //Return Customed Array
        return myArray;
    }
}