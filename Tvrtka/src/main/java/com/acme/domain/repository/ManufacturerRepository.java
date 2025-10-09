package com.acme.domain.repository;

import com.acme.domain.entity.Manufacturer;

public interface ManufacturerRepository {
    public Manufacturer registerNew(Manufacturer manufacturer);
}
