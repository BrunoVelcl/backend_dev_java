import java.util.ArrayList;

public class EvidencijaPolaznika {
    private final ArrayList<Polaznik> evidencijaPolaznika = new ArrayList<>();
    private final StringBuilder stringBuilder = new StringBuilder();

    public void dodajPolaznika(Polaznik noviPolaznik){
        this.evidencijaPolaznika.add(noviPolaznik);
    }

    public String ispisEvidencije(){
        final String NEW_LINE = System.lineSeparator();
        this.stringBuilder.setLength(0);
        this.stringBuilder
                .append(ANSI.Color.basicString("**********ISPIS EVIDENCIJE**********\n", ANSI.BasicColor.GREEN))
                .append(NEW_LINE);
        for(Polaznik polaznik: this.evidencijaPolaznika){
            this.stringBuilder.append(polaznik.outputString());
        }
        return this.stringBuilder.toString();
    }

    public String pronadjiPoEmail(String email){
        this.stringBuilder.setLength(0);
        for(Polaznik polaznik: this.evidencijaPolaznika){
            if(email.equals(polaznik.email)){
                this.stringBuilder.append(polaznik.outputString());
            }
        }
        return this.stringBuilder.isEmpty() ? "Nepostojeci email." : stringBuilder.toString();
    }
}
