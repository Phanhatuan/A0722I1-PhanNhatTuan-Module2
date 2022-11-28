package caseStudy.services.Implements;

import caseStudy.models.Person.Employee;
import caseStudy.services.Interfaces.EmployeeService;
import ss17.Thuc_hanh.Student;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EmployeeServiceImpl implements EmployeeService {
    Scanner sc = new Scanner(System.in);
    // Employee list
    private static ArrayList<Employee> employeeList = new ArrayList<>();
    //File employee csv
    private static final String FILE_EMPLOYEE_PATH = "D:\\CodeGym\\Module_2\\src\\caseStudy\\data\\employee.csv";

    //Begin Write read file section
    public void writeEmployeeCSV()  {
       String data = "";
       for(Employee employee: employeeList){
           data += employee.getInfo();
       }
        try {
            writeFile(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeFile(String data) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_EMPLOYEE_PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(data);
        bufferedWriter.close();
    }
    public ArrayList<Employee> readFile() {
        ArrayList<Employee> employeeList1 = new ArrayList<>();
        Employee.setIdOrder(0); // Reset IdOder !important
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(FILE_EMPLOYEE_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        String temp[];
        Employee employee;
        while(true){
            try {
                if (!((line = bufferedReader.readLine())!=null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            temp = line.split(",");
            String name = temp[0];
            String birthDay = temp[1];
            String gender= temp[2];
            String id= temp[3];
            String tel= temp[4];
            String email= temp[5];
            String levelEducation= temp[6];
            String position= temp[7];
            double salary = Double.parseDouble(temp[8]);
            employee = new Employee(name,birthDay,gender,id,tel,email,levelEducation,position,salary);
            employeeList1.add(employee);
        }
         return employeeList1;
    }
    // End Write read file section

    // Begin CRUD section
    @Override
    public void display() {
        employeeList = readFile();
        if(employeeList.size()==0){
            System.out.println("The list is empty");
        }
        else{
            for (Employee employee : employeeList) {
                System.out.println(employee.toString());
            }
        }
    }
    @Override
    public void add() {
        Employee temp = null;
        try {
            temp = inputEmployeeInfo();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employeeList = readFile();
        employeeList.add(temp);
        writeEmployeeCSV();
        System.out.println("File employee CSV updated new employee");
    }
    @Override
    public void edit(int employeeId) {
        boolean found = false;
        employeeList = readFile();
        for (int i = 0; i < employeeList.size(); i++) {
            if(employeeId == employeeList.get(i).getEmployeeId()){
                Employee temp = null;
                try {
                    temp = inputEmployeeInfo();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                employeeList.remove(i);
                employeeList.add(i,temp);
                found = true;
                writeEmployeeCSV();
            }
        }
        if (found == false){
            System.out.println("Not found");
        }
    }
    // End CRUD section

    // Begin Validation section
    public boolean checkValidBirthDay(String day)  {
        boolean check = true;
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 18);
        if(calendar.getTime().after(date)==false){
            check = false;
        }
        return check;
    }
    public boolean checkValidDate(String day){
        DateValidatorImpl validator = new DateValidatorImpl();
        boolean check = validator.isValid(day);
        return check;
    }
    // End Validation section

    // Begin Input employee info section
    public Employee inputEmployeeInfo() throws ParseException {
        System.out.println("Input Name: ");
        String name = sc.nextLine();

        String birthDay;
        do {
            System.out.println("Age must be greater than 18");
            System.out.println("Input Date Of Birth (\"dd/MM/yyyy\"): ");
            birthDay = sc.nextLine();
        }while (!checkValidDate(birthDay) || !checkValidBirthDay(birthDay));

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
    // End Input employee info section
}
