package com.acme.infrastructure;

import com.acme.domain.entity.Country;
import com.acme.domain.repository.CountryRepository;
import com.acme.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class CountryRepositoryImpl implements CountryRepository {
    EntityManagerFactory emf;

    public CountryRepositoryImpl() {
        this.emf = JPAUtil.getEntityManagerFactory();
    }

    @Override
    public Country registerNew(Country country) {
        Country rv = null;
        EntityTransaction tx = null;
        try(EntityManager em = emf.createEntityManager()){
            tx = em.getTransaction();
            tx.begin();
            rv = em.merge(country);
            tx.commit();
        }catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            e.printStackTrace();
        }
        return rv;
    }
}
