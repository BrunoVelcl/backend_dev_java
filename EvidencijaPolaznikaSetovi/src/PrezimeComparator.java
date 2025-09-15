import java.util.Comparator;

public class PrezimeComparator implements Comparator<Polaznik> {
    @Override
    public int compare(Polaznik o1, Polaznik o2) {
        if(o1.getEmail().equals(o2.getEmail()))
            return 0;
        return o1.getPrezime().compareToIgnoreCase(o2.getPrezime()) * -1;
    }
}
