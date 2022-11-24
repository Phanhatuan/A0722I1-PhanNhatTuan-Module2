package caseStudy.models.Person;

import caseStudy.models.Person.Person;

public class Employee extends Person {
    private static int idOrder = 0;
    private int employeeId;
    private String levelEducation;
    private String position;
    private double salary;

    public Employee() {
        this.employeeId = idOrder++;
    }

    public Employee(String name, String birthDay, String gender, String id, String tel, String email, String levelEducation, String position, double salary) {
        super(name, birthDay, gender, id, tel, email);
        this.employeeId = idOrder++;
        this.levelEducation = levelEducation;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getLevelEducation() {
        return levelEducation;
    }

    public void setLevelEducation(String levelEducation) {
        this.levelEducation = levelEducation;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name = " + getName() + '\'' +
                " birthDay = " +getBirthDay() + '\'' +
                " gender = " + getGender() + '\'' +
                " id = " + getId() + '\'' +
                " tel = " + getTel() + '\'' +
                " email = " + getEmail() + '\'' +
                " employeeId =" + employeeId + '\'' +
                ", levelEducation ='" + levelEducation + '\'' +
                ", position ='" + position + '\'' +
                ", salary =" + salary +
                '}';
    }
}
