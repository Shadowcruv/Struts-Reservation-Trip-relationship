package com.example.secondproject.action;

import com.example.secondproject.dao.HistoryDao;
import com.example.secondproject.dao.ReservationDao;
import com.example.secondproject.dao.TripsDao;
import com.example.secondproject.model.History;
import com.example.secondproject.model.Reservation;
import com.example.secondproject.model.Trips;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.struts2.ServletActionContext;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReservationAction extends ActionSupport {

    private Trips trips;

    private Reservation reservation;
    private List<Reservation> reservations;

    private List<History> mHistoric;

    private History history;
    private Integer reservationId;


    public String submit = null;
    public InputStream fileInputStream;
    public String jasperPath = "";
    public String pdfName = "";
    public String rpt = "";



    public String execute(){
        return SUCCESS;
    }

    public String generateReport(){
        try {
            if(submit.equals("pdf")){
                reservations = ReservationDao.getReservations();
                jasperPath = ServletActionContext.getServletContext().getRealPath("/META-INF/Reports");
                pdfName = "ReservationList";
                rpt = "Reservationss.jrxml";
                JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(reservations);
                HashMap<String, Object> pm = new HashMap<String, Object>();
                String logo = jasperPath + "/ws.jpg";
//                pm.put("logo", logo);
                JasperReport jr = JasperCompileManager.compileReport(jasperPath + "\\" + rpt);
                JasperPrint jp = JasperFillManager.fillReport(jr,pm,beanCollectionDataSource);

                // Create the output stream
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

                // Export the report to a PDF and write it to the output stream
                JasperExportManager.exportReportToPdfStream(jp, outputStream);

                // Create an InputStream from the ByteArrayOutputStream
                fileInputStream = new ByteArrayInputStream(outputStream.toByteArray());

                outputStream.flush();
                outputStream.close();

//                fileInputStream = new FileInputStream(new File(jasperPath + pdfName + ".pdf"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return "SUCCESS";
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
