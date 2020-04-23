package com.example.quarantineapp;

        import java.util.Calendar;
        import java.util.List;

        import retrofit2.Call;
        import retrofit2.http.GET;
        import retrofit2.http.Headers;
        import retrofit2.http.Path;
        import retrofit2.http.Url;

public interface Covid19Api {


    @GET("/live/country/south-africa/status/confirmed/date/{date}")
    Call<List<Covid19ApiModel>> getdata(@Path("date") String date);

}
