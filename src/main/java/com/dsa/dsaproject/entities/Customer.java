package com.dsa.dsaproject.entities;
public class Customer {

    private int cID;
    private String customerCode;
    private String fullName;
    private String location;
    private String phone;

//    Write all setters and getters
    public Customer(int cID, String customerCode, String fullName, String location, String phone) {
        this.cID = cID;
        this.customerCode = customerCode;
        this.fullName = fullName;
        this.location = location;
        this.phone = phone;
    }

    public Customer() {
    }

    public int getcID() {
        return cID;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" + "cID=" + cID + ", customerCode=" + customerCode + ", fullName=" + fullName + ", location=" + location + ", phone=" + phone + '}';
    }
}
