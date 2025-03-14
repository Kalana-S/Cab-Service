package com.mycompany.simple.maven.service;

import com.mycompany.simple.maven.dao.StaffDAO;
import com.mycompany.simple.maven.model.Staff;

public class StaffService {
    
    private StaffDAO staffDAO = new StaffDAO();

    public boolean registerStaff(String firstName, String lastName, String nic, String password) {
        Staff staff = new Staff(firstName, lastName, nic, password);
        return staffDAO.addStaff(staff);
    }
    
    public Staff loginStaff(String nic, String password) {
        return staffDAO.authenticateStaff(nic, password);
    }
  
}