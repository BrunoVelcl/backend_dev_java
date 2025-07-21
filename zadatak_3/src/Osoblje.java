import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Osoblje implements Serializable{
    private List<Osoba>studenti = new ArrayList<>();
    private List<Osoba>profesori = new ArrayList<>();
    private Map<Long, Osoba> oib = new HashMap<>();
    private static final String DATOTEKA = "fakultet.txt";
    private static final String DELIMITER = "\\|";

    public void ucitajIzDatoteke()  {
       try{
           BufferedReader reader = new BufferedReader(new FileReader(DATOTEKA));
           Osoba ucitanaOsoba = null;
           String line = reader.readLine();
           while (line != null) {
               String[] column = line.split(DELIMITER);
               long oib = Long.parseLong(column[3].trim());
               switch (Titula.fromText(column[0])) {
                   case STUDENT -> {
                       ucitanaOsoba = new Student(column[1], column[2], oib, column[4].trim());
                       studenti.add(ucitanaOsoba);
                   }
                   case PROFESOR -> {
                       ucitanaOsoba = new Profesor(column[1], column[2], oib);
                       profesori.add(ucitanaOsoba);
                   }
               }
               this.oib.put(oib, ucitanaOsoba);
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

    public String ispisi(){
        final String LINE_SEPARATOR = System.lineSeparator();
        final String SEPARATOR = ", ";
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Profesori(%d)", profesori.size())).append(LINE_SEPARATOR);
        for(Osoba profesor : profesori){
            sb.append(profesor.getIme()).append(SEPARATOR).append(profesor.getPrezime()).append(LINE_SEPARATOR);
        }
        sb.append(System.lineSeparator());
        sb.append(String.format("Studenti(%d)", studenti.size())).append(LINE_SEPARATOR);
        for(Osoba student : studenti){
            sb.append(student.getIme()).append(SEPARATOR).append(student.getPrezime()).append(LINE_SEPARATOR);
        }
        return sb.toString();
    }

//    public boolean dodajProfesora(Profesor profesor, Long oib){
//        if(this.oib.containsKey(oib)){
//            return false;
//        }
//        this.profesori.add(profesor);
//        this.oib.put(oib, profesor);
//        return true;
//    }
//
//    public boolean dodajStudenta(Student student, Long oib){
//        if(this.oib.containsKey(oib)){
//            return false;
//        }
//        this.studenti.add(student);
//        this.oib.put(oib, student);
//        return true;
//    }

    public boolean dodajOsobu(Osoba osoba, Titula titula){
        long uneseniOib = osoba.getOib();
        if(this.oib.containsKey(uneseniOib)){
            return false;
        }
        switch (titula){
            case PROFESOR:
                this.profesori.add(osoba);
                this.oib.put(uneseniOib, osoba);
                return true;
            case STUDENT:
                this.studenti.add(osoba);
                this.oib.put(uneseniOib, osoba);
                return true;
        }
        return false; // Unreachable
    }

    public void spremiUDatoteku(){
        List<Osoba> combined = new ArrayList<>();
        combined.addAll(this.studenti);
        combined.addAll(this.profesori);
        try(PrintWriter printWriter = new PrintWriter(DATOTEKA)){
            for(Osoba osoba : combined){
                printWriter.println(osoba.toString());
            }
        } catch (IOException e){
            System.err.println("Problem sa zapisivanjem datoteke: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Osoba> filter(String upit, FilterOptions opcija) throws IllegalArgumentException{
        List<Osoba> result = new ArrayList<>();
        List<Osoba> combined = new ArrayList<>();
        combined.addAll(this.studenti);
        combined.addAll(this.profesori);
        Function<Osoba, String> get;
        switch (opcija){
            case IME:
                get = Osoba::getIme;
                break;
            case PREZIME:
                get = Osoba::getPrezime;
                break;
            default:
                throw new IllegalArgumentException("Nepostojeća opcija.");
        }

        for(Osoba osoba : combined){
            if(get.apply(osoba).toLowerCase().contains(upit.toLowerCase())){
                result.add(osoba);
            }
        }
        return result;
    }

    public Osoba nadjiPoOibu(long oib){
        return this.oib.get(oib);
    }

}
