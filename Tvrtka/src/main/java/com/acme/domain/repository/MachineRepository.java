package com.acme.domain.repository;

import com.acme.domain.entity.Machine;
import com.acme.domain.entity.Manufacturer;

public interface MachineRepository {
    public Machine registerNewMachine(Machine machine);

}
