package com.contract.application;

import com.contract.domain.entity.Company;
import com.contract.infrastructure.CompanyRepositoryImp;
import com.contract.infrastructure.ContractRepositoryImp;
import com.contract.infrastructure.PersonRepositoryImp;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;

public class ContractService {
    public void run(){
        try(SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();){
            ContractRepositoryImp cr = new ContractRepositoryImp(sf);
            CompanyRepositoryImp comp = new CompanyRepositoryImp(sf);
            PersonRepositoryImp pers = new PersonRepositoryImp(sf);
//            comp.add("Fog Sellers ltd");
//            comp.add("ACME corp");
//            comp.add("Cyberdine");
//            comp.add("Weiland-Utany");
//            pers.add("Pero Peric");
//            pers.add("Zdeno Djuric");
//            pers.add("Marko Markanovic");
            cr.addContract(365L, BigDecimal.valueOf(1500), comp.getById(2L), pers.getById(1L) );
            cr.addContract(60L, BigDecimal.valueOf(1200), comp.getById(1L), pers.getById(2L) );
            cr.addContract(5000L, BigDecimal.valueOf(800), comp.getById(3L), pers.getById(3L) );
        }catch (HibernateException e){
            e.printStackTrace();
        }

    }
}
