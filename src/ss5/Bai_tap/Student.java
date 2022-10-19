package ss5.Bai_tap;

public class Student {
    private String name ="John";
    private String classes = "CO2";
    public static int a = 5;
    public Student() {
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
}
