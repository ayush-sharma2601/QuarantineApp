package com.example.quarantineapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MarketFragment extends Fragment {
    View view;
    RecyclerView marketRV;
    ArrayList<market_card> marketCardArrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.market_fragment,container,false);
        marketRV = view.findViewById(R.id.market_rv);
        String[] marketName = {"Verma General Store","Singh Drug Store"};
        String[] marketDistance ={"200m","1.3km"};
        int[] marketImages ={R.drawable.scene,R.drawable.scene};
        for (int i=0;i<2;i++)
        {
            marketCardArrayList.add(new market_card(marketImages[i],marketName[i],marketDistance[i]));
        }
        marketRV.setLayoutManager(new LinearLayoutManager(getContext()));
        MarketCardRVAdapter adapter = new MarketCardRVAdapter(marketCardArrayList,getContext(),getActivity());
        marketRV.setAdapter(adapter);
        marketRV.setItemAnimator(new DefaultItemAnimator());
        return view;
    }
}
