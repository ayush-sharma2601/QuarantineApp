package com.example.quarantineapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CovidFragment extends Fragment {
    public CovidFragment() {
    }
    View view;//change names of views in different fragment classes if needed for clarity
    RecyclerView recyclerView;
    ArrayList<CovidModel> covidModels;
    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.covid_fragment,container,false);
        recyclerView=view.findViewById(R.id.covid_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        covidModels=new ArrayList<>();

        final Covid19Api service= RetrofitClientInstance.getClient();

        Call<List<Covid19ApiModel>> call=service.getdata();
        call.enqueue(new Callback<List<Covid19ApiModel>>() {
            @Override
            public void onResponse(Call<List<Covid19ApiModel>> call, Response<List<Covid19ApiModel>> response) {

                if(!response.isSuccessful())
                {
                    Toast.makeText(getContext(),"Code: "+response.code(),Toast.LENGTH_LONG).show();
                    return;
                }
                List<Covid19ApiModel> covid19ApiModels=response.body();
                for (Covid19ApiModel covid19ApiModel:covid19ApiModels)
                {
                    covidModels.add(new CovidModel(covid19ApiModel.getCountry(),covid19ApiModel.getCountryCode(),covid19ApiModel.getLat(),covid19ApiModel.getLon(),covid19ApiModel.getDate(),covid19ApiModel.getConfirmed(),covid19ApiModel.getStatus(),covid19ApiModel.getRecovered(),covid19ApiModel.getDeaths(),covid19ApiModel.getActive()));

                }

                Collections.reverse(covidModels);
                ArrayList<CovidModel> cmodel=new ArrayList<>();
                for(int i=0;i<=9;i++)
                {
                    cmodel.add(covidModels.get(i));
                }

                CovidRvAdapter adapter=new CovidRvAdapter(cmodel,context);
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
