import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EvidencijaVozila {

    List<Vozilo> vozila = new ArrayList<>();

    public void dodajNovoVozilo(Vozilo vozilo){
        vozila.add(vozilo);
    }

    public void spremiPodatkeUDatoteku(String datoteka){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(datoteka)))){
            oos.writeObject(vozila);
        }catch (IOException e){
            System.err.println("Došlo je do greške prilikom otvaranaja datoteke: " + e.getMessage());
        }
    }

    public void ucitajPodatkeIzDatoteke(String datoteka){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(datoteka)))){
            vozila = (List<Vozilo>)ois.readObject();
        }catch (IOException | ClassNotFoundException e){
            System.err.println("Došlo je do greške prilikom otvaranaja datoteke: " + e.getMessage() + e.fillInStackTrace());
        }
    }

    public void ispisVozila(){
        for(Vozilo vozilo : this.vozila){
            vozilo.prikaziPodatke();
            System.out.println("\u001b[36m****************************************************************\u001b[37m");
        }
    }
}
