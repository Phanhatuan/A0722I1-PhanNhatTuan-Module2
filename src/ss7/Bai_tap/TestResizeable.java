package ss7.Bai_tap;

public class TestResizeable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3.5);
        shapes[1] = new Square(3);
        shapes[2] = new Rectangle(2,3);

        System.out.println("Pre-add:");
        for (Shape shape: shapes) {
            if(shape instanceof Circle){
                System.out.println("Pre-add of circle : " + ((Circle) shape).getArea());
            }
            else if(shape instanceof Square){
                System.out.println("Pre-add of square : " + ((Square)shape).getArea());
            }
            else if(shape instanceof Rectangle){
                System.out.println("Pre-add of rectangle : " + ((Rectangle) shape).getArea());
            }
        }

        System.out.println("After-add:");
        for (Shape shape:shapes) {
            if(shape instanceof Circle){
                System.out.print("After-add of circle : ");
                ((Circle) shape).resize(1.5);
            }
            else if(shape instanceof Square){
                System.out.print("After-add of square : ");
                ((Square)shape).resize(1.5);
            }
            else if(shape instanceof Rectangle){
                System.out.print("After-add of rectangle : ");
                ((Rectangle) shape).resize(1.5);
            }
        }


    }
}
