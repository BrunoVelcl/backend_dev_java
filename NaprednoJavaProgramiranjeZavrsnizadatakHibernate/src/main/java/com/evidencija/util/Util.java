package com.evidencija.util;

import com.evidencija.domain.repository.GenericRepository;
import com.evidencija.infrastructure.GenericRepositoryImpl;
import org.hibernate.ResourceClosedException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;


public class Util {
    private static final SessionFactory sf;
    public static final Scanner scanner;
    public static final StringBuilder sb;
    public static final GenericRepository gr;

    static {
        try {
            sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            sb = new StringBuilder();
            scanner = new Scanner(System.in);
            gr =  new GenericRepositoryImpl();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sf;
    }

    public static void closeSessionFactory() throws ResourceClosedException {
        if (sf.isOpen()) {
            sf.close();
            return;
        }
        throw new ResourceClosedException("Session Factory already closed.");
    }

    public static boolean containsOnlyNumbers(String string){
        for(char c : string.toCharArray()){
            if(!Character.isDigit(c))return false;
        }
        return true;
    }
}

