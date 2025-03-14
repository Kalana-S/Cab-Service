package com.mycompany.simple.maven.model;

public class Location {
    private int locationNumber;
    private String endLocationName;
    private int distance;
    private int price;

    public Location(String endLocationName, int distance) {
        this.endLocationName = endLocationName;
        this.distance = distance;
    }
    
     public int getLocationNumber() {
        return locationNumber;
    }

    public void setLocationNumber(int locationNumber) {
        this.locationNumber = locationNumber;
    }

    public String getEndLocationName() {
        return endLocationName;
    }

    public void setEndLocationName(String endLocationName) {
        this.endLocationName = endLocationName;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getPrice() {
        return price;
    }
    
}
