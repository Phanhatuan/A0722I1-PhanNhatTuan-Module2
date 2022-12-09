package On_tap.model;

public class Manager extends Person{
    private String yearOfExp;

    public Manager(String name, int age,String yearOfExp) {
        super(name, age);
        this.yearOfExp=yearOfExp;
    }

    public String getYearOfExp() {
        return yearOfExp;
    }

    public void setYearOfExp(String yearOfExp) {
        this.yearOfExp = yearOfExp;
    }

    @Override
    double calculateSalary() {
        return 3000;
    }

    @Override
    public String toString() {
        return "Manager{" +
                super.toString() +
                "yearOfExp='" + yearOfExp + '\'' +
                '}';
    }
    public String getInfo(){
        return String.format("%s,%s,%s,\n",getName(),getAge(),getYearOfExp());
    }
}
