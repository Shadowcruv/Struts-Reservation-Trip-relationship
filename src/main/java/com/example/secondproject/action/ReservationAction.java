package com.example.secondproject.action;

import com.example.secondproject.dao.HistoryDao;
import com.example.secondproject.dao.ReservationDao;
import com.example.secondproject.model.History;
import com.example.secondproject.model.Reservation;
import com.example.secondproject.model.Trips;
import com.opensymphony.xwork2.ActionSupport;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationAction extends ActionSupport {

    private Trips trips;

    private Reservation reservation;
    private List<Reservation> reservations;

    private List<History> mHistoric;

    private History history;
    private Integer reservationId;



    public String execute(){
        return SUCCESS;
    }

    public String addHistories(){
        String tracker = "Added a new Reservation";
        return tracker;
    }

    public String save(){
//       List<Trips> t = new ArrayList<>();
//       t.add(trips);
//       reservation.setTrips(t);
       ReservationDao.saveReservation(reservation);

        history = new History();
        history.setHistories(addHistories());
        history.setNow(LocalDate.now());
        HistoryDao.saveHistory(history);
        return SUCCESS;

    }

    public String editHistories(Reservation reservation, Reservation reservation1){
        String tracker = "";
        if (!(reservation1.getClientType().equals(reservation.getClientType()))) {

            tracker = tracker + "Changed ClientType to " + reservation1.getClientType();
        }

        if (!(reservation1.getContactName().equals(reservation.getContactName()))) {

            tracker = tracker + "Changed ContactName to " + reservation1.getContactName();
        }

        if (reservation1.getCreditType().equals(reservation.getCreditType())) {

            tracker = tracker + "Changed CreditType to " + reservation1.getCreditType();
        }

        if (reservation1.getDate() != (reservation.getDate())) {

            tracker = tracker + "Changed Date to " + reservation1.getDate();
        }


        if (!(reservation1.getName().equals(reservation.getName()))) {

            tracker = tracker + "Changed Name to " + reservation1.getName();
        }

        if (reservation1.getEmail().equals(reservation.getEmail())) {
            tracker = tracker + "Changed Email to " + reservation1.getEmail();
        }

        if (reservation1.getPhoneNo().equals(reservation.getPhoneNo())) {
            tracker = tracker + "Changed PhoneNo to " + reservation1.getPhoneNo();
        }

        return tracker;


    }


    public String getReservationsList()
    {
         reservations = ReservationDao.getReservations();
         mHistoric = HistoryDao.getHistorys();

         return SUCCESS;
    }


    public String updateReservationById(){
        Reservation reservation1 = ReservationDao.getReservationById(reservationId);

        history = new History();
        history.setNow(LocalDate.now());
        history.setHistories(editHistories(reservation,reservation1));

        reservation1.setClientType(reservation.getClientType());
        reservation1.setName(reservation.getName());
        reservation1.setContactName(reservation.getContactName());
        reservation1.setEmail(reservation.getEmail());
        reservation1.setOffice(reservation.getOffice());
        reservation1.setCreditType(reservation.getCreditType());
        reservation1.setOwner(reservation.getOwner());



        ReservationDao.updateReservation(reservation1);
        HistoryDao.saveHistory(history);


        return SUCCESS;

    }

    public String deleteReservationById(){
        ReservationDao.deleteReservation(reservationId);
        return SUCCESS;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
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

    public Trips getTrips() {
        return trips;
    }

    public void setTrips(Trips trips) {
        this.trips = trips;
    }
}
