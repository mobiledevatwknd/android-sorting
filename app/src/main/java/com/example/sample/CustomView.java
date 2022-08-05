package com.example.sample;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CustomView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CustomView extends Fragment {
    ArrayList<MenuModel> menuModels;
    GridView menuGV;
    MenuGVAdapter adapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CustomView() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment customView.
     */
    // TODO: Rename and change types and number of parameters
    public static CustomView newInstance(String param1, String param2) {
        CustomView fragment = new CustomView();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_custom_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        menuModels = createMenuModels();
//        sortAsc(menuModels);
        menuGV = (GridView) view.findViewById(R.id.idGVMenu);
        adapter = new MenuGVAdapter(getContext(), menuModels);
        menuGV.setAdapter(adapter);
    }

    public ArrayList<MenuModel> createMenuModels(){
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

    public void sortAsc(ArrayList<MenuModel> menuModels){
        Collections.sort(menuModels, new Comparator<MenuModel>() {
            @Override
            public int compare(MenuModel obj1, MenuModel obj2) {
                return obj1.getMenu_rank() - obj2.getMenu_rank();
            }
        });
    }
    public void sortDesc(ArrayList<MenuModel> menuModels){
        Collections.sort(menuModels, new Comparator<MenuModel>() {
            @Override
            public int compare(MenuModel obj1, MenuModel obj2) {
                return obj2.getMenu_rank() - obj1.getMenu_rank();
            }
        });
    }
    public void sortAscName(ArrayList<MenuModel> menuModels){
        Collections.sort(menuModels, new Comparator<MenuModel>() {
            @Override
            public int compare(MenuModel obj1, MenuModel obj2) {
                return obj1.getMenu_label().compareTo(obj2.getMenu_label());
            }
        });
    }

//    public void customMethod(ArrayList<MenuModel> m){
//        menuModels = m;
//    };
    public void customOrder(MenuInterface menuInterface){
        ArrayList<MenuModel> newMenuModels = menuInterface.customSort(menuModels);
//        MenuGVAdapter adapter = new MenuGVAdapter(getContext(), newMenuModels);
    adapter.clear();
    adapter.notifyDataSetChanged();
//        menuGV.setAdapter(adapter);
    }
}