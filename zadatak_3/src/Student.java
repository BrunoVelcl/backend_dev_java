public class Student extends Osoba{
    private final String brojIndexa;

    public Student(String ime, String prezime,Long oib, String studentId) {
        super(ime, prezime, Titula.STUDENT, oib);
        this.brojIndexa = studentId;
    }

    public String getBrojIndexa() {
        return brojIndexa;
    }

    @Override
    public String toString() {
        return super.toString() + "|" + brojIndexa;
    }
}
