package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        // Create SessionFactory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // Open Session
        Session session = sessionFactory.openSession();

        // Begin Transaction
        Transaction transaction = session.beginTransaction();

        // Insert Device
        Device device = new Device();
        device.setBrand("Generic Brand");
        device.setModel("Model D1");
        device.setPrice(100.0);
        session.save(device);

        // Insert Smartphone
        Smartphone smartphone = new Smartphone();
        smartphone.setBrand("Apple");
        smartphone.setModel("iPhone 14");
        smartphone.setPrice(999.99);
        smartphone.setOperatingSystem("iOS");
        smartphone.setCameraResolution(12);
        session.save(smartphone);

        // Insert Tablet
        Tablet tablet = new Tablet();
        tablet.setBrand("Samsung");
        tablet.setModel("Galaxy Tab S8");
        tablet.setPrice(699.99);
        tablet.setScreenSize(11.0);
        tablet.setBatteryLife(12);
        session.save(tablet);

        // Commit Transaction
        transaction.commit();

        // Close Session and Factory
        session.close();
        sessionFactory.close();

        System.out.println("Records inserted successfully.");
    }
}
