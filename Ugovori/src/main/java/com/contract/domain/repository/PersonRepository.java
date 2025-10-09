package com.contract.domain.repository;

import com.contract.domain.entity.Person;

public interface PersonRepository {
    public void add(String fullName);
    public Person getById(Long id);
}
