package com.acme.infrastructure;

import com.acme.domain.entity.City;
import com.acme.domain.repository.CityRepository;
import com.acme.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class CityRepositoryImpl implements CityRepository {
    EntityManagerFactory emf;

    public CityRepositoryImpl() {
        this.emf = JPAUtil.getEntityManagerFactory();
    }

    @Override
    public City registerNew(City city) {
        City rv = null;
        EntityTransaction tx = null;
        try(EntityManager em = this.emf.createEntityManager()){
            tx = em.getTransaction();
            tx.begin();
            rv = em.merge(city);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }
        return rv;
    }
}
