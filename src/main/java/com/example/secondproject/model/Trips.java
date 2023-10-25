package com.example.secondproject.model;

import java.util.Date;

public class Trips {

    private int id;
    private String passengerName;
    private String departure;
    private String pickUpDate;
    private Integer noOfPassenger;
    private String phone;
    private String email;
    private String destination;
    private String possibleStops;
    private String endDate;
    private Reservation reservation;

    public Trips() {
    }

    public Trips(String passengerName, String departure, Reservation reservation) {
        this.passengerName = passengerName;
        this.departure = departure;
        this.reservation = reservation;
    }

    public Trips(String passengerName, String departure) {
        this.passengerName = passengerName;
        this.departure = departure;
    }

    public Trips(String passengerName, String departure, String pickUpDate, Integer noOfPassenger, String phone, String email, String destination, String possibleStops, String endDate) {
        this.passengerName = passengerName;
        this.departure = departure;
        this.pickUpDate = pickUpDate;
        this.noOfPassenger = noOfPassenger;
        this.phone = phone;
        this.email = email;
        this.destination = destination;
        this.possibleStops = possibleStops;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Integer getNoOfPassenger() {
        return noOfPassenger;
    }

    public void setNoOfPassenger(Integer noOfPassenger) {
        this.noOfPassenger = noOfPassenger;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPossibleStops() {
        return possibleStops;
    }

    public void setPossibleStops(String possibleStops) {
        this.possibleStops = possibleStops;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }



    public Reservation getReservation() {
        return reservation;
    }


    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
