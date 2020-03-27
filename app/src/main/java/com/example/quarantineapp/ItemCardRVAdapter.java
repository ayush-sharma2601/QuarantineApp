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

public class ItemCardRVAdapter extends RecyclerView.Adapter<ItemCardRVAdapter.ICViewHolder> {
    ArrayList<item_card> itemCardArrayList = new ArrayList<>();
    Context context;
    Activity activity;

    public ItemCardRVAdapter(ArrayList<item_card> itemCardArrayList, Context context, Activity activity) {
        this.itemCardArrayList = itemCardArrayList;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ICViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ICViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ICViewHolder holder, int position) {
        holder.PopulateItemCard(itemCardArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemCardArrayList.size();
    }

    public class ICViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        ImageView itemImage,itemIsAvail;
        public ICViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"pressed",Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void PopulateItemCard(item_card item_card) {
            itemName.setText(item_card.getItemName());
            itemImage.setImageResource(item_card.getItemImageID());
            itemIsAvail.setImageResource(item_card.getIsAvailID());
        }
    }
}
