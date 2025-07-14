import java.util.InputMismatchException;
import java.util.Scanner;

public class Vozilo {
    protected long registarskiBroj;
    protected String marka;
    protected short godinaProizvodnje;


    protected void ucitajKarakteristiku(Scanner scanner){}

    public void ucitajPodatke() throws InputMismatchException, NeispravniPodaciException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Unesite registarski broj: ");
        this.registarskiBroj = Long.parseLong(scanner.nextLine());
        System.out.print("Unesite marku vozila: ");
        this.marka = scanner.nextLine();
        System.out.print("Unesite godinu proizvodnje: ");
        this.godinaProizvodnje = Short.parseShort(scanner.nextLine());
        ucitajKarakteristiku(scanner);
    }
    public void prikaziPodatke(){
        System.out.println("\u001b[34mRegistarski broj: \u001b[37m" + this.registarskiBroj);
        System.out.println("\u001b[34mMarka: \u001b[37m" + this.marka);
        System.out.println("\u001b[34mGodina proizvodnje: \u001b[37m" + this.godinaProizvodnje);
    }
}
