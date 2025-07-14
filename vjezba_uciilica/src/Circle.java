public class Circle extends GeometricShape {
    private final double radius;

    public Circle(double radius){
        this.type = enumShape.Krug;
        this.radius = radius;
        calcArea();
        calcPerimeter();
    }

    @Override
    protected void calcArea() {
        this.area =  Math.pow(this.radius, 2) * Math.PI;
    }

    @Override
    protected void calcPerimeter() {
        this.perimeter = this.radius * Math.PI * 2;
    }

}
