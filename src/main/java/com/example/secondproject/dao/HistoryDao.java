package com.example.secondproject.dao;

import com.example.secondproject.model.History;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HistoryDao {

    public static List<History> getHistorys() {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            String sqlQuery = "SELECT * FROM History";
            List<History> Historys = session.createNativeQuery(sqlQuery, History.class).list();

            transaction.commit();
            return Historys;
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static int saveHistory(History History){
        Session session=new Configuration().
                configure("hibernate.cfg.xml").buildSessionFactory().openSession();

        Transaction t=session.beginTransaction();
        int i=(Integer)session.save(History);
        t.commit();
        session.close();

        return i;
    }
}
