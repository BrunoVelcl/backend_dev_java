package com.evidencija.infrastructure;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.evidencija.domain.entity.SuperEntity;
import com.evidencija.domain.repository.GenericRepository;
import com.evidencija.util.Util;

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
            tx.rollback();
            e.printStackTrace();
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
            tx.rollback();
            e.printStackTrace();
        }
        return rv;
    }



}
