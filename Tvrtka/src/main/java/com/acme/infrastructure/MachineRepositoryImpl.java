package com.acme.infrastructure;

import com.acme.domain.entity.Machine;
import com.acme.domain.repository.MachineRepository;
import com.acme.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MachineRepositoryImpl implements MachineRepository {
    EntityManagerFactory emf;

    public MachineRepositoryImpl() {
        this.emf = JPAUtil.getEntityManagerFactory();
    }

    @Override
    public Machine registerNewMachine(Machine machine) {
        Machine rv = null;
        EntityTransaction tx = null;
        try(EntityManager em = this.emf.createEntityManager()){
            tx = em.getTransaction();
            tx.begin();
            rv = em.merge(machine);
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
