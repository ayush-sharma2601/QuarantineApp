package com.example.quarantineapp;

import com.google.gson.annotations.SerializedName;

public class Covid19ApiModel {
    @SerializedName("Country")
    private String Country;
    @SerializedName("CountryCode")
    private String CountryCode;
    @SerializedName("Lat")
    private String Lat;
    @SerializedName("Lon")
    private String Lon;
    @SerializedName("Date")
    private String Date;
    @SerializedName("Confirmed")
    private int Confirmed;
    @SerializedName("Status")
    private String Status;
    @SerializedName("Recovered")
    private int Recovered;
    @SerializedName("Deaths")
    private int Deaths;
    @SerializedName("Active")
    private int Active;
    @SerializedName("LocationID")
    private String LocationID;


    public String getCountry() {
        return Country;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public String getLat() {
        return Lat;
    }

    public String getLon() {
        return Lon;
    }

    public int getRecovered() {
        return Recovered;
    }

    public int getDeaths() {
        return Deaths;
    }

    public int getActive() {
        return Active;
    }

    public String getLocationID() {
        return LocationID;
    }

    public String getDate() {
        return Date;
    }

    public int getConfirmed() {
        return Confirmed;
    }

    public String getStatus() {
        return Status;
    }
}
