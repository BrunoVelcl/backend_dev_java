package com.evidencija.application;

import com.evidencija.domain.entity.Program;
import com.evidencija.domain.entity.Student;
import com.evidencija.domain.repository.GenericRepository;
import com.evidencija.infrastructure.GenericRepositoryImpl;
import com.evidencija.util.Util;

public class EvidencijaPolaznikaService {
    public void run(){

        GenericRepository gr = new GenericRepositoryImpl();

//        var pero = new Student("Pero", "Kvrzica");
//        var c = new Program("c", 50);
//
//        gr.addOrUpdate(pero);
//        gr.addOrUpdate(c);
//
//        c.addStudent(pero);
//        gr.addOrUpdate(c);

//


        while(true){
            String mainSelection = UI.getMainMenuSelection();
            if(mainSelection.isBlank()) continue;
            MainMenu selection;
            try{
                selection = MainMenu.getFromChar(mainSelection.charAt(0));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            switch (selection){
                case NEW_STUDENT -> UI.promptStudent(gr);
                case NEW_PROGRAM -> UI.promptProgram(gr);
                case REGISTER_STUDENT -> UI.promptRegistration(gr);
                case MOVE_STUDENT -> UI.promptMove(gr);
                //case PRINT_ENROLLED -> UI.promptPrintEnrolled();
                case QUIT -> {
                    Util.closeSessionFactory();
                    return;
                }

            }
        }


    }
}
