package com.example.quarantineapp;

public class item_card {
    private int itemImageID,isAvailID;
    private String itemName;

    public item_card(int itemImageID, int isAvailID, String itemName) {
        this.itemImageID = itemImageID;
        this.isAvailID = isAvailID;
        this.itemName = itemName;
    }

    public int getItemImageID() {
        return itemImageID;
    }

    public void setItemImageID(int itemImageID) {
        this.itemImageID = itemImageID;
    }

    public int getIsAvailID() {
        return isAvailID;
    }

    public void setIsAvailID(int isAvailID) {
        this.isAvailID = isAvailID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
