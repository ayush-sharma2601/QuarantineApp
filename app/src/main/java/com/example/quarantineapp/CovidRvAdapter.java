package com.example.quarantineapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CovidRvAdapter extends RecyclerView.Adapter<CovidRvAdapter.CovidVH> {

    ArrayList<CovidModel> covidModels;
    Context context;

    public CovidRvAdapter(ArrayList<CovidModel> covidModels, Context context) {
        this.covidModels = covidModels;
        this.context = context;
    }

    @NonNull
    @Override
    public CovidVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CovidVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.covid_rv,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CovidVH holder, int position) {
        holder.populate(covidModels.get(position));
    }

    @Override
    public int getItemCount() {
        return covidModels.size();
    }

    class CovidVH extends RecyclerView.ViewHolder
    {
        TextView status,country,cases,date,latitude,longitude;

        public CovidVH(@NonNull View itemView) {
            super(itemView);
            status=itemView.findViewById(R.id.covid_rv_status);
            date=itemView.findViewById(R.id.covid_rv_date);
            country=itemView.findViewById(R.id.covid_rv_country);
            latitude=itemView.findViewById(R.id.covid_rv_latitude);
            longitude=itemView.findViewById(R.id.covid_rv_longitude);
            cases=itemView.findViewById(R.id.covid_rv_cases);

        }

        void populate(CovidModel covidModel)
        {
            status.setText(covidModel.getStatus());
            date.setText(covidModel.getDate());
            country.setText(covidModel.getCountry());
            latitude.setText(""+covidModel.getLatitude());
            longitude.setText(""+covidModel.getLongitude());
            cases.setText(""+covidModel.getCases());

        }
    }
}