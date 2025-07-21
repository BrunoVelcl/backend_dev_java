import java.util.List;

public abstract class Osoba {
    private final String ime;
    private final String prezime;
    private final Titula titula;
    private final long oib;

    public Osoba(String ime, String prezime, Titula titula, Long oib) {
        this.ime = ime;
        this.prezime = prezime;
        this.titula = titula;
        this.oib = oib;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public long getOib() {
        return oib;
    }

    public Titula getTitula() {
        return titula;
    }

    @Override
    public String toString() {
        return titula.toString() + "|" + ime + "|" + prezime + "|" + oib;
    }
}
