package com.BookLib.infrastructure;

import org.hibernate.*;

import com.BookLib.domain.entity.SuperEntity;
import com.BookLib.domain.repository.GenericRepository;
import com.BookLib.util.HibernateUtil;

public class GenericRepositoryImpl implements GenericRepository {
    private final SessionFactory sf;

    public GenericRepositoryImpl() {
        this.sf = HibernateUtil.getSessionFactory();
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
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            e.printStackTrace();
        }
        return rv;
    }
}
