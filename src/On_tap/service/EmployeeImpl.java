package On_tap.service;

import On_tap.model.Employee;
import On_tap.utils.EmployeeReadAndWrite;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeImpl {
    Scanner sc = new Scanner(System.in);

    private static ArrayList<Employee> employeeList = new ArrayList<>();
    public Employee inputEmployeeInfo(){
        System.out.println("Name: ");
        String name = sc.nextLine();
        boolean check;
        int age = -1;
        do {
            try{
                System.out.println("Age: ");
                age = Integer.parseInt(sc.nextLine());
                check = true;
            } catch (NumberFormatException e){
                System.out.println("Nhap lai");
                check = false;
            }
        }while(!check);

        System.out.println("Type: ");
        String type = sc.nextLine();
        return new Employee(name,age,type);
    }
    public void addNew(){
        employeeList = EmployeeReadAndWrite.readFile();
        Employee temp = inputEmployeeInfo();
        employeeList.add(temp);
        EmployeeReadAndWrite.writeEmployeeCSV(employeeList);
    }
    public void display(){
        employeeList = EmployeeReadAndWrite.readFile();
        for(Employee employee : employeeList){
            System.out.println(employee.toString());
        }
    }

    public static void main(String[] args) {
        EmployeeImpl a = new EmployeeImpl();
        a.addNew();
        a.display();
    }
}
