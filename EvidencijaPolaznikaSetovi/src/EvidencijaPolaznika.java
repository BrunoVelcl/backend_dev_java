import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class EvidencijaPolaznika {
    private final TreeSet<Polaznik> evidencijaPolaznika = new TreeSet<>(new PrezimeComparator());
    private final StringBuilder stringBuilder = new StringBuilder();

    public boolean dodajPolaznika(Polaznik noviPolaznik){
        return this.evidencijaPolaznika.add(noviPolaznik);
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
            if(email.equals(polaznik.getEmail())){
                this.stringBuilder.append(polaznik.outputString());
            }
        }
        return this.stringBuilder.isEmpty() ? "Nepostojeci email." : stringBuilder.toString();
    }
}
