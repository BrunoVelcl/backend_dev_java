import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        EvidencijaPolaznika ep = new EvidencijaPolaznika();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(
                    ANSI.Style.bold(
                            ANSI.Color.colorBackground(
                                    ANSI.Color.basicString("      Evidencija Polaznika      ", ANSI.BasicColor.BLACK),
                                    0xFF, 0xFF, 0xFF)
                    )
            );
            System.out.println("1. Dodaj novog polaznika.");
            System.out.println("2. Ispisi sve polaznike.");
            System.out.println("3. Pretrazi po email-u.");
            System.out.println("4. Nasumican ispis polaznika.");
            System.out.println("5. Obrnut ispis polaznika.");
            System.out.println("6. Pretrazi po imenu.");
            System.out.println("Q. Izadji iz programa.");
            Options input;
            try {
                input = Options.getFromChar(scanner.nextLine().toUpperCase().charAt(0));
            } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
                ANSI.Erase.all();
                System.out.println(ANSI.Color.basicString("Nevazeci odabir!", ANSI.BasicColor.RED));
                continue;
            }
            switch (input) {
                case ADD -> {
                    try {

                        if(ep.dodajPolaznika(stvoriPolaznika(scanner))){
                            System.out.println(ANSI.Color.basicString("Uspjesno dodano!", ANSI.BasicColor.GREEN));
                        }else
                            System.out.println(ANSI.Color.basicString("Polaznik postoji!", ANSI.BasicColor.RED));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case PRINTALL -> System.out.println(ep.ispisEvidencije());
                case SEARCH_BY_EMAIL -> System.out.println(ep.pronadjiPoEmail(email(scanner)));
                case RANDOM_PRINTOUT -> System.out.println(ep.nasumicanIspisEvidencije());
                case REVERSE_PRINTOUT -> System.out.println(ep.obrnutIspisEvidencije());
                case FIND_BY_NAME -> System.out.println(ep.pronadjiPoIme(ime(scanner)));
                case QUIT -> {
                    return;
                }
            }

        }


    }

    private static Polaznik stvoriPolaznika(Scanner scanner) throws IllegalArgumentException {
        System.out.print(ANSI.Color.basicString("Ime: ", ANSI.BasicColor.YELLOW));
        String ime = scanner.nextLine();
        if (ime.isEmpty())
            throw new IllegalArgumentException(ANSI.Color.basicString("Nije uneseno ime!", ANSI.BasicColor.RED));

        System.out.print(ANSI.Color.basicString("Prezime: ", ANSI.BasicColor.YELLOW));
        String prezime = scanner.nextLine();
        if (prezime.isEmpty())
            throw new IllegalArgumentException(ANSI.Color.basicString("Nije uneseno prezime!", ANSI.BasicColor.RED));

        System.out.print(ANSI.Color.basicString("E-mail: ", ANSI.BasicColor.YELLOW));
        String email = scanner.nextLine();
        if (email.isEmpty())
            throw new IllegalArgumentException(ANSI.Color.basicString("Nevažeći email!", ANSI.BasicColor.RED));

        return new Polaznik(ime, prezime, email);
    }

    private static String email(Scanner scanner) {
        System.out.print(ANSI.Color.basicString("E-mail: ", ANSI.BasicColor.YELLOW));
        return scanner.nextLine();
    }

    private static String ime(Scanner scanner){
        System.out.print(ANSI.Color.basicString("Ime: ", ANSI.BasicColor.YELLOW));
        return scanner.nextLine();
    }
}