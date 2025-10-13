package com.acme.application;

import com.acme.domain.entity.*;
import com.acme.domain.repository.*;
import com.acme.infrastructure.*;
import org.hibernate.Hibernate;

import java.math.BigDecimal;
import java.util.Date;

public class Runner {
    public void run() {

        GenericRepository gr = new GenericRepositoryImpl();

        //Salary
        gr.registerNew(new Salary(GreekAlphabet.ALPHA, BigDecimal.valueOf(850)));
        gr.registerNew(new Salary(GreekAlphabet.BETA, BigDecimal.valueOf(970)));
        gr.registerNew(new Salary(GreekAlphabet.GAMMA, BigDecimal.valueOf(1100)));
        gr.registerNew(new Salary(GreekAlphabet.DELTA, BigDecimal.valueOf(1220)));
        gr.registerNew(new Salary(GreekAlphabet.EPSILON, BigDecimal.valueOf(1350)));
        gr.registerNew(new Salary(GreekAlphabet.ZETA, BigDecimal.valueOf(1500)));
        gr.registerNew(new Salary(GreekAlphabet.ETA, BigDecimal.valueOf(1750)));
        gr.registerNew(new Salary(GreekAlphabet.THETA, BigDecimal.valueOf(2000)));
        gr.registerNew(new Salary(GreekAlphabet.IOTA, BigDecimal.valueOf(2500)));
        gr.registerNew(new Salary(GreekAlphabet.KAPPA, BigDecimal.valueOf(3000)));
        gr.registerNew(new Salary(GreekAlphabet.LAMBDA, BigDecimal.valueOf(4500)));

        //Countries
        var austria = gr.registerNew(new Country("Austria", "AT"));
        var croatia = gr.registerNew(new Country("Croatia", "HR"));
        var usa = gr.registerNew(new Country("United States of America", "CR"));
        var japan = gr.registerNew(new Country("Japan", "JP"));

        //Cities
        gr.registerNew(new City("Zagreb", croatia));
        gr.registerNew(new City("Split", croatia));
        gr.registerNew(new City("Osijek", croatia));
        gr.registerNew(new City("Rijeka", croatia));
        gr.registerNew(new City("Sisak", croatia));
        gr.registerNew(new City("Bjelovar", croatia));
        gr.registerNew(new City("Kutina", croatia));
        gr.registerNew(new City("Šibenik", croatia));
        gr.registerNew(new City("Dubrovnik", croatia));
        gr.registerNew(new City("Pula", croatia));
        gr.registerNew(new City("Slavonski Brod", croatia));
        gr.registerNew(new City("Varaždin", croatia));

        gr.registerNew(new City("Vienna", austria));
        gr.registerNew(new City("Graz", austria));
        gr.registerNew(new City("Linz", austria));
        gr.registerNew(new City("Salzburg", austria));
        var thal = gr.registerNew(new City("Thal", austria));

        gr.registerNew(new City("New York", usa));
        gr.registerNew(new City("Washington DC", usa));
        gr.registerNew(new City("Boston", usa));
        var det = gr.registerNew(new City("Detroit", usa));
        gr.registerNew(new City("Chicago", usa));
        gr.registerNew(new City("New Mexico", usa));
        gr.registerNew(new City("New York", usa));
        gr.registerNew(new City("Los Angeles", usa));
        gr.registerNew(new City("Houston", usa));
        gr.registerNew(new City("Philadelphia", usa));

        gr.registerNew(new City("Tokyo", japan));
        gr.registerNew(new City("Yokohama", japan));
        gr.registerNew(new City("Osaka", japan));



        //Manufacturers
        var emi = gr.registerNew(new Manufacturer("Electronic Machines Incorporated", "EMI", "541258654", usa));
        var cdine = gr.registerNew(new Manufacturer("Cyberdine Systems", "CS", "456128624", usa));
        var zony = gr.registerNew(new Manufacturer("Zony Corporation", "Zony", "45464555", japan));
        var magla = gr.registerNew(new Manufacturer("Magla d.o.o.", "MAGLA", "48745454534", croatia));

        //Machines
        gr.registerNew(new Machine("T-800", cdine, 154547888L, (short) 2026));


        //Departments
        var ip = gr.registerNew(new Department("Incoming Processing", "IP"));
        var qa = gr.registerNew(new Department("Quality Assurance", "QA"));
        var prod = gr.registerNew(new Department("Production", "PROD"));
        var pack = gr.registerNew(new Department("Packaging and shipping", "PACK"));
        gr.registerNew(new Department("Human Resources", "HR"));
        gr.registerNew(new Department("Accounting", "ACC"));
        gr.registerNew(new Department("Information Technology", "IT"));
        gr.registerNew(new Department("Management", "MAN"));
        gr.registerNew(new Department("Maintenance", "MEIN"));
        gr.registerNew(new Department("CLeaning", "CLN"));
        var sec = gr.registerNew(new Department("Security", "SEC"));

        //Process Steps
        gr.registerNew(new ProcessStep("Unpacking of incoming material", "UIM", ip));
        gr.registerNew(new ProcessStep("Entry point weight measurement", "EPWM", ip));
        gr.registerNew(new ProcessStep("Visual inspection of incoming material", "VIIM", ip));
        gr.registerNew(new ProcessStep("Storing of incoming material", "SIM", ip));
        gr.registerNew(new ProcessStep("Material preprocessing", "MPP", prod));
        gr.registerNew(new ProcessStep("Material cleaning", "MC", prod));
        var assembly = gr.registerNew(new ProcessStep("Material assembly", "MA", prod));
        gr.registerNew(new ProcessStep("Aging", "AG", prod));
        gr.registerNew(new ProcessStep("Functionality testing", "FT", qa));
        gr.registerNew(new ProcessStep("Product classification", "PC", qa));
        gr.registerNew(new ProcessStep("Visual inspection of product", "VIP", qa));
        gr.registerNew(new ProcessStep("Automatic packaging", "AP", pack));
        gr.registerNew(new ProcessStep("Random sample testing", "RST", pack));
        gr.registerNew(new ProcessStep("Exit point weight measurement", "EXWM", pack));


        //Workers
        var ahnold = gr.registerNew(new Worker("Arnold", "Schwarzenegger",  "51315341646", java.sql.Date.valueOf("1947-7-30"), Worker.Gender.MALE));
        ahnold.setCityOfBirth(thal);
        ahnold.setMiddleName("Alois");
        ahnold.setFatherFirstname("Gustav");
        ahnold.setFatherLastname("Schwarzenegger");
        ahnold.setDepartment(sec);
        ahnold.setEmail("getToDaChopa@cyberdine.com");
        gr.update(ahnold);

        var quaid = gr.registerNew(new Worker("Douglas", "Quaid", "64616541", java.sql.Date.valueOf("2007-11-21"), Worker.Gender.MALE));
        quaid.setCityOfBirth(det);
        quaid.setWorkplace(assembly);
        quaid.setEmail("d.quaid@rekall.mars");
        quaid.setPhoneNumber(164610464L);
        gr.update(quaid);

    }
}
