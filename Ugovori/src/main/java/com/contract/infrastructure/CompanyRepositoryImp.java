package com.contract.infrastructure;

import com.contract.domain.entity.Company;
import com.contract.domain.repository.CompanyRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CompanyRepositoryImp implements CompanyRepository {
    private final SessionFactory sf;

    public CompanyRepositoryImp(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public void add(String companyName) {
        Transaction tx = null;
        try(Session session = this.sf.openSession()){
            tx = session.beginTransaction();
            session.persist(new Company(companyName));
            tx.commit();
        }catch (HibernateException e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Company getById(Long id) {
        Transaction tx = null;
        Company result = null;
        try(Session session = this.sf.openSession()){
            tx = session.beginTransaction();
            result = session
                    .createQuery("FROM Company WHERE IdCompany = :id", Company.class)
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
