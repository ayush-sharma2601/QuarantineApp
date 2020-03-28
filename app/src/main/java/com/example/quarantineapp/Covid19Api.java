package com.example.quarantineapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface Covid19Api {
    @Headers({
            "Content-type:application/json; charset=UTF-8"
    })

    @GET("/live/country/india/status/confirmed/date/2020-03-28T13:13:30Z")
    Call<List<Covid19ApiModel>> getdata();
}
