package com.mycompany.simple.maven.service;

import com.mycompany.simple.maven.dao.VehicleDAO;
import com.mycompany.simple.maven.model.Vehicle;

public class VehicleService {
    private VehicleDAO vehicleDAO;

    public VehicleService() {
        this.vehicleDAO = new VehicleDAO();
    }

    public boolean addVehicle(String vehicleName, String vehicleType, double addedValue) {
        Vehicle vehicle = new Vehicle(vehicleName, vehicleType, addedValue);
        return vehicleDAO.addVehicle(vehicle);
    }
    
}
