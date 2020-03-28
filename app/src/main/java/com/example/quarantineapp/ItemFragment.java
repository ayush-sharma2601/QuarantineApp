package com.example.quarantineapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemFragment extends Fragment {
    View view;
    RecyclerView itemRV;
    ArrayList<item_card> itemCardArrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.item_fragment,container,false);
        itemRV = view.findViewById(R.id.itemRV);
        String[] itemName={"Bread","Milk","Biscuit","Atta","chawal"};
        int[] itemImage = {R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground};
        int[] itemAvail = {R.drawable.ic_close_black_24dp,R.drawable.ic_check_black_24dp,R.drawable.ic_close_black_24dp,R.drawable.ic_check_black_24dp,R.drawable.ic_close_black_24dp};
        for (int i=0;i<5;i++)
        {
            itemCardArrayList.add(new item_card(itemImage[i],itemAvail[i],itemName[i]));
        }
        itemRV.setLayoutManager(new GridLayoutManager(getContext(),3));
        ItemCardRVAdapter adapter = new ItemCardRVAdapter(itemCardArrayList,getContext(),getActivity());
        itemRV.setAdapter(adapter);
        itemRV.setItemAnimator(new DefaultItemAnimator());
        return view;
    }
}
