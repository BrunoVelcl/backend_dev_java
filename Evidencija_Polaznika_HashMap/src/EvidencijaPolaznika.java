import java.util.*;

public class EvidencijaPolaznika {
    private final HashMap<String ,Polaznik> evidencijaPolaznika = new HashMap<>();
    private final StringBuilder stringBuilder = new StringBuilder();

    public HashMap<String, Polaznik> getEvidencijaPolaznika() {
        return evidencijaPolaznika;
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public boolean dodajPolaznika(Polaznik noviPolaznik){
        if(evidencijaPolaznika.containsKey(noviPolaznik.getEmail()))
        {
            return false;
        } else {
            this.evidencijaPolaznika.put(noviPolaznik.getEmail(), noviPolaznik);
            return true;
        }
    }

    public String ispisEvidencije(){
        final String NEW_LINE = System.lineSeparator();
        this.stringBuilder.setLength(0);
        this.stringBuilder
                .append(ANSI.Color.basicString("**********ISPIS EVIDENCIJE**********", ANSI.BasicColor.GREEN))
                .append(NEW_LINE);
        for(String polaznik: this.evidencijaPolaznika.keySet()){
            this.stringBuilder.append(evidencijaPolaznika.get(polaznik).outputString());
        }
        return this.stringBuilder.toString();
    }

    public String pronadjiPoEmail(String email){
        if(evidencijaPolaznika.containsKey(email))
            return evidencijaPolaznika.get(email).outputString();

        return ANSI.Color.basicString("Nepostojeci email!", ANSI.BasicColor.RED);
    }

    public String nasumicanIspisEvidencije(){
        final String NEW_LINE = System.lineSeparator();
        this.stringBuilder.setLength(0);
        this.stringBuilder
                .append(ANSI.Color.basicString("**********NASUMICAN ISPIS EVIDENCIJE**********", ANSI.BasicColor.GREEN))
                .append(NEW_LINE);
        List<Polaznik> list = new ArrayList<>(this.evidencijaPolaznika.values());
        Collections.shuffle(list);
        for(Polaznik polaznik: list){
             this.stringBuilder.append(polaznik.outputString());
        }
        return this.stringBuilder.toString();
    }

    public String obrnutIspisEvidencije(){
        final String NEW_LINE = System.lineSeparator();
        this.stringBuilder.setLength(0);
        this.stringBuilder
                .append(ANSI.Color.basicString("**********NASUMICAN ISPIS EVIDENCIJE**********", ANSI.BasicColor.GREEN))
                .append(NEW_LINE);
        List<Polaznik> list = new ArrayList<>(this.evidencijaPolaznika.values());
        Collections.reverse(list);
        for(Polaznik polaznik: list){
            this.stringBuilder.append(polaznik.outputString());
        }
        return this.stringBuilder.toString();
    }

    public String pronadjiPoIme(String ime){
        this.stringBuilder.setLength(0);
        for(Polaznik polaznik: this.evidencijaPolaznika.values()) {
            if (polaznik.getIme().equals(ime)) {
                this.stringBuilder.append(polaznik.outputString());
            }
        }
        if(stringBuilder.isEmpty()) {
            return ANSI.Color.basicString("Nepostojeci email!", ANSI.BasicColor.RED);
        }
        return this.stringBuilder.toString();
    }
}
