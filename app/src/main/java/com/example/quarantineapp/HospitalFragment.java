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

public class HospitalFragment extends Fragment {
    public HospitalFragment() {
    }
    View view;
    RecyclerView hospRV;
    ArrayList<market_card> hospArrayList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.hospital_fragment,container,false);
        hospRV = view.findViewById(R.id.hospital_recyclervie);
        String[] marketName = {"Hospital A","Hospital B","Hospital C","Hospital D"};
        String[] marketDistance ={"200m","1.3km","2km","400m"};
        int[] marketImages ={R.drawable.scene,R.drawable.scene};
        for (int i=0;i<4;i++)
        {
            hospArrayList.add(new market_card(R.drawable.hospital,marketName[i],marketDistance[i],0xFF03A9F4));
        }
        hospRV.setLayoutManager(new LinearLayoutManager(getContext()));
        MarketCardRVAdapter adapter = new MarketCardRVAdapter(hospArrayList,getContext(),getActivity());
        hospRV.setAdapter(adapter);
        hospRV.setItemAnimator(new DefaultItemAnimator());
        return view;
    }
}
