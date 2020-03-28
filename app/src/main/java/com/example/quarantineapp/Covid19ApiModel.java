package com.example.quarantineapp;

import com.google.gson.annotations.SerializedName;

public class Covid19ApiModel {
    @SerializedName("Country")
    private String Country;
    @SerializedName("Province")
    private String Province;
    @SerializedName("Lat")
    private double Lat;
    @SerializedName("Lon")
    private double Lon;
    @SerializedName("Date")
    private String Date;
    @SerializedName("Cases")
    private int Cases;
    @SerializedName("Status")
    private String Status;

    public String getCountry() {
        return Country;
    }

    public String getProvince() {
        return Province;
    }

    public double getLat() {
        return Lat;
    }

    public double getLon() {
        return Lon;
    }

    public String getDate() {
        return Date;
    }

    public int getCases() {
        return Cases;
    }

    public String getStatus() {
        return Status;
    }
}
