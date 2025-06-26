public class Rectangle extends GeometricShape {
    private final double sideA;
    private final double sideB;

    public Rectangle(double sideA, double sideB){
        this.type = enumShape.Pravokutnik;
        this.sideA = sideA;
        this.sideB = sideB;
        calcArea();
        calcPerimeter();
    }


    @Override
    protected void calcArea() {
        this.area = sideA * sideB;
    }

    @Override
    protected void calcPerimeter() {
        this.perimeter = 2 * sideA + 2 * sideB;
    }
}
