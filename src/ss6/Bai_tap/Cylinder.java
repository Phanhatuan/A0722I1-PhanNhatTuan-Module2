package ss6.Bai_tap;

public class Cylinder extends Circle{
    private double height = 1.0;

    public Cylinder() {

    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public Cylinder(double radius, String color, boolean filled, double height) {
        super(radius, color, filled);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea(){
        return super.getArea()*2+2*Math.PI*this.getRadius()*this.getHeight();
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height= " + this.getHeight() +
                ", radius= "+this.getRadius() +
                ", color= " + this.getColor()+
                '}';
    }

    public static void main(String[] args) {
        Cylinder a = new Cylinder(3,"red",true,3);
        System.out.println(a.getArea());
        System.out.println(a.toString());
    }
}
