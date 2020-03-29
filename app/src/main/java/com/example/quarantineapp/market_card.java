package com.example.quarantineapp;

public class market_card {
    private int imageID;
    private String marketName;
    private String marketDistance;
    private int backColor;

    public market_card(int imageID, String marketName, String marketDistance,int backColor) {
        this.imageID = imageID;
        this.marketName = marketName;
        this.marketDistance = marketDistance;
        this.backColor = backColor;
    }

    public int getBackColor() {
        return backColor;
    }

    public void setBackColor(int backColor) {
        this.backColor = backColor;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getMarketDistance() {
        return marketDistance;
    }

    public void setMarketDistance(String marketDistance) {
        this.marketDistance = marketDistance;
    }
}
