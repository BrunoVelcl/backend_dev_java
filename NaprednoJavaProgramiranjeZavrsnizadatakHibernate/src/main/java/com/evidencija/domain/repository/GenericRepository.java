package com.evidencija.domain.repository;

import com.evidencija.domain.entity.SuperEntity;

public interface GenericRepository {
    public <T extends SuperEntity> T addOrUpdate(T entity);
    public <T extends SuperEntity> T findByID(Class<T> tClass, int id);
}
