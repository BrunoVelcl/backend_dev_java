import java.util.InputMismatchException;
import java.util.Scanner;

public class Triangle extends GeometricShape {

    public Triangle(double sideA, double sideB, double sideC){
        super(enumShape.Trokut, calcArea(sideA, sideB, sideC),sideA + sideB + sideC);
    }

    private static double calcArea(double sideA, double sideB, double sideC){
        double s = sideA + sideB + sideC;
        return Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC));
    }

    public static GeometricShape conCreate(Scanner scanner){
        double sideA, sideB, sideC;
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
        try{
            sideC = scanSide("stranicu C: ", scanner);
        } catch (InputMismatchException e) {
            return null;
        }
        return new Triangle(sideA, sideB, sideC);
    }

}
