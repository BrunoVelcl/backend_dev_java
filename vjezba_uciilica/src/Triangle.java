public class Triangle extends GeometricShape{
    private final double sideA;
    private final double sideB;
    private final double sideC;

    public Triangle(double sideA, double sideB, double sideC){
        this.type = enumShape.Trokut;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        calcArea();
        calcPerimeter();
    }

    @Override
    protected void calcArea(){
        double s = sideA + sideB + sideC;
        this.area =  Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC));
    }

    @Override
    public void calcPerimeter() {
        this.perimeter = sideA + sideB + sideC;
    }


}

