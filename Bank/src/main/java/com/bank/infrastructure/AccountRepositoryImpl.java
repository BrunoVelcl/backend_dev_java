package com.bank.infrastructure;

import com.bank.domain.entity.Account;
import com.bank.domain.repository.AccountRepository;
import com.bank.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;


import java.math.BigDecimal;


public class AccountRepositoryImpl implements AccountRepository {
    private EntityManagerFactory emf;

    public AccountRepositoryImpl() {
        this.emf = JPAUtil.getEntityManagerFactory();
    }

    @Override
    public void otvoriRacun(String korisnickoIme, BigDecimal pocetniIznos) {
        EntityTransaction tx = null;
        try (EntityManager em = emf.createEntityManager()) {
            tx = em.getTransaction();
            tx.begin();
            em.persist(new Account(korisnickoIme, pocetniIznos));
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public void prenesiSredstva(Account posiljatelj, Account primatelj, BigDecimal iznos) {
        EntityTransaction tx = null;
        try (EntityManager em = emf.createEntityManager()) {
            tx = em.getTransaction();
            tx.begin();
            if (posiljatelj.getBalance().compareTo(iznos) > 0) {
                posiljatelj.setBalance(posiljatelj.getBalance().subtract(iznos));
                em.merge(posiljatelj);
                primatelj.setBalance(primatelj.getBalance().add(iznos));
                em.merge(primatelj);
                tx.commit();
            } else {
                tx.rollback();
                System.out.println("Nedovoljno sredstava na racunu!");
            }

        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public BigDecimal provjeriStanje(long id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Account.class, id).getBalance();
        }
    }

    @Override
    public Account nadjiPoIdu(long id) {
        try(EntityManager em = emf.createEntityManager()){
            return em.find(Account.class, id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
