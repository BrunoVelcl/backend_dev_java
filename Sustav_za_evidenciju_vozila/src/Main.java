import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        final String POHRANAEVIDENCIJE = "save.bin";
        //Files.createFile(Path.of(POHRANAEVIDENCIJE));

        Scanner scanner = new Scanner(System.in);
        EvidencijaVozila ev = new EvidencijaVozila();
        ev.ucitajPodatkeIzDatoteke(POHRANAEVIDENCIJE);
        System.out.println("\u001b[33mSUSTAV ZA EVIDENCIJU VOZILA\u001b[37m");
        while(true){
            System.out.println("1. Ispis vozila  --  2. Dodaj automobil  --  3. Dodaj motocikl  --  Q. Izlaz");
            String odabir = scanner.nextLine();
            switch (odabir){
                case "1" -> {ev.ispisVozila();}
                case "2" -> {
                    Automobil temp = new Automobil();
                    temp.ucitajPodatke();
                    ev.dodajNovoVozilo(temp);
                }
                case "3" -> {
                    Motocikl temp = new Motocikl();
                    temp.ucitajPodatke();
                    ev.dodajNovoVozilo(temp);
                }
                case "Q", "q" -> {
                    ev.spremiPodatkeUDatoteku(POHRANAEVIDENCIJE);
                    return;
                }
            }
        }
    }
}