package com.example.quarantineapp;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;


public class ShopFragment extends Fragment {
    View view;
    RecyclerView itemRV;
    TextView addBtn;
    ArrayList<Items> itemCardArrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shop,container,false);
        itemRV = view.findViewById(R.id.rv_items);
        addBtn = view.findViewById(R.id.shop_item_add_btn);
        String[] itemName={"Bread","Milk","Biscuit","Atta","chawal"};
        String[] quantity = {"Plenty", "Few","Plenty","None","Plenty"};
        for (int i=0;i<5;i++)
        {
            itemCardArrayList.add(new Items(itemName[i],quantity[i]));
        }
        itemRV.setLayoutManager(new GridLayoutManager(getContext(),3));
        ItemsRVAdapter adapter = new ItemsRVAdapter(itemCardArrayList,getContext());
        itemRV.setAdapter(adapter);
        itemRV.setItemAnimator(new DefaultItemAnimator());
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Add Buttton Pressed",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
