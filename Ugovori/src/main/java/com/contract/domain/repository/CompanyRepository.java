package com.contract.domain.repository;

import com.contract.domain.entity.Company;

public interface CompanyRepository {
    public void add(String companyName);
    public Company getById(Long id);
}
