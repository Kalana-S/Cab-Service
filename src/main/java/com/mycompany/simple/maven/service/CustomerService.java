package com.mycompany.simple.maven.service;

import com.mycompany.simple.maven.dao.CustomerDAO;
import com.mycompany.simple.maven.model.Customer;

public class CustomerService {
    
    private CustomerDAO customerDAO = new CustomerDAO();

    public boolean registerCustomer(String name, String nic, String email, String mobileNo, String password) {
        Customer customer = new Customer(name, nic, email, mobileNo, password);
        return customerDAO.addCustomer(customer);
    }
    
    public boolean loginCustomer(String nic, String password) {
        return customerDAO.authenticateCustomer(nic, password);
    }
    
    public Customer getCustomerDetails(String nic){
        return customerDAO.getCustomerByNIC(nic);
    }
    
    public boolean deleteCustomer(String nic) {
        return customerDAO.deleteCustomerByNIC(nic);
    }
    
}
