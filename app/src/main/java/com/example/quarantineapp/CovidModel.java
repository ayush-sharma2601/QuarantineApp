package com.example.quarantineapp;

public class CovidModel {

    private String country;
    private String countryid;
    private String latitude;
    private String longitude;
    private String date;
    private int confirmed;
    private String status;
    private int recovered;
    private int deaths;
    private int active;


    public CovidModel(String country, String countryid, String latitude, String longitude, String date, int confirmed, String status, int recovered, int deaths, int active) {
        this.country = country;
        this.countryid =countryid;
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
        this.confirmed = confirmed;
        this.status = status;
        this.recovered = recovered;
        this.deaths = deaths;
        this.active = active;
    }

    public String getCountryid() {
        return countryid;
    }

    public void setCountryid(String countryid) {
        this.countryid = countryid;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
