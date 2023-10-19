//package com.example.secondproject.model;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//
//public class MyServletContextListener implements ServletContextListener {
//    @Override
//    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        ServletContext context = servletContextEvent.getServletContext();
//        // Create and initialize your bean when the application starts
//        MyStartupBean myBean = new MyStartupBean();
//        myBean.init();
//        context.setAttribute("myStartupBean", myBean);
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent servletContextEvent) {
//        // Clean up or perform actions when the application is shutting down
//    }
//}
