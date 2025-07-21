import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final String STR_COLOR_DEFAULT = "\u001b[97m";
    private static final String STR_COLOR_BLUE = "\u001b[34m";
    private static final String STR_COLOR_RED = "\u001b[31m";
    private static final String STR_COLOR_GREEN = "\u001b[32m";
    private static final String NEW_LINE = System.lineSeparator();

    public static void main(String[] args) {

        final String mainMenu = String.format(
                "%s1.Unos Profesora | 2.Unos Studenta | 3.Filtriranje | 4.Ispis |5.Nadji po OIB-u | %s6.Izlaz%s",
                STR_COLOR_DEFAULT, STR_COLOR_RED, STR_COLOR_DEFAULT
        );

        Osoblje osoblje = new Osoblje();
        osoblje.ucitajIzDatoteke();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(mainMenu);

            MainMenu menu;
            try {
                int input = Integer.parseInt(scanner.nextLine());
                menu = MainMenu.getSelection(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Nepostojeci unos: " + e.getMessage());
                continue;
            }

            switch (menu) {
                case UNOS_PROFESORA:
                    Osoba noviProfesor = createOsoba(scanner, Titula.PROFESOR);
                    if(!osoblje.dodajOsobu(noviProfesor, Titula.PROFESOR)){
                        System.out.println("Uneseni OIB već postoji.");
                    }
                    break;
                case UNOS_STUDENTA:
                    Osoba noviStudent = createOsoba(scanner, Titula.STUDENT);
                    if(!osoblje.dodajOsobu(noviStudent, Titula.STUDENT)){
                        System.out.println("Uneseni OIB već postoji.");
                    }
                    break;
                case FILTRIRANJE:
                    try {
                        filterMenu(scanner, osoblje);
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case ISPIS:
                    System.out.println(osoblje.ispisi());
                    break;
                case NADJI_PO_OIBU:
                    ispisiUpit(nadjiPoOibu(osoblje, scanner));
                    break;
                case IZLAZ:
                    osoblje.spremiUDatoteku();
                    return;
                default:
            }
        }

    }

//    private static Profesor createProfesor(Scanner scanner) {
//        System.out.print("Ime: ");
//        String ime = scanner.nextLine();
//        System.out.print("Prezime: ");
//        String prezime = scanner.nextLine();
//        return new Profesor(ime, prezime);
//    }
//
//    private static Student createStudent(Scanner scanner) {
//        System.out.print("Ime: ");
//        String ime = scanner.nextLine();
//        System.out.print("Prezime: ");
//        String prezime = scanner.nextLine();
//        System.out.print("ID: ");
//        String studentId = scanner.nextLine();
//
//        return new Student(ime, prezime, studentId);
//    }

    private static Osoba createOsoba(Scanner scanner, Titula titula){
        System.out.print("Ime: ");
        String ime = scanner.nextLine();
        System.out.print("Prezime: ");
        String prezime = scanner.nextLine();
        System.out.print("OIB: ");
        long oib = Long.parseLong(scanner.nextLine().trim());
        switch (titula){
            case PROFESOR:
                return new Profesor(ime, prezime, oib);
            case STUDENT:
                System.out.print("ID: ");
                String studentId = scanner.nextLine();
                return new Student(ime, prezime, oib, studentId);
        }
        return null; //Unreachable
    }

//    private static Long promptOib(Scanner scanner) {
//        System.out.print("OIB: ");
//        try {
//            return Long.parseLong(scanner.nextLine().trim());
//        }catch (NumberFormatException e){
//            System.out.println("Nevazeci OIB! " + e.getMessage());
//            return null;
//        }
//    }

    private static void filterMenu(Scanner scanner, Osoblje osoblje) throws IllegalArgumentException{
        System.out.println("1.Ime | 2.Prezime");
        String input = scanner.nextLine();
        if(input.length() > 1){
            throw new IllegalArgumentException("Nepostojeci unos.");
        }
        FilterOptions odabir;
            odabir = FilterOptions.getSelection(input.charAt(0));
            System.out.print("Unesite upit: ");
            String upit = scanner.nextLine();
            ispisiUpit(osoblje.filter(upit, odabir));
    }

    private static void ispisiUpit(List<Osoba> osobe){
        StringBuilder sb = new StringBuilder();
        for (Osoba osoba : osobe){
            sb.append("[")
                .append(STR_COLOR_GREEN)
                .append(osoba.getTitula())
                .append(STR_COLOR_DEFAULT)
                .append("] ")
                .append(STR_COLOR_BLUE)
                .append("Ime: ")
                .append(STR_COLOR_DEFAULT)
                .append(osoba.getIme())
                .append(STR_COLOR_BLUE)
                .append(" Prezime: ")
                .append(STR_COLOR_DEFAULT)
                .append(osoba.getPrezime())
                .append(STR_COLOR_BLUE)
                .append(" OIB: ")
                .append(STR_COLOR_DEFAULT)
                .append(osoba.getOib());
            if(osoba instanceof Student student) {
                sb.append(STR_COLOR_BLUE)
                    .append(" Broj indexa: ")
                    .append(STR_COLOR_DEFAULT)
                    .append(student.getBrojIndexa());
            }
            sb.append(NEW_LINE);
        }
        System.out.println(sb);
    }

    private static void ispisiUpit(Osoba osoba){
        if(osoba != null) {
            List<Osoba> osobe = new ArrayList<>();
            osobe.add(osoba);
            ispisiUpit(osobe);
        }
    }

    private static Osoba nadjiPoOibu(Osoblje osoblje, Scanner scanner){
        System.out.print("OIB: ");
        try{
            Long oib = Long.parseLong(scanner.nextLine());
            Osoba pronadjenaOsoba = osoblje.nadjiPoOibu(oib);
            if(pronadjenaOsoba == null){
                System.out.println("OIB nije pronadjen.");
            }
            return pronadjenaOsoba;
        }catch (NumberFormatException e){
            System.out.println("Neispravan unos: " + e.getMessage());
            return null;
        }
    }
}
