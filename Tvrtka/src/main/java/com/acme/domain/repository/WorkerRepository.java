package com.acme.domain.repository;

import com.acme.domain.entity.Worker;

public interface WorkerRepository {
    public Worker registerNew(Worker worker);
    public Worker update(Worker worker);
}
