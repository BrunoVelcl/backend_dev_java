import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
                    GeometricShape temp = Triangle.conCreate(scanner);
                    if (temp != null) {
                        shapesList.add(temp);
                    } else {
                        badInput();
                    }
                }

                case Krug -> {
                    GeometricShape temp = Circle.conCreate(scanner);
                    if (temp != null) {
                        shapesList.add(temp);
                    } else {
                        badInput();
                    }
                }

                case Pravokutnik -> {
                    GeometricShape temp = Rectangle.conCreate(scanner);
                    if (temp != null) {
                        shapesList.add(temp);
                    } else {
                        badInput();
                    }
                }

                case null -> badInput();
            }
            boolean decision = false;
            while (!decision) {
                System.out.print("Dodati jos jedno? (Y/N): ");
                scanner.nextLine();
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
