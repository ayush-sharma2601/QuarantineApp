package com.example.quarantineapp;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class CovidFragment extends Fragment {
    public CovidFragment() {
    }
    View view;//change names of views in different fragment classes if needed for clarity
    RecyclerView recyclerView;
    ArrayList<CovidModel> covidModels;
    Context context;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.covid_fragment,container,false);
        recyclerView=view.findViewById(R.id.covid_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));


        final Covid19Api service= RetrofitClientInstance.getClient();

        calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -5);
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        date = dateFormat.format(calendar.getTime());
        Log.i(TAG, "onCreateView: "+ date);
        StringBuilder date_get = new StringBuilder();
        date_get.append(date.subSequence(6,10)).append("-").append(date.subSequence(0,2)).append("-").append(date.subSequence(3,5)).append("T00:00:00Z");
        Log.i(TAG, "date: "+date_get);
        Call<List<Covid19ApiModel>> call=service.getdata(date_get.toString());
        call.enqueue(new Callback<List<Covid19ApiModel>>() {
            @Override
            public void onResponse(Call<List<Covid19ApiModel>> call, Response<List<Covid19ApiModel>> response) {

                if(!response.isSuccessful())
                {
                    Toast.makeText(getContext(),"Code: "+response.code(),Toast.LENGTH_LONG).show();
                    return;
                }
                List<Covid19ApiModel> covid19ApiModels=response.body();
                covidModels=new ArrayList<>();
                for (Covid19ApiModel covid19ApiModel:covid19ApiModels)
                {

                    covidModels.add(new CovidModel(covid19ApiModel.getCountry(),covid19ApiModel.getCountryCode(),covid19ApiModel.getLat(),covid19ApiModel.getLon(),covid19ApiModel.getDate(),covid19ApiModel.getConfirmed(),covid19ApiModel.getStatus(),covid19ApiModel.getRecovered(),covid19ApiModel.getDeaths(),covid19ApiModel.getActive()));

                }


                Collections.reverse(covidModels);
                CovidRvAdapter adapter=new CovidRvAdapter(covidModels,context);
                recyclerView.setAdapter(adapter);

            }
            @Override
            public void onFailure(Call<List<Covid19ApiModel>> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        covidModels=new ArrayList<>();

        return view;
    }

}
