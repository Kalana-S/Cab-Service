package com.mycompany.simple.maven.model;

import java.sql.Date;

public class Booking {
    private int bookingNumber;
    private String customerName;
    private String endLocation;
    private String vehicleName;
    private Date bookingDate;
    private Date returnDate;
    private int totalDays;
    private double totalPrice;
    
    public Booking() {}

    public Booking(String customerName, String endLocation, String vehicleName, Date bookingDate, Date returnDate, int totalDays, double totalPrice) {
        this.customerName = customerName;
        this.endLocation = endLocation;
        this.vehicleName = vehicleName;
        this.bookingDate = bookingDate;
        this.returnDate = returnDate;
        this.totalDays = totalDays;
        this.totalPrice = totalPrice;
    }

    public int getBookingNumber() { return bookingNumber; }
    public void setBookingNumber(int bookingNumber) { this.bookingNumber = bookingNumber; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getEndLocation() { return endLocation; }
    public void setEndLocation(String endLocation) { this.endLocation = endLocation; }

    public String getVehicleName() { return vehicleName; }
    public void setVehicleName(String vehicleName) { this.vehicleName = vehicleName; }

    public Date getBookingDate() { return bookingDate; }
    public void setBookingDate(Date bookingDate) { this.bookingDate = bookingDate; }

    public Date getReturnDate() { return returnDate; }
    public void setReturnDate(Date returnDate) { this.returnDate = returnDate; }

    public int getTotalDays() { return totalDays; }
    public void setTotalDays(int totalDays) { this.totalDays = totalDays; }

    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
}
