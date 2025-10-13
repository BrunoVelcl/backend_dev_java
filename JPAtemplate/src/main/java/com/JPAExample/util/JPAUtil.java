package com.JPAExample.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.ResourceClosedException;

public class JPAUtil {
    private static final EntityManagerFactory emf;

    static {
        try{
            emf = Persistence.createEntityManagerFactory("JPAExample");
        }catch (Throwable e){
            throw new ExceptionInInitializerError(e);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }

    public static void closeEntityManagerFactory() throws ResourceClosedException {
        if(emf.isOpen()){
            emf.close();
            return;
        }
        throw new ResourceClosedException("Entity Manager Factory Already Closed");
    }
}
