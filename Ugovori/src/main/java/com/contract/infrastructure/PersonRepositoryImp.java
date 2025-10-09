package com.contract.infrastructure;

import com.contract.domain.entity.Company;
import com.contract.domain.entity.Person;
import com.contract.domain.repository.PersonRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PersonRepositoryImp implements PersonRepository {
    private final SessionFactory sf;

    public PersonRepositoryImp(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public void add(String fullName) {
        Transaction tx = null;
        try(Session session = this.sf.openSession()){
            tx = session.beginTransaction();
            session.persist(new Person(fullName));
            tx.commit();
        }catch (HibernateException e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public Person getById(Long id) {
        Transaction tx = null;
        Person result = null;
        try(Session session = this.sf.openSession()){
            tx = session.beginTransaction();
            result = session
                    .createQuery("FROM Person WHERE IdPerson = :id", Person.class)
                    .setParameter("id", id)
                    .getSingleResult();
            tx.commit();
        }catch (HibernateException e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            e.printStackTrace();
        }
        return result;
    }
}
