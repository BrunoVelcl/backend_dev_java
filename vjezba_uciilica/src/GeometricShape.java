import java.util.InputMismatchException;
import java.util.Scanner;

public class GeometricShape implements Comparable<GeometricShape> {
    protected enumShape shape;
    protected double area;
    protected double perimeter;

    public enumShape getShape() {
        return shape;
    }

    public double getArea() {
        return this.area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public GeometricShape(enumShape shape, double area, double perimeter){
        this.shape = shape;
        this.area = area;
        this.perimeter = perimeter;
    }

    protected static double scanSide(String side, Scanner scanner)throws InputMismatchException {
        System.out.print("Unesite " + side);
        return scanner.nextDouble();
    }

    @Override
    public int compareTo(GeometricShape o) {
        return Double.compare(this.area, o.area);
    }
}
