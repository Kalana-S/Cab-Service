package com.mycompany.simple.maven.model;

public class Staff {
    private int staffRegistrationNumber;
    private String firstName;
    private String lastName;
    private String nic;
    private String password;

    public Staff() {}

    public Staff(String firstName, String lastName, String nic, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nic = nic;
        this.password = password;
    }

    public int getStaffRegistrationNumber() {
        return staffRegistrationNumber;
    }

    public void setStaffRegistrationNumber(int staffRegistrationNumber) {
        this.staffRegistrationNumber = staffRegistrationNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}