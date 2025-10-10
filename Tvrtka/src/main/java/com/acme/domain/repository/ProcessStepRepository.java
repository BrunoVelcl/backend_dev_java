package com.acme.domain.repository;

import com.acme.domain.entity.ProcessStep;

public interface ProcessStepRepository {
    public ProcessStep registerNew(ProcessStep processStep);
}
