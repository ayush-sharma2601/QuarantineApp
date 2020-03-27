package com.example.quarantineapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MarketCardRVAdapter extends RecyclerView.Adapter<MarketCardRVAdapter.MCViewholder> {
    private ArrayList<market_card> marketCardArrayList =new ArrayList<>();
    Context context;
    private Activity activity;

    public MarketCardRVAdapter(ArrayList<market_card> marketCardArrayList, Context context, Activity activity) {
        this.marketCardArrayList = marketCardArrayList;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MCViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MCViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.market_card_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MCViewholder holder, int position) {
        holder.populate(marketCardArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return marketCardArrayList.size();
    }

    public class MCViewholder extends RecyclerView.ViewHolder {
         TextView marketName,marketDistance;
         ImageView marketImage;
        public MCViewholder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"pressed",Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void populate(market_card market_card) {
            marketName.setText(market_card.getMarketName());
            marketDistance.setText(market_card.getMarketDistance());
            marketImage.setImageResource(market_card.getImageID());
        }
    }
}
