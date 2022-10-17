package ss4.Bai_tap;

public class Fan {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST  = 3;

    private int speed = 1;
    private boolean status = false;
    private double radius = 5;
    private String color = "blue";

    public Fan() {

    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String toString(){
        if(this.status == true){
            return "Fan is on. Speed: "+this.getSpeed()+", Color: "+this.getColor()+", Radius = " + this.getRadius();
        }
        else {
            return "Fan is off, Speed = " + this.getSpeed() + ", Color: "+this.getColor()+", Radius = " + this.getRadius();
        }
    }

    public static void main(String[] args) {
        Fan Fan1 = new Fan();
        Fan1.setSpeed(FAST);
        Fan1.setRadius(10);
        Fan1.setColor("yellow");
        Fan1.setStatus(true);
        System.out.println(Fan1.toString());

        Fan Fan2 = new Fan();
        Fan2.setSpeed(MEDIUM);
        Fan2.setRadius(5);
        Fan2.setColor("blue");
        System.out.println(Fan2.toString());
    }
}
