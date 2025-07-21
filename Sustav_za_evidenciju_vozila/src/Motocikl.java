import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Motocikl extends Vozilo implements Serializable {
    private String tipMotora;

    @Override
    protected void ucitajKarakteristiku(Scanner scanner) throws InputMismatchException {
        System.out.print("Unesite tip motora: ");
        this.tipMotora = scanner.nextLine();
    }

    public void prikaziPodatke(){
        super.prikaziPodatke();
        System.out.println("\u001b[34mTip motora: \u001b[37m" + this.tipMotora);
    }
}
