package On_tap.model;

public class Employee extends Person{
    private String type;

    public Employee(String name, int age,String type ) {
        super(name, age);
        this.type=type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    double calculateSalary() {
        return 1000;
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                "type='" + type + '\'' +
                '}';
    }
    public String getInfo(){
        return String.format("%s,%s,%s\n",getName(),getAge(),getType());
    }
}
