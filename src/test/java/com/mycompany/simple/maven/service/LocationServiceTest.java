package com.mycompany.simple.maven.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import com.mycompany.simple.maven.dao.LocationDAO;
import com.mycompany.simple.maven.model.Location;

public class LocationServiceTest {
    
    private LocationDAO locationDAO;
    private LocationService locationService;

    @BeforeEach
    void setUp() {
        locationDAO = mock(LocationDAO.class);
        locationService = new LocationService(locationDAO);
    }

    @Test
    void testAddLocation() {
        when(locationDAO.addLocation(any(Location.class))).thenReturn(true);
        boolean result = locationService.addLocation("Downtown", 10);
        assertTrue(result);
        verify(locationDAO, times(1)).addLocation(any(Location.class));
    }
}
