import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Osoblje {
    private List<Osoba>studenti = new ArrayList<>();
    private List<Profesor>profesori = new ArrayList<>();
    private final String DATOTEKA = "fakultet.txt";

    public void ucitaIzDatoteke(){
       try{

           BufferedReader reader = new BufferedReader(new FileReader(new File(DATOTEKA)));
           String line = reader.readLine();
           while (line != null) {
               String[] column = line.split("\\|");
               switch (column[0]) {
                   case "Student" -> {
                       studenti.add(new Student(column[1], column[2], Integer.parseInt(column[3].strip())));
                   }
                   case "Profesor" -> {
                       profesori.add(new Profesor(column[1], column[2]));
                   }
                   default -> {
                       System.err.println("Greska sa parsiranjem linije. Nastavljamo dalje...");
                   }
               }
               line = reader.readLine();
           }
//           String data = Files.readString(Path.of(DATOTEKA), StandardCharsets.UTF_8);
//           String[] lines = data.split("\n");
//           for (String line : lines){
//                String[] osoba = line.split("\\|");
//                switch (osoba[0]){
//                    case "Student" -> { studenti.add(new Student(osoba[1], osoba[2], Integer.parseInt(osoba[3].strip())));}
//                    case "Profesor" -> {profesori.add(new Profesor(osoba[1], osoba[2]));}
//                    default -> {
//                        System.err.println("Greska sa parsiranjem linije. Nastavljamo dalje...");
//                    }
//                }
//           }
       }catch (IOException e){
           System.err.println("Problem sa datotekom: " + e.getMessage());
       }
    }

    public void ispisi(){
        System.out.println("Profesori(" + profesori.size() + ")");
        System.out.println();
        for(Osoba profesor : profesori){
            System.out.println(profesor.getIme() + " " + profesor.getPrezime());
        }
        System.out.println();
        System.out.println("Studenti(" + studenti.size() + ")");
        System.out.println();
        for(Osoba student : studenti){
            System.out.println(student.getIme() + " " + student.getPrezime());
        }

    }
}
