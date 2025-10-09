package com.acme.application;

import com.acme.domain.entity.Country;
import com.acme.domain.entity.Machine;
import com.acme.domain.entity.Manufacturer;
import com.acme.domain.entity.Worker;
import com.acme.domain.repository.CountryRepository;
import com.acme.domain.repository.MachineRepository;
import com.acme.domain.repository.ManufacturerRepository;
import com.acme.domain.repository.WorkerRepository;
import com.acme.infrastructure.CountryRepositoryImpl;
import com.acme.infrastructure.MachineRepositoryImpl;
import com.acme.infrastructure.ManufactureRepositoryImpl;
import com.acme.infrastructure.WorkerRepositoryImpl;

import java.util.Date;

public class Runner {
    public void run(){
//        ManufacturerRepository manr = new ManufactureRepositoryImpl();
//        var emi = manr.registerNew(new Manufacturer("Electronic Machines Incorporated", "EMI", "541258654"));
//        Manufacturer cdine = manr.registerNew(new Manufacturer("Cyberdine Systems", "CS", "456128624"));
//        MachineRepository mr = new MachineRepositoryImpl();
//        mr.registerNewMachine(new Machine("T-800", cdine, 154547888L, (short) 2026));

        CountryRepository countryRepository = new CountryRepositoryImpl();
        countryRepository.registerNew(new Country("Austria", "AT"));
        countryRepository.registerNew(new Country("Croatia", "HR"));

        WorkerRepository workerRepository = new WorkerRepositoryImpl();
        workerRepository.registerNew(new Worker("Arnold", "Schwarzenegger",  "51315341646", java.sql.Date.valueOf("1947-7-30"), Worker.Gender.MALE));
    }
}
