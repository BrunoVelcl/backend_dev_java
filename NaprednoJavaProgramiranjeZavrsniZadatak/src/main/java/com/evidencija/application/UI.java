package com.evidencija.application;

import com.evidencija.domain.entity.Enrolled;
import com.evidencija.domain.entity.Program;
import com.evidencija.domain.entity.Student;
import com.evidencija.util.Util;

import java.util.List;

public class UI {

    public static String getMainMenuSelection() {
        System.out.println(Text.MAIN_MENU);
        return Util.scanner.nextLine().trim().toLowerCase();
    }

    private static String getRegisterStudentSelection() {
        System.out.println(Text.NEW_STUDENT_MENU);
        return Util.scanner.nextLine().trim().toLowerCase();
    }

    private static String getRegisterProgramSelection() {
        System.out.println(Text.NEW_PROGRAM_MENU);
        return Util.scanner.nextLine().trim().toLowerCase();
    }

    private static void currentlySelected(Student student, Program program) {
        if (student != null) {
            System.out.println(Text.ODABRAN_POLAZNIK
                    + student.getFirstName() + " "
                    + student.getLastName() + " "
                    + student.getId());
        }
        if (program != null) {
            System.out.println(Text.ODABRAN_PROGRAM
                    + program.getName() + " "
                    + program.getCsvet() + " "
                    + program.getId());
        }
    }

    private static void currentlySelected(Student student, Program programOut, Program programIn) {
        if (student != null) {
            System.out.println(Text.ODABRAN_POLAZNIK
                    + student.getFirstName() + " "
                    + student.getLastName() + " "
                    + student.getId());
        }
        if (programIn != null) {
            System.out.println(Text.ODABRAN_PROGRAM_ZA_UPIS
                    + programOut.getName() + " "
                    + programOut.getCsvet() + " "
                    + programOut.getId());
        }

        if (programIn != null) {
            System.out.println(Text.ODABRAN_PROGRAM_ZA_ISPIS
                    + programIn.getName() + " "
                    + programIn.getCsvet() + " "
                    + programIn.getId());
        }
    }


