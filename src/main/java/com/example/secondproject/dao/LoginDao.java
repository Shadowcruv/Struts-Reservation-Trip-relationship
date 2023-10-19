package com.example.secondproject.dao;

import com.example.secondproject.model.Login;
import com.example.secondproject.model.Reservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class LoginDao {

    public static Login getLoginByUsernameAndPassword(String username, String password) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            String sqlQuery = "SELECT * FROM login WHERE username = :username AND password = :password";
            NativeQuery<Login> query = session.createNativeQuery(sqlQuery)
                    .addEntity(Login.class)
                    .setParameter("username", username)
                    .setParameter("password", password);

            Login login = query.uniqueResult();

            transaction.commit();
            return login;
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }



}
