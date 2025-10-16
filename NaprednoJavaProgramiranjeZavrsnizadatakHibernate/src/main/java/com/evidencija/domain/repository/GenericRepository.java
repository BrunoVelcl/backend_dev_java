package com.evidencija.domain.repository;

import com.evidencija.domain.entity.SuperEntity;

import java.util.List;

public interface GenericRepository {
    public <T extends SuperEntity> T addOrUpdate(T entity);
    public <T extends SuperEntity> T findByID(Class<T> tClass, int id);
    public <T extends SuperEntity> List<T> findByTableAndColumn(String table, String column, String searchTerm);
}
