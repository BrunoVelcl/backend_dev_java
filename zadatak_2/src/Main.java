import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Unesite OIB: ");
        String oib = scanner.nextLine();
        System.out.println((isValid(oib)) ? "OIB: \u001b[34mISPRAVAN" : "OIB: \u001b[31mNEISPRAVAN!");
    }

    public static boolean isValid(String oib){

        if (oib.length() != 11){
            return false;
        }

        String numericValue = oib.substring(0, 10);

        int mod = 0;
        for(int i = 0; i < numericValue.length(); i++){
            char digitChar = numericValue.charAt(i);
            if(!Character.isDigit(digitChar)){
                return false;
            }
            int digit = Character.getNumericValue(digitChar);
            mod = zeroCheck(mod);
            mod = (mod + digit) % 10;
            mod = zeroCheck(mod);
            mod = (mod * 2) % 11;
        }
        mod = ((11 - mod) + 10) % 10;

        int controlValue = Character.getNumericValue(oib.charAt(10));
        return controlValue == mod;

    }

    private static int zeroCheck(int num){
       return (num == 0) ? 10 : num;
    }
}


