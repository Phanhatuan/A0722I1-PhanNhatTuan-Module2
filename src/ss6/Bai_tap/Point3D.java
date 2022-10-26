package ss6.Bai_tap;

public class Point3D extends Point2D{
    private float z = 0.0f;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z){
        super.setX(x);
        super.setY(y);
        this.z = z;
    }

    public float[] getXYZ(){
        float[] arr = {super.getX(),super.getY(),this.z};
        return arr;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + super.getX() +
                ", y=" + super.getY() +
                ", z=" + this.z +
                '}';
    }

    public static void main(String[] args) {
        Point3D a = new Point3D(1,2,3);
        a.setXYZ(4,5,6);
        System.out.println(a.toString());
        float[] arrData = a.getXYZ();
        System.out.println("Array values:");
        for(int i=0;i<arrData.length;i++) {
            System.out.print(arrData[i] + " ");
        }
    }
}
