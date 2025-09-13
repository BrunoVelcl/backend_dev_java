public class Polaznik {
    String ime;
    String prezime;
    String email;

    public Polaznik(String ime, String prezime, String email) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
    }

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
