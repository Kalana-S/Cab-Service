package com.mycompany.simple.maven.model;

public class Customer {
    private int customerRegistrationNumber;
    private String name;
    private String nic;
    private String email;
    private String mobileNo;
    private String password;

    public Customer() {}

    public Customer(String name, String nic, String email, String mobileNo, String password) {
        this.name = name;
        this.nic = nic;
        this.email = email;
        this.mobileNo = mobileNo;
        this.password = password;
    }

    public int getCustomerRegistrationNumber() {
        return customerRegistrationNumber;
    }

    public void setCustomerRegistrationNumber(int customerRegistrationNumber) {
        this.customerRegistrationNumber = customerRegistrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
