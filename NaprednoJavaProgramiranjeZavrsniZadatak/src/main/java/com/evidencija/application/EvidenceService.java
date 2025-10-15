package com.evidencija.application;

public class EvidenceService {
    public void run(){
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
                    return;
                }

            }
        }
    }
}
