package com.example.quarantineapp;

public class CovidModel {

    private String country;
    private String province;
    private double latitude;
    private double longitude;
    private String date;
    private int cases;
    private String status;

    public CovidModel(String country,String province,double latitude, double longitude, String date, int cases, String status) {
        this.country = country;
        this.province=province;
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
        this.cases = cases;
        this.status = status;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
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

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
