package com.example.quarantineapp;

        import java.util.Calendar;
        import java.util.List;

        import retrofit2.Call;
        import retrofit2.http.GET;
        import retrofit2.http.Headers;

public interface Covid19Api {


    @GET("/live/country/india/status/confirmed/date/2020-03-30T00:00:00Z")
    Call<List<Covid19ApiModel>> getdata();
}
