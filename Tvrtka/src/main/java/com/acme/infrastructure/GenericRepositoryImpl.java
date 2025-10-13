package com.acme.infrastructure;


import com.acme.domain.entity.SuperEntity;
import com.acme.domain.repository.GenericRepository;
import com.acme.util.JPAUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.hibernate.Hibernate;

public class GenericRepositoryImpl implements GenericRepository {
    EntityManagerFactory emf;

    public GenericRepositoryImpl() {
        this.emf = JPAUtil.getEntityManagerFactory();
    }

    @Override
    public <T extends SuperEntity> T registerNew(T entity) {
        T rv = null;
        EntityTransaction tx = null;
        try (EntityManager em = this.emf.createEntityManager()) {
            tx = em.getTransaction();
            tx.begin();
            rv = em.merge(entity);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return rv;
    }

    @Override
    public <T extends SuperEntity> T update(T entity) {
        T rv = null;
        EntityTransaction tx = null;
        try (EntityManager em = this.emf.createEntityManager()) {
            tx = em.getTransaction();
            tx.begin();

            T old = em.find(Hibernate.getClass(entity), entity.getId());
            if (old != null) {
                rv = em.merge(entity);
            } else {
                System.out.println("Entry doesn't exist.");
            }
            tx.commit();

        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return rv;
    }

    @Override
    public <T extends SuperEntity> boolean delete(T entity) {
        EntityTransaction tx = null;
        try(EntityManager em = this.emf.createEntityManager()){
            tx = em.getTransaction();
            tx.begin();
            T pers = em.find(Hibernate.getClass(entity), entity.getId());
            em.remove(pers);
            tx.commit();
            return true;
        }catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public <T extends SuperEntity> T findById(Class<T> tClass, long id) {
        T rv = null;
        try(EntityManager em = this.emf.createEntityManager()){
            rv = em.find(tClass, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rv;
    }
}
