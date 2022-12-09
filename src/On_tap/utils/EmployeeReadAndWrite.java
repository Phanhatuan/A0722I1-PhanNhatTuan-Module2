package On_tap.utils;

import On_tap.model.Employee;
import caseStudy.models.Person.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeReadAndWrite {
    private static final String FILE_EMPLOYEE_PATH = "D:\\CodeGym\\Module_2\\src\\On_tap\\data\\employee.csv";
    public static void writeEmployeeCSV(List<Employee> list){
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
        ArrayList<Employee> employees = new ArrayList<>();
        Customer.setIdOrder(0);
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
            int age = Integer.parseInt(temp[1]);
            String type = temp[2];
            employee = new Employee(name,age,type);
            employees.add(employee);
        }
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
