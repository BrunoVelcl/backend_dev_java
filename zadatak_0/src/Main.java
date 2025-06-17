import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean cont = true;
        while(cont){
            cont = menu();
        }
    }

    public static boolean menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Unesite prvi broj: ");
        int x = scanner.nextInt();

        System.out.print("Unesite drugi broj: ");
        int y = scanner.nextInt();

        System.out.print("Unesite matematičku operaciju: (+,-,*,/): ");
        char oper = scanner.next().charAt(0);

        System.out.println("Rezultat je " + calc(x, y, oper));

        System.out.println("Da li želite nastaviti?");
        System.out.println("(Y/N)");

        return scanner.next().toUpperCase().charAt(0) == 'Y';

    }

    private static int calc (int x, int y, char operator){
        switch (operator){
            case '+' -> {
                return x+y;
            }
            case '-' -> {
                return x-y;
            }
            case '*' -> {
                return x*y;
            }
            case '/' -> {
                return (x/y);
            }
            default -> {
                System.out.println("Nedozvoljeni operator!");
                return 0;
            }
        }
    }
}