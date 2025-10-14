package com.BookLib.domain.repository;

import com.BookLib.domain.entity.SuperEntity;

public interface GenericRepository {
    public <T extends SuperEntity> T addOrUpdate(T entity);
}
