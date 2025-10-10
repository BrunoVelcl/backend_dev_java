package com.acme.infrastructure;

import com.acme.domain.entity.ProcessStep;
import com.acme.domain.repository.ProcessStepRepository;
import com.acme.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class ProcessStepRepositoryImpl implements ProcessStepRepository {
    EntityManagerFactory emf;

    public ProcessStepRepositoryImpl() {
        this.emf = JPAUtil.getEntityManagerFactory();
    }

    @Override
    public ProcessStep registerNew(ProcessStep processStep) {
        ProcessStep rv = null;
        EntityTransaction tx = null;
        try(EntityManager em = this.emf.createEntityManager()){
            tx = em.getTransaction();
            tx.begin();
            rv = em.merge(processStep);
            tx.commit();
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            e.printStackTrace();
        }
        return rv;
    }
}
