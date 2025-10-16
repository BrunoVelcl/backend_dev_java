package com.evidencija.application;

import com.evidencija.domain.entity.Program;
import com.evidencija.domain.entity.Student;
import com.evidencija.domain.repository.GenericRepository;
import com.evidencija.infrastructure.GenericRepositoryImpl;
import com.evidencija.util.Util;

public class EvidencijaPolaznikaService {
    public void run(){
        Util.getSessionFactory(); //Ensures Util loads before the CLI, without this the cli will load before Hibernate info dump

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
                case NEW_STUDENT -> UI.promptStudent();
                case NEW_PROGRAM -> UI.promptProgram();
                case REGISTER_STUDENT -> UI.promptRegistration();
                case MOVE_STUDENT -> UI.promptMove();
                case PRINT_ENROLLED -> UI.promptPrintEnrolled();
                case QUIT -> {
                    Util.closeSessionFactory();
                    return;
                }

            }
        }


    }
}
