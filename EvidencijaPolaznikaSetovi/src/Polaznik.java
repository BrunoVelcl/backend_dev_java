import java.util.Comparator;
import java.util.Objects;

public class Polaznik {
    private final String ime;
    private final String prezime;
    private final String email;

    public Polaznik(String ime, String prezime, String email) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Polaznik polaznik = (Polaznik) o;
        return Objects.equals(email, polaznik.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }

//    @Override
//    public int compareTo(Polaznik o) {
//        if(this.email.equals(o.email)){
//            return 0;
//        }
//       return this.prezime.compareToIgnoreCase(o.prezime) * -1;
//    }

    public String outputString(){
        final String NEW_LINE = System.lineSeparator();
        return    (ANSI.Color.basicString("Ime: ", ANSI.BasicColor.BLUE))
                + (this.ime)
                + (NEW_LINE)
                + (ANSI.Color.basicString("Prezime: ", ANSI.BasicColor.BLUE))
                + (this.prezime)
                + (NEW_LINE)
                + (ANSI.Color.basicString("Email: ", ANSI.BasicColor.BLUE))
                + (this.email)
                + (NEW_LINE)
                + (ANSI.Color.basicString("************************************", ANSI.BasicColor.GREEN))
                + (NEW_LINE);
    }


}
