import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        int input;

        while (run) {
            System.out.print("Unesite broj: ");
            String strInput = scanner.nextLine();
            try {
                input = inputParsing(strInput);
            }catch (NumberNotNatural | NumberFormatException e){
                System.out.println(e.getMessage());
                run = continueDialog(scanner);
                continue;
            }

            long result = 1;

            for (int i = 1; i <= input; i++) {
                result *= i;
            }

            System.out.println("Faktoriel od: \u001b[34m" + input + " \u001b[37m je: \u001b[32m" + result + "\u001b[37m");
            run = continueDialog(scanner);

        }
    }
    private static int inputParsing(String strInput)throws NumberFormatException, NumberNotNatural{

        int input = Integer.parseInt(strInput);
        if(input < 0){
            throw new NumberNotNatural("Broj nije prirodan.");
        }
        return input;
    }

    private static boolean continueDialog(Scanner scanner){
        String confirmation = "";
        while (!(confirmation.equalsIgnoreCase("Y") | confirmation.equalsIgnoreCase("N"))) {
            System.out.print("Zelite li ponoviti? (Y/n): ");
            confirmation = scanner.nextLine();
        }
        return !confirmation.equalsIgnoreCase("N");
    }
}