package com.acme.application;

import com.acme.domain.entity.*;
import com.acme.domain.repository.*;
import com.acme.infrastructure.*;

import java.util.Date;

public class Runner {
    public void run(){

//        CountryRepository countryRepository = new CountryRepositoryImpl();
//        var austria = countryRepository.registerNew(new Country("Austria", "AT"));
//        var croatia = countryRepository.registerNew(new Country("Croatia", "HR"));
//        var usa = countryRepository.registerNew(new Country("United States of America", "CR"));
//        var japan = countryRepository.registerNew(new Country("Japan", "JP"));
//
//        CityRepository cityRepository = new CityRepositoryImpl();
//        cityRepository.registerNew(new City("Zagreb", croatia));
//        cityRepository.registerNew(new City("Split", croatia));
//        cityRepository.registerNew(new City("Osijek", croatia));
//        cityRepository.registerNew(new City("Rijeka", croatia));
//        cityRepository.registerNew(new City("Sisak", croatia));
//        cityRepository.registerNew(new City("Bjelovar", croatia));
//        cityRepository.registerNew(new City("Kutina", croatia));
//        cityRepository.registerNew(new City("Šibenik", croatia));
//        cityRepository.registerNew(new City("Dubrovnik", croatia));
//        cityRepository.registerNew(new City("Pula", croatia));
//        cityRepository.registerNew(new City("Slavonski Brod", croatia));
//        cityRepository.registerNew(new City("Varaždin", croatia));
//
//        cityRepository.registerNew(new City("Vienna", austria));
//        cityRepository.registerNew(new City("Graz", austria));
//        cityRepository.registerNew(new City("Linz", austria));
//        cityRepository.registerNew(new City("Salzburg", austria));
//        var thal = cityRepository.registerNew(new City("Thal", austria));
//
//        cityRepository.registerNew(new City("New York", usa));
//        cityRepository.registerNew(new City("Washington DC", usa));
//        cityRepository.registerNew(new City("Boston", usa));
//        cityRepository.registerNew(new City("Detroit", usa));
//        cityRepository.registerNew(new City("Chicago", usa));
//        cityRepository.registerNew(new City("New Mexico", usa));
//        cityRepository.registerNew(new City("New York", usa));
//        cityRepository.registerNew(new City("Los Angeles", usa));
//        cityRepository.registerNew(new City("Houston", usa));
//        cityRepository.registerNew(new City("Philadelphia", usa));
//
//        cityRepository.registerNew(new City("Tokyo", japan));
//        cityRepository.registerNew(new City("Yokohama", japan));
//        cityRepository.registerNew(new City("Osaka", japan));
//
//
//
//        ManufacturerRepository manr = new ManufactureRepositoryImpl();
//        var emi = manr.registerNew(new Manufacturer("Electronic Machines Incorporated", "EMI", "541258654", usa));
//        var cdine = manr.registerNew(new Manufacturer("Cyberdine Systems", "CS", "456128624", usa));
//        var zony = manr.registerNew(new Manufacturer("Zony Corporation", "Zony", "45464555", japan));
//        var magla = manr.registerNew(new Manufacturer("Magla d.o.o.", "MAGLA", "48745454534", croatia));
//
//        MachineRepository mr = new MachineRepositoryImpl();
//        mr.registerNewMachine(new Machine("T-800", cdine, 154547888L, (short) 2026));
//
//
//
//        WorkerRepository workerRepository = new WorkerRepositoryImpl();
//        var ahnold = workerRepository.registerNew(new Worker("Arnold", "Schwarzenegger",  "51315341646", java.sql.Date.valueOf("1947-7-30"), Worker.Gender.MALE));
//        ahnold.setCityOfBirth(thal);
//        ahnold.setCountryOfBirth(thal.getCountry());
//        ahnold.setMiddleName("Alois");
//        workerRepository.update(ahnold);

        ProcessStepRepository psr = new ProcessStepRepositoryImpl();
        psr.registerNew(new ProcessStep("Unpacking of incoming material", "UIM"));
        psr.registerNew(new ProcessStep("Entry point weight measurement", "EPWM"));
        psr.registerNew(new ProcessStep("Visual inspection of incoming material", "VIIM"));
        psr.registerNew(new ProcessStep("Storing of incoming material", "SIM"));
        psr.registerNew(new ProcessStep("Material preprocessing", "MPP"));
        psr.registerNew(new ProcessStep("Material cleaning", "MC"));
        psr.registerNew(new ProcessStep("Material assembly", "MA"));
        psr.registerNew(new ProcessStep("Aging", "AG"));
        psr.registerNew(new ProcessStep("Functionality testing", "FT"));
        psr.registerNew(new ProcessStep("Product classification", "PC"));
        psr.registerNew(new ProcessStep("Visual inspection of product", "VIP"));
        psr.registerNew(new ProcessStep("Automatic packaging", "AP"));
        psr.registerNew(new ProcessStep("Random sample testing", "RST"));
        psr.registerNew(new ProcessStep("Exit point weight measurement", "EXWM"));


    }
}
