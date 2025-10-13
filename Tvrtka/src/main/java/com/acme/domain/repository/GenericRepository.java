package com.acme.domain.repository;

import com.acme.domain.entity.SuperEntity;

public interface GenericRepository {
    public <T extends SuperEntity> T registerNew(T entity);
    public <T extends SuperEntity> T update(T entity);
    public <T extends SuperEntity> boolean delete(T entity);
    public <T extends SuperEntity> T findById(Class<T> tClass, long id);

}
