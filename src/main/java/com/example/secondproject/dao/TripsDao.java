package com.example.secondproject.dao;

import com.example.secondproject.model.Trips;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class TripsDao {

    public static List<Trips> getTrips() {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            String hql = "FROM Trips";
            Query<Trips> query = session.createQuery(hql, Trips.class);
            List<Trips> trips = query.list();

            transaction.commit();
            return trips;
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static Trips getTripsById(int tripId) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Trips trip = session.get(Trips.class, tripId);

            transaction.commit();
            return trip;
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static int saveTrips(Trips trip) {
        Session session = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .openSession();

        Transaction t = session.beginTransaction();
        int i = (Integer) session.save(trip);
        t.commit();
        session.close();

        return i;
    }

    public static void updateTrips(Trips updatedTrip) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.merge(updatedTrip);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static void deleteTrips(int tripId) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Trips trip = session.get(Trips.class, tripId);

            if (trip != null) {
                session.delete(trip);
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
