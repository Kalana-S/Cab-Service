package com.mycompany.simple.maven.model;

public class Vehicle {
    private int vehicleNumber;
    private String vehicleName;
    private String vehicleType;
    private double addedValue; 
    
    public Vehicle(String vehicleName, String vehicleType, double addedValue) {
        this.vehicleName = vehicleName;
        this.vehicleType = vehicleType;
        this.addedValue = addedValue;
    }
    
      public int getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getAddedValue() {
        return addedValue;
    }

    public void setAddedValue(double addedValue) {
        this.addedValue = addedValue;
    }
     
}
