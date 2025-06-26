public abstract class GeometricShape implements Comparable<GeometricShape>{

    protected enumShape type;
    protected double area;
    protected double perimeter;
    protected abstract void calcArea();
    protected abstract void calcPerimeter();

    public enumShape getType() {
        return type;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public int compareTo(GeometricShape o) {
        return Double.compare(this.perimeter, o.perimeter);
    }
}