package ss7.Bai_tap;

public class TestColorable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3.5);
        shapes[1] = new Square(3);
        shapes[2] = new Rectangle(2,3);
        System.out.println("Show color (if exist): ");
        for (Shape shape:shapes){
            if(shape instanceof Square){
                ((Square)shape).howToColor();
            }
        }
    }
}
