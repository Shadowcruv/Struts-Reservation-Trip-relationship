package com.example.secondproject.action;

import com.example.secondproject.dao.HistoryDao;
import com.example.secondproject.dao.ReservationDao;
import com.example.secondproject.dao.TripsDao;
import com.example.secondproject.model.History;
import com.example.secondproject.model.Reservation;
import com.example.secondproject.model.Trips;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.Authenticator;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import org.apache.struts2.ServletActionContext;

import java.io.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class TripAction extends ActionSupport {

    private Trips trips;

    private Date rdate;

    private Date pickUpDate;
    private Date endDate;

    private String theName;

    private Integer reservationId;
    private Integer tripId;

    private List<Trips> tripsList;

    private List<History> mHistoric;

    private History history;

    public String submit = null;
    public InputStream fileInputStream;
    public InputStream excelInputStream;
    public String jasperPath = "";
    public String pdfName = "";
    public String excelName = "";
    public String rpt = "";


    public String execute(){
        return SUCCESS;
    }

    public String generateReport(){
        try {
            if(submit.equals("pdf")){
                tripsList = TripsDao.getTrips();
                jasperPath = ServletActionContext.getServletContext().getRealPath("/META-INF/Reports");
                pdfName = "TripReport";
                rpt = "Trin.jrxml";
                JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(tripsList);
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

    public String generateExcelReport() {
        try {
            if (submit.equals("excel")) { // Assuming 'submit' is used to determine the format
                tripsList = TripsDao.getTrips();
                jasperPath = ServletActionContext.getServletContext().getRealPath("/META-INF/Reports");
                excelName = "TripReport"; // Set the Excel file name
                rpt = "Trin.jrxml";
                JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(tripsList);
                HashMap<String, Object> pm = new HashMap<String, Object>();
                // Set other report parameters as needed
                String logo = jasperPath + "/ws.jpg";
                // pm.put("logo", logo);
                JasperReport jr = JasperCompileManager.compileReport(jasperPath + "\\" + rpt);
                JasperPrint jp = JasperFillManager.fillReport(jr, pm, beanCollectionDataSource);

                // Create the output stream
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

                // Export the report to Excel (XLS) and write it to the output stream
                JRXlsxExporter exporter = new JRXlsxExporter();
                exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jp);
                exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, outputStream);
                exporter.setParameter(JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                exporter.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
                exporter.setParameter(JRXlsAbstractExporterParameter.IS_COLLAPSE_ROW_SPAN, Boolean.TRUE);
                exporter.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.TRUE);
                exporter.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
                exporter.exportReport();

                // Create an InputStream from the ByteArrayOutputStream
                excelInputStream = new ByteArrayInputStream(outputStream.toByteArray());

                outputStream.flush();
                outputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "SUCCESS";
    }


    public String getListTrips(){
       tripsList = TripsDao.getTrips();
        mHistoric = HistoryDao.getHistorys();
        return SUCCESS;
    }
    public String saveTrip(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String createdDate = formatter.format(pickUpDate);
        String theEndDate = formatter.format(endDate);
        String rrdate = formatter.format(rdate);

        Reservation reservation = trips.getReservation();
        reservation.setDate(rrdate);
        ReservationDao.saveReservation(reservation);

        trips.setPickUpDate(createdDate);
        trips.setEndDate(theEndDate);


        TripsDao.saveTrips(trips);
        history = new History();
        history.setNow(LocalDate.now());
        history.setHistories(addHistories());
        HistoryDao.saveHistory(history);
        return SUCCESS;

    }

    public String saveAnotherTrip(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String createdDate = formatter.format(pickUpDate);
        String theEndDate = formatter.format(endDate);


//        Reservation reservation = trips.getReservation();
//
//       ReservationDao.saveReservation(reservation);

        trips.setPickUpDate(createdDate);
        trips.setEndDate(theEndDate);


        TripsDao.saveTrips(trips);
        history = new History();
        history.setNow(LocalDate.now());
        history.setHistories("Added a New Trip under reservation number :" + trips.getReservation().getId() );
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


        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String createdDate = formatter.format(pickUpDate);
        String theEndDate = formatter.format(endDate);

      //  reservation1.setName(theName);

        trips1.setPickUpDate(createdDate);
        trips1.setEndDate(theEndDate);
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
       // ReservationDao.saveReservation(reservation1);
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

        if (!(trips1.getDeparture().equals(trips.getDeparture()))) {

            tracker +=  "Changed Departure to " + trips1.getDeparture();
        }

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

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getRdate() {
        return rdate;
    }

    public void setRdate(Date rdate) {
        this.rdate = rdate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTheName() {
        return theName;
    }

    public void setTheName(String theName) {
        this.theName = theName;
    }

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }

    public InputStream getFileInputStream() {
        return fileInputStream;
    }

    public void setFileInputStream(InputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }

    public String getJasperPath() {
        return jasperPath;
    }

    public void setJasperPath(String jasperPath) {
        this.jasperPath = jasperPath;
    }

    public String getPdfName() {
        return pdfName;
    }

    public void setPdfName(String pdfName) {
        this.pdfName = pdfName;
    }

    public String getRpt() {
        return rpt;
    }

    public void setRpt(String rpt) {
        this.rpt = rpt;
    }
}
