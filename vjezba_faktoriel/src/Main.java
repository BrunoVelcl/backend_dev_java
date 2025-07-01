import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.print("Unesite broj: ");
            String strInput = scanner.nextLine();
            int input;
            try {
                input = Integer.parseInt(strInput);
            }catch (NumberFormatException e){
                System.out.println(strInput + " nije valjan broj.");
                while (!(strInput.equalsIgnoreCase("Y") | strInput.equalsIgnoreCase("N"))) {
                    System.out.println("Želite li nastaviti unos? (Y/N)");
                    strInput = scanner.nextLine();
                }
                if(strInput.equalsIgnoreCase("Y")){
                    continue;
                }
                return;
            }
            long result = 1;

            for (int i = 1; i <= input; i++) {
                result *= i;
            }

            System.out.println("Faktoriel od: \u001b[34m" + input + " \u001b[37m je: \u001b[32m" + result + "\u001b[37m");
            String confirmation = "";
            while (!(confirmation.equalsIgnoreCase("Y") | confirmation.equalsIgnoreCase("N"))) {
                System.out.print("Zelite li izracunati jos jedan? (Y/N): ");
                confirmation = scanner.nextLine();
            }
            if(confirmation.equalsIgnoreCase("N")){
                run = false;
            }
        }
    }
}