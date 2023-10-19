package com.example.secondproject.dao;

import com.example.secondproject.model.Reservation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class ReservationDao {

    public static List<Reservation> getReservations() {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            String sqlQuery = "SELECT * FROM reservation";
            List<Reservation> reservations = session.createNativeQuery(sqlQuery, Reservation.class).list();

            transaction.commit();
            return reservations;
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }


    public static Reservation getReservationById(int reservationId) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            // Load the Reservation object by its primary key (ID)
            Reservation reservation = session.get(Reservation.class, reservationId);

            transaction.commit();
            return reservation;
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static int saveReservation(Reservation reservation){
        Session session=new Configuration().
                configure("hibernate.cfg.xml").buildSessionFactory().openSession();

        Transaction t=session.beginTransaction();
        int i=(Integer)session.save(reservation);
        t.commit();
        session.close();

        return i;
    }

    public static void updateReservation(Reservation updatedReservation) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            // Merge the updatedReservation object into the current session to update it
            session.merge(updatedReservation);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static void deleteReservation(int reservationId) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            // Load the Reservation object by its primary key (ID)
            Reservation reservation = session.get(Reservation.class, reservationId);

            if (reservation != null) {
                // Delete the Reservation object from the database
                session.delete(reservation);
            }

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }



}
