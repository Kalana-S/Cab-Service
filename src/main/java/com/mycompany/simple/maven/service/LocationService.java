package com.mycompany.simple.maven.service;

import com.mycompany.simple.maven.dao.LocationDAO;
import com.mycompany.simple.maven.model.Location;

public class LocationService {
    private LocationDAO locationDAO;

    public LocationService() {
        this.locationDAO = new LocationDAO();
    }

    public boolean addLocation(String endLocationName, int distance) {
        Location location = new Location(endLocationName, distance);
        return locationDAO.addLocation(location);
    }
}
