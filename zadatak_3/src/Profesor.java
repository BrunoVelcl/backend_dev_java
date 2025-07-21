public class Profesor extends Osoba{

    public Profesor(String ime, String prezime, Long oib) {
        super(ime, prezime, Titula.PROFESOR, oib);
    }
}
