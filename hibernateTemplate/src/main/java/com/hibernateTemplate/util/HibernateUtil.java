package com.hibernateTemplate.util;

import org.hibernate.ResourceClosedException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sf;

    static {
        try{
            sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory(){
        return sf;
    }

    public static void closeSessionFactory() throws ResourceClosedException {
        if(sf.isOpen()) {
            sf.close();
            return;
        }
        throw new ResourceClosedException("Session Factory already closed.");
    }
}
