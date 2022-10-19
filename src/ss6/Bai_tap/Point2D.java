package ss6.Bai_tap;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point2D() {
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y){
        this.x=x;
        this.y=y;
    }

    public float[] getXY(){
        float[] arr = {this.x,this.y};
        return arr;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
        Point2D a = new Point2D(3,2);
        System.out.println(a.getX());
        System.out.println(a.getY());
        System.out.println(a.toString());
        float[] arrData = a.getXY();
        System.out.println("Array values:");
        for(int i=0;i<arrData.length;i++) {
            System.out.print(arrData[i] + " ");
        }
    }
}
