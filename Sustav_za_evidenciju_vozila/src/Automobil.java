import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Automobil extends Vozilo implements Serializable {
    private byte brojVrata;

    @Override
    protected void ucitajKarakteristiku(Scanner scanner) throws InputMismatchException {
        System.out.print("Unesite broj vrata: ");
        this.brojVrata = scanner.nextByte();
    }

    public void prikaziPodatke(){
        super.prikaziPodatke();
        System.out.println("\u001b[34mBroj vrata: \u001b[37m" + this.brojVrata);
    }
}
