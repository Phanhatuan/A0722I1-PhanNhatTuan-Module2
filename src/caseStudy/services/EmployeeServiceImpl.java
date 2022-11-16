package caseStudy.services;

import caseStudy.models.Employee;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService{
    Scanner sc = new Scanner(System.in);
    private static ArrayList<Employee> employeeList = new ArrayList<Employee>();
    static {
        employeeList.add(new Employee("Nguyen Van A", "2/2/2002", "Man",
                "11223344", "0123456789", "employee1@gmail.com",
                "Intern", "Finance", 1000));
        employeeList.add(new Employee("Nguyen Van B", "22/12/2002", "Man",
                "11223344", "0123456789", "employee1@gmail.com",
                "Intern", "Finance", 2000));
    }

    @Override
    public void display() {
        if(employeeList.size()==0){
            System.out.println("The list is empty");
        }
        else{
            for (Employee employee : employeeList) {
                System.out.println(employee.toString());
            }
        }
    }
    public boolean checkValidDate(String day){
        DateValidatorImpl validator = new DateValidatorImpl();
        boolean check = validator.isValid(day);
        return check;
    }
    public Employee inputEmployeeInfo(){
        System.out.println("Input Name: ");
        String name = sc.nextLine();

        String birthDay;
        do {
            System.out.println("Input Date Of Birth (\"dd/MM/yyyy\"): ");
            birthDay = sc.nextLine();
        }while (checkValidDate(birthDay) == false);

        System.out.println("Gender: ");
        String gender = sc.nextLine();
        System.out.println("Input id: ");
        String id = sc.nextLine();
        System.out.println("Input phone number: ");
        String phone =sc.nextLine();
        System.out.println("Input Email: ");
        String email = sc.nextLine();
        System.out.println("Input Level: ");
        String level = sc.nextLine();
        System.out.println("Input Position: ");
        String position = sc.nextLine();
        System.out.println("Input Salary :");
        double salary = sc.nextDouble();
        return new Employee(name,birthDay,gender,id,phone,email,level,position,salary);
    }
    @Override
    public void add() {
        Employee temp = inputEmployeeInfo();
        employeeList.add(temp);
    }

    @Override
    public void edit(int employeeId) {
        boolean found = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if(employeeId==employeeList.get(i).getEmployeeId()){
                Employee temp = inputEmployeeInfo();
                employeeList.remove(i);
                employeeList.add(i,temp);
                found = true;
            }
        }
        if (found == false){
            System.out.println("Not found");
        }
    }

    public static void main(String[] args) {
        EmployeeServiceImpl n = new EmployeeServiceImpl();
        n.add();
        n.display();
        //n.edit(1);
        //n.display();

    }
}
