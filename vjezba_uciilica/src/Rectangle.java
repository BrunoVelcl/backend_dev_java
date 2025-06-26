import java.util.InputMismatchException;
import java.util.Scanner;

public class Rectangle extends GeometricShape {
    public Rectangle(double sideA, double sideB){
        super(enumShape.Pravokutnik, sideA * sideB, sideA * 2 + sideB *2);
    }

    public static GeometricShape conCreate(Scanner scanner){
        double sideA, sideB;
        try{
            sideA = scanSide("stranicu A: ", scanner);
        } catch (InputMismatchException e) {
            return null;
        }
        try{
            sideB = scanSide("stranicu B: ", scanner);
        } catch (InputMismatchException e) {
            return null;
        }
        return new Rectangle(sideA, sideB);
    }
}
