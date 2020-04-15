package com.example.quarantineapp;

        import java.util.Calendar;
        import java.util.List;

        import retrofit2.Call;
        import retrofit2.http.GET;
        import retrofit2.http.Headers;
        import retrofit2.http.Url;

public interface Covid19Api {


    @GET("/live/country/south-africa/status/confirmed/date/2020-04-14T13:13:30Z")
    Call<List<Covid19ApiModel>> getdata();

}
