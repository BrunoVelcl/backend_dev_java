package com.acme.infrastructure;

import com.acme.domain.entity.Worker;
import com.acme.domain.repository.WorkerRepository;
import com.acme.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class WorkerRepositoryImpl implements WorkerRepository {
    EntityManagerFactory emf;

    public WorkerRepositoryImpl() {
        this.emf = JPAUtil.getEntityManagerFactory();
    }

    @Override
    public Worker registerNew(Worker worker) {
        Worker rv = null;
        EntityTransaction tx = null;
        try(EntityManager em = this.emf.createEntityManager()){
            tx = em.getTransaction();
            tx.begin();
            rv = em.merge(worker);
            tx.commit();
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
                e.printStackTrace();
            }
        }
        return rv;
    }

    @Override
    public Worker update(Worker worker) {
        Worker rv = null;
        EntityTransaction tx = null;
        try(EntityManager em = this.emf.createEntityManager()){
            tx = em.getTransaction();
            tx.begin();
            Worker old = em.find(Worker.class, worker.getIdWorker());
            if(old != null){
                rv = em.merge(worker);
            }else{
                System.out.println("Worker doesn't exist.");
            }
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
