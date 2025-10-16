package com.evidencija.infrastructure;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.evidencija.domain.entity.SuperEntity;
import com.evidencija.domain.repository.GenericRepository;
import com.evidencija.util.Util;

import java.util.List;

public class GenericRepositoryImpl implements GenericRepository {
    SessionFactory sf;

    public GenericRepositoryImpl() {
        this.sf = Util.getSessionFactory();
    }

    @Override
    public <T extends SuperEntity> T addOrUpdate(T entity) {
        T rv = null;
        Transaction tx = null;
        try(Session session = sf.openSession()){
            tx = session.beginTransaction();
            rv = session.merge(entity);
            tx.commit();
        }catch (HibernateException e){
            if(tx != null && tx.isActive()) {
                tx.rollback();
            }
            System.out.println(e.getMessage());
        }
        return rv;
    }

    @Override
    public <T extends SuperEntity> T findByID(Class<T> tClass, int id){
        T rv = null;
        Transaction tx = null;
        try(Session session = sf.openSession()){
            tx = session.beginTransaction();
            rv = session.find(tClass, id);
            tx.commit();
        }catch (HibernateException e){
            if(tx != null && tx.isActive()) {
                tx.rollback();
            }
            System.out.println(e.getMessage());
        }
        return rv;
    }

    @Override
    public <T extends SuperEntity> List<T> findByTableAndColumn(String table, String column, String searchTerm) {
        List<T> rv = null;
        Transaction tx = null;
        String operator;
        String parameter;
        if(Util.containsOnlyNumbers(searchTerm)){
            operator = "=";
            parameter = searchTerm;
        }
        else {
            operator = "LIKE";
            parameter = "%" + searchTerm + "%";
        }
        String query = String.format("FROM %s WHERE %s %s :searchTerm", table, column, operator);
        try(Session session = sf.openSession()){
            tx = session.beginTransaction();
            rv = session.createQuery(query).setParameter("searchTerm",  parameter).getResultList();
            tx.commit();
        }catch (HibernateException e){
            if(tx != null && tx.isActive()) {
                tx.rollback();
            }
            System.out.println(e.getMessage());
        }
        return rv;
    }
}
