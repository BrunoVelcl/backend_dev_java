import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Ucilica {
    private final List<GeometricShape> shapesList = new ArrayList<>();

    public List<GeometricShape> getShapesList(){
        return shapesList;
    }

    public Ucilica(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Odaberite geometriski lik:\n1.Trokut\n2.Krug\n3.Pravokutnik\nUnos: ");
            switch (resolveInput(scanner.next())) {

                case Trokut -> {
                    double a,b,c;
                    System.out.print("Unesite stranicu A: ");
                    try{
                       a = scanner.nextDouble();
                       scanner.nextLine();
                    } catch (InputMismatchException e) {
                        badInput();
                        continue;
                    }
                    System.out.print("Unesite stranicu B: ");
                    try{
                        b = scanner.nextDouble();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        badInput();
                        continue;
                    }
                    System.out.print("Unesite stranicu C: ");
                    try{
                        c = scanner.nextDouble();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        badInput();
                        continue;
                    }
                    shapesList.add(new Triangle(a,b,c));
                }

                case Krug -> {
                    double r;
                    System.out.print("Unesite radius R: ");
                    try{
                        r = scanner.nextDouble();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        badInput();
                        continue;
                    }
                    shapesList.add(new Circle(r));
                }

                case Pravokutnik -> {
                    double a,b;
                    System.out.print("Unesite stranicu A: ");
                    try{
                        a = scanner.nextDouble();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        badInput();
                        continue;
                    }
                    System.out.print("Unesite stranicu B: ");
                    try{
                        b = scanner.nextDouble();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        badInput();
                        continue;
                    }
                    shapesList.add(new Rectangle(a,b));
                }

                case null, default -> badInput();
            }
            boolean decision = false;
            while (!decision) {
                System.out.print("Dodati jos jedno? (Y/N): ");
                String input = scanner.next();
                if(input.equalsIgnoreCase("Y")){
                    decision = true;
                    System.out.println("**************************************************");
                } else if(input.equalsIgnoreCase("N")){
                    return;
                }else {
                    badInput();
                }
            }
        }
    }

    private static enumShape resolveInput(String input) {
        String inputLow = input.toLowerCase();
        String[][] shapes = {
                {"1", "tro", "tri"},
                {"2", "kru", "cir"},
                {"3", "pra", "rec"}
        };
        for(byte i = 0; i < shapes.length; i++){
            for(String test: shapes[i]){
                if(inputLow.contains(test)){
                    switch (i){
                        case 0 -> { return enumShape.Trokut;}
                        case 1 -> { return enumShape.Krug;}
                        case 2 -> { return enumShape.Pravokutnik;}
                    }
                }
            }
        }
        return null;
    }

    private static void badInput(){
        System.out.println("\u001b[31mUnos neispravan!\u001b[37m");
    }

    public void sortByArea(){
        Collections.sort(shapesList);
    }
    
}
