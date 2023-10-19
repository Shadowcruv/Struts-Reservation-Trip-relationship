package com.example.secondproject.action;

import com.example.secondproject.dao.HistoryDao;
import com.example.secondproject.dao.ReservationDao;
import com.example.secondproject.dao.TripsDao;
import com.example.secondproject.model.History;
import com.example.secondproject.model.Reservation;
import com.example.secondproject.model.Trips;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.Authenticator;

import java.time.LocalDate;
import java.util.List;

public class TripAction extends ActionSupport {

    private Trips trips;

    private Integer reservationId;
    private Integer tripId;

    private List<Trips> tripsList;

    private List<History> mHistoric;

    private History history;


    public String execute(){
        return SUCCESS;
    }

    public String getListTrips(){
       tripsList = TripsDao.getTrips();
        mHistoric = HistoryDao.getHistorys();
        return SUCCESS;
    }
    public String saveTrip(){
        ReservationDao.saveReservation(trips.getReservation());
        TripsDao.saveTrips(trips);
        history = new History();
        history.setNow(LocalDate.now());
        history.setHistories(addHistories());
        HistoryDao.saveHistory(history);
        return SUCCESS;

    }

    public String addHistories(){
        String tracker = "Added a new Reservation";
        return tracker;
    }


    public String updateTripById(){
        Trips trips1 = TripsDao.getTripsById(tripId);
        Reservation reservation1 = ReservationDao.getReservationById(reservationId);


        history = new History();
        history.setNow(LocalDate.now());
        history.setHistories(editHistories(trips,trips1));
        HistoryDao.saveHistory(history);

        /*
         reservation1.setClientType(reservation.getClientType());
        reservation1.setName(reservation.getName());
        reservation1.setContactName(reservation.getContactName());
        reservation1.setEmail(reservation.getEmail());
        reservation1.setOffice(reservation.getOffice());
        reservation1.setCreditType(reservation.getCreditType());
        reservation1.setOwner(reservation.getOwner());
         */

//        trips1.getReservation().setClientType();



        trips1.setPassengerName(trips.getPassengerName());
        trips1.setDeparture(trips.getDeparture());
        trips1.setDestination(trips.getDestination());
        trips1.setEmail(trips.getEmail());
        trips1.setPossibleStops(trips.getPossibleStops());
        trips1.setPhone(trips.getPhone());
        trips1.setEndDate(trips.getEndDate());
        trips1.setNoOfPassenger(trips.getNoOfPassenger());
        trips1.setPickUpDate(trips.getPickUpDate());
        trips1.setReservation(reservation1);
        //HistoryDao.saveHistory(history);
        TripsDao.updateTrips(trips1);


        return SUCCESS;
    }


    public String editHistories(Trips trips, Trips trips1){
        String tracker = "";
////        if(trips1 == null){
//            tracker = "Invalid Trips1 object. Unable to update trip histories.";
//        }
        if (!(trips1.getPassengerName().equals(trips.getPassengerName()))) {

            tracker += "Changed Passenger Name to " + trips1.getPassengerName()+ " ";
        }

//        if (trips1.getDeparture().equals(trips.getDeparture())) {
//
//            tracker +=  "Changed Departure to " + trips1.getDeparture();
//        }

        if (!(trips1.getPhone().equals(trips.getPhone()))) {

            tracker = tracker + "Changed Phone Number to " + trips1.getPhone()+ " ";
        }

        if (!(trips1.getEmail().equals(trips.getEmail()))) {

            tracker = tracker + "Changed Email to " + trips1.getEmail()+ " ";
        }


        if (!(trips1.getDestination().equals(trips.getDestination()))) {

            tracker = tracker + "Changed Destination to " + trips1.getDestination()+ " ";
        }

        if (!(trips1.getPossibleStops().equals(trips.getPossibleStops()))) {
            tracker = tracker + "Changed Possible Stops to " + trips1.getEmail() + " ";
        }


        return tracker;

    }


    public String deleteTripById(){
        TripsDao.deleteTrips(tripId);
        return SUCCESS;
    }

    public Trips getTrips() {
        return trips;
    }

    public void setTrips(Trips trips) {
        this.trips = trips;
    }

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }



    public List<Trips> getTripsList() {
        return tripsList;
    }



    public void setTripsList(List<Trips> tripsList) {
        this.tripsList = tripsList;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public List<History> getmHistoric() {
        return mHistoric;
    }

    public void setmHistoric(List<History> mHistoric) {
        this.mHistoric = mHistoric;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }
}
