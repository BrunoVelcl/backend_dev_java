package com.contract.domain.repository;

import com.contract.domain.entity.Company;
import com.contract.domain.entity.Contract;
import com.contract.domain.entity.Person;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;

public interface ContractRepository {


    public void addContract(Long duration, BigDecimal salary, Company company, Person person);
}
