package caseStudy.utils;

import caseStudy.models.Person.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeReadAndWriteFileCSV {
    //File employee csv
    private static final String FILE_EMPLOYEE_PATH = "D:\\CodeGym\\Module_2\\src\\caseStudy\\data\\employee.csv";

    // Begin Write read file section
    public static void writeEmployeeCSV(List<Employee> list)  {
        String data = "";
        for(Employee employee: list){
            data += employee.getInfo();
        }
        try {
            writeFile(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeFile(String data) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_EMPLOYEE_PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(data);
        bufferedWriter.close();
    }
    public static ArrayList<Employee> readFile() {
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
}
