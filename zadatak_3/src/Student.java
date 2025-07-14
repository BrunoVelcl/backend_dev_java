public class Student extends Osoba{
    private final int oib;

    public Student(String ime, String prezime, int oib) {
        super(ime, prezime);
        this.oib = oib;
    }

    public long getOib() {
        return oib;
    }
}
