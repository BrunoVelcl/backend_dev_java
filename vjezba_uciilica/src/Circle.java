import java.util.InputMismatchException;
import java.util.Scanner;

public class Circle extends GeometricShape {

    public Circle(double radius){
        super(enumShape.Krug, Math.pow(radius, 2) * Math.PI, radius * Math.PI * 2);
    }

    public static GeometricShape conCreate(Scanner scanner){
        double radius;
        try{
            radius = scanSide("radijus: ", scanner);
        } catch (InputMismatchException e) {
            return null;
        }

        return new Circle(radius);
    }
}
