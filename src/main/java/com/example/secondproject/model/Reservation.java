package com.example.secondproject.model;

import java.util.ArrayList;
import java.util.List;

public class Reservation {

    private Integer id;

    private String office;
    private String owner;
    private String clientType;
    private String creditType;
    private String date;
    private String name;
    private String contactName;
    private String email;
    private String phoneNo;

   private List<Trips> trips = new ArrayList<>();

    public Reservation() {
    }

    public Reservation(String name, String creditType) {
        this.name = name;
        this.creditType = creditType;
    }

    public Reservation(String office, String contactName, Trips trips) {
        this.office = office;
        this.contactName = contactName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public List<Trips> getTrips() {
        return trips;
    }

    public void setTrips(List<Trips> trips) {
        this.trips = trips;
    }
}