    private static void printStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println(Text.NOTHING_WAS_FOUND);
            return;
        }
        Util.sb.setLength(0);
        for (Student s : students) {
            Util.sb.append(s.prettyString()).append(Text.NEW_LINE);
        }
        System.out.println(Util.sb);
    }

    private static void printPrograms(List<Program> programs) {
        if (programs.isEmpty()) {
            System.out.println(Text.NOTHING_WAS_FOUND);
            return;
        }
        Util.sb.setLength(0);
        for (Program p : programs) {
            Util.sb.append(p.prettyString()).append(Text.NEW_LINE);
        }
        System.out.println(Util.sb);
    }

    private static void printEnrolled(List<Enrolled> enrolled) {
        if (enrolled.isEmpty()) {
            System.out.println(Text.NOTHING_WAS_FOUND);
            return;
        }
        Util.sb.setLength(0);
        Util.sb.append(Text.STAR_SEPARATOR).append(Text.NEW_LINE);
        for (Enrolled e : enrolled) {
            Util.sb.append(e.prettyString()).append(Text.NEW_LINE);
        }
        Util.sb.append(Text.STAR_SEPARATOR);
        System.out.println(Util.sb);
    }


    public static void promptStudent() {
        System.out.print(Text.ENTER_FIRST_NAME);
        String firstName = Util.scanner.nextLine().trim();
        System.out.print(Text.ENTER_LAST_NAME);
        String lastName = Util.scanner.nextLine().trim();
        if (DBQuery.addStudent(new Student(firstName, lastName))) {
            System.out.println(Text.ADDED_SUCCESSFULLY);
        } else {
            System.out.println(Text.ADD_FAIL);
        }
    }

    public static void promptProgram() {
        System.out.print(Text.ENTER_TITLE);
        String name = Util.scanner.nextLine().trim();
        System.out.print(Text.ENTER_POINTS);
        int csvet;
        try {
            csvet = Integer.parseInt(Util.scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println(Text.INVALID_ENTRY);
            return;
        }
        if (DBQuery.addProgram(new Program(name, csvet))) {
            System.out.println(Text.ADDED_SUCCESSFULLY);
        } else {
            System.out.println(Text.ADD_FAIL);
        }
    }

    public static Student promptID() {
        int id;
        System.out.print(Text.ENTER_ID);
        try {
            id = Integer.parseInt(Util.scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println(Text.NOT_A_NUMBER);
            return null;
        }
        return DBQuery.getStudentById(id);
    }

    private static List<Student> promptFirstName() {
        System.out.print(Text.ENTER_FIRST_NAME);
        String name = Util.scanner.nextLine().trim();
        return DBQuery.filterStudentByFirstName(name);
    }

    private static List<Student> promptLastName() {
        System.out.print(Text.ENTER_LAST_NAME);
        String name = Util.scanner.nextLine().trim();
        return DBQuery.filterStudentByLastName(name);
    }

    private static List<Program> prompProgramName() {
        System.out.print(Text.ENTER_TITLE);
        String name = Util.scanner.nextLine().trim();
        return DBQuery.filterProgramByName(name);
    }

    private static List<Program> prompProgramCSVET() {
        int csvet;
        System.out.print(Text.ENTER_POINTS);
        try {
            csvet = Integer.parseInt(Util.scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println(Text.NOT_A_NUMBER);
            return null;
        }
        return DBQuery.filterProgramByCSVET(csvet);
    }

    public static Program promptProgramID() {
        int id;
        System.out.print(Text.ENTER_ID);
        try {
            id = Integer.parseInt(Util.scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println(Text.NOT_A_NUMBER);
            return null;
        }
        return DBQuery.getProgramById(id);
    }


    public static Student selectStudent() {
        while (true) {
            String selection = getRegisterStudentSelection();
            if (selection.isBlank()) continue;
            StudentMenu enumSelection;
            try {
                enumSelection = StudentMenu.getFromChar(selection.charAt(0));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            switch (enumSelection) {
                case ID -> {
                    return promptID();
                }
                case FIRST_NAME -> {
                    List<Student> students = promptFirstName();
                    if (students.isEmpty()) return null;
                    printStudents(students);
                    return promptID();
                }
                case LAST_NAME -> {
                    List<Student> students = promptLastName();
                    if (students.isEmpty()) return null;
                    printStudents(students);
                    return promptID();
                }
                case QUIT -> {
                    return null;
                }
            }
        }
    }

    public static Program selectProgram() {
        while (true) {
            String selection = getRegisterProgramSelection();
            if (selection.isBlank()) continue;
            switch (ProgramMenu.getFromChar(selection.charAt(0))) {
                case ID -> {
                    return promptProgramID();
                }
                case NAME -> {
                    List<Program> programs = prompProgramName();
                    if (programs.isEmpty()) return null;
                    printPrograms(programs);
                    return promptProgramID();
                }
                case CSVET -> {
                    List<Program> programs = prompProgramCSVET();
                    if (programs.isEmpty()) return null;
                    printPrograms(programs);
                    return promptProgramID();
                }
                case QUIT -> {
                    return null;
                }
            }
        }
    }

    public static void promptRegistration() {
        Student student = null;
        Program program = null;
        while (true) {
            currentlySelected(student, program);
            if (student == null) {
                student = selectStudent();
                if (student == null) {
                    System.out.println(Text.NOT_FOUND_TRY_AGAIN);
                    String answer = Util.scanner.nextLine().trim().toLowerCase();
                    if (answer.isBlank()) continue;
                    if (answer.charAt(0) == 'n') return;
                    continue;
                }
                continue;
            }
            if (program == null) {
                program = selectProgram();
                if (program == null) {
                    System.out.println(Text.NOT_FOUND_TRY_AGAIN);
                    String answer = Util.scanner.nextLine().trim().toLowerCase();
                    if (answer.isBlank()) continue;
                    if (answer.charAt(0) == 'n') return;
                }
                continue;
            }
            System.out.println(Text.CONFIRM_STUDENT_REGISTRATION);
            String answer = Util.scanner.nextLine().trim().toLowerCase();
            if (answer.isBlank()) continue;
            if (answer.charAt(0) == 'n') return;
            if (answer.charAt(0) == 'y') {
                if (DBQuery.registerStudent(student, program)) {
                    System.out.println(Text.ADDED_SUCCESSFULLY);
                } else {
                    System.out.println(Text.ADD_FAIL);
                }
                return;
            }
        }
    }

    public static void promptMove() {
        Student student = null;
        Program programOut = null;
        Program programIn = null;

        while (true) {
            currentlySelected(student, programOut, programIn);
            if (student == null) {
                student = selectStudent();
                if (student == null) {
                    System.out.println(Text.NOT_FOUND_TRY_AGAIN);
                    String answer = Util.scanner.nextLine().trim().toLowerCase();
                    if (answer.isBlank()) continue;
                    if (answer.charAt(0) == 'n') return;
                    continue;
                }
                continue;
            }
            if (programOut == null) {
                System.out.println(Text.ADD_STUDENT_HIGHLIGHT);
                programOut = selectProgram();
                if (programOut == null) {
                    System.out.println(Text.NOT_FOUND_TRY_AGAIN);
                    String answer = Util.scanner.nextLine().trim().toLowerCase();
                    if (answer.isBlank()) continue;
                    if (answer.charAt(0) == 'n') return;
                }
                continue;
            }
            if (programIn == null) {
                System.out.println(Text.REMOVE_STUDENT_HIGHLIGHT);
                programIn = selectProgram();
                if (programIn == null) {
                    System.out.println(Text.NOT_FOUND_TRY_AGAIN);
                    String answer = Util.scanner.nextLine().trim().toLowerCase();
                    if (answer.isBlank()) continue;
                    if (answer.charAt(0) == 'n') return;
                }
                continue;
            }
            System.out.println(Text.CONFIRM_TRANSFER);
            String answer = Util.scanner.nextLine().trim().toLowerCase();
            if (answer.isBlank()) continue;
            if (answer.charAt(0) == 'n') return;
            if (answer.charAt(0) == 'y') {
                if (DBQuery.transferStudent(student, programOut, programIn)) {
                    System.out.println(Text.ADDED_SUCCESSFULLY);
                } else {
                    System.out.println(Text.ADD_FAIL);
                }
                return;
            }
        }
    }

    public static void promptPrintEnrolled() {
        Program program;
        while (true) {
            program = selectProgram();
            if (program == null) {
                System.out.println(Text.NOT_FOUND_TRY_AGAIN);
                String answer = Util.scanner.nextLine().trim().toLowerCase();
                if (answer.isBlank()) continue;
                if (answer.charAt(0) == 'n') return;
            } else {
                break;
            }

        }
        printEnrolled(DBQuery.getEnrolled(program));
    }
}
