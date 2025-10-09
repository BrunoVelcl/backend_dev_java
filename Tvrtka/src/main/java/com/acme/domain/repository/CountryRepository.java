package com.acme.domain.repository;

import com.acme.domain.entity.Country;

public interface CountryRepository {
    public Country registerNew(Country country);
}
