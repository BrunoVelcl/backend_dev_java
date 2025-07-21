import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EvidencijaVozila {

    List<Vozilo> vozila = new ArrayList<>();

    public void dodajNovoVozilo(Vozilo vozilo){
        vozila.add(vozilo);
    }

    public void spremiPodatkeUDatoteku(File datoteka){
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream((datoteka))))){
            oos.writeObject(vozila);
        }catch (IOException e){
            System.err.println("Došlo je do greške prilikom otvaranaja datoteke: " + e.getMessage());
        }
    }

    public void ucitajPodatkeIzDatoteke(File datoteka){
        if(!datoteka.exists()){
            try {
                if(!datoteka.createNewFile()){
                    throw new IOException();
                };
            }catch (IOException e){
                System.err.println("Nemoguce stvoriti datoteku za pohranu: " + e.getMessage());
            }
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(datoteka)))){
            vozila = (List<Vozilo>)ois.readObject();
        }catch (IOException e){
            System.out.println("Došlo je do greške prilikom otvaranaja datoteke, nepostoji zapis vozila: " + e.getMessage() + e.fillInStackTrace());
        }catch (ClassNotFoundException e){
            System.out.println("Zapis nepostoji, stvoren novi zapis.");
        }
    }

    public void ispisVozila(){
        for(Vozilo vozilo : this.vozila){
            vozilo.prikaziPodatke();
            System.out.println("\u001b[36m****************************************************************\u001b[37m");
        }
    }
}
