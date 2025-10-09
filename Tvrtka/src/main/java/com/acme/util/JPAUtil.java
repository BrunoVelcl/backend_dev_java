package com.acme.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class JPAUtil {
    private static final EntityManagerFactory sf;

    static {
        try{
            sf = Persistence.createEntityManagerFactory("ACME");
        }catch (Throwable ex){
            throw new ExceptionInInitializerError(ex);
        }
    }


    public static EntityManagerFactory getEntityManagerFactory() {
        return sf;
    }

    public static void close() {
        sf.close();
    }

}
