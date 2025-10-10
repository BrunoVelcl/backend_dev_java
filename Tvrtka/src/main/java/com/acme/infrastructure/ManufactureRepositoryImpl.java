package com.acme.infrastructure;

import com.acme.domain.entity.Manufacturer;
import com.acme.domain.repository.ManufacturerRepository;
import com.acme.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ManufactureRepositoryImpl implements ManufacturerRepository {
    private final EntityManagerFactory emf;

    public ManufactureRepositoryImpl() {
        this.emf = JPAUtil.getEntityManagerFactory();
    }

    @Override
    public Manufacturer registerNew(Manufacturer manufacturer) {
        Manufacturer rv = null;
        EntityTransaction tx = null;
        try(EntityManager em = this.emf.createEntityManager()){
            tx = em.getTransaction();
            tx.begin();
            rv = em.merge(manufacturer);
            tx.commit();
        }catch (Exception e){
            if(tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return rv;
    }

}
