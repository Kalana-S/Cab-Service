package com.mycompany.simple.maven.service;

import com.mycompany.simple.maven.dao.VehicleDAO;
import com.mycompany.simple.maven.model.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class VehicleServiceTest {
    
    private VehicleDAO vehicleDAO;
    private VehicleService vehicleService;

    @BeforeEach
    void setUp() {
        vehicleDAO = mock(VehicleDAO.class);
        vehicleService = new VehicleService(vehicleDAO);
    }

    @Test
    void testAddVehicle() {
        when(vehicleDAO.addVehicle(any(Vehicle.class))).thenReturn(true);
        boolean result = vehicleService.addVehicle("Toyota Corolla", "Car", 1.8);
        assertTrue(result);
        verify(vehicleDAO, times(1)).addVehicle(any(Vehicle.class));
    }
    
}
