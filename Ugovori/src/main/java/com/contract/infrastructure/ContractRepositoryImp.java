package com.contract.infrastructure;

import com.contract.domain.entity.Company;
import com.contract.domain.entity.Contract;
import com.contract.domain.entity.Person;
import com.contract.domain.repository.ContractRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.math.BigDecimal;

public class ContractRepositoryImp implements ContractRepository {

    private final SessionFactory sf;

    public ContractRepositoryImp(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public void addContract(Long duration, BigDecimal salary, Company company, Person person) {
        Transaction tx = null;
        try(Session session = this.sf.openSession()){
            tx = session.beginTransaction();
            session.persist(new Contract(duration, salary, company, person));
            tx.commit();
        }catch (HibernateException e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            e.printStackTrace();
        }

    }
}
