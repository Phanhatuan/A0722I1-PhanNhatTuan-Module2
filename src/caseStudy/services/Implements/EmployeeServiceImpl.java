package caseStudy.services.Implements;

import caseStudy.models.Person.Employee;
import caseStudy.services.InputAndValidData.EmployeeInputAndValidData;
import caseStudy.services.Interfaces.EmployeeService;
import caseStudy.utils.EmployeeReadAndWriteFileCSV;

import java.text.ParseException;
import java.util.*;

public class EmployeeServiceImpl implements EmployeeService {
    Scanner sc = new Scanner(System.in);
    // Employee list
    private static ArrayList<Employee> employeeList = new ArrayList<>();

    // Begin CRUD section
    @Override
    public void display() {
        employeeList = EmployeeReadAndWriteFileCSV.readFile();
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
            temp = EmployeeInputAndValidData.inputEmployeeInfo();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employeeList = EmployeeReadAndWriteFileCSV.readFile();
        employeeList.add(temp);
        EmployeeReadAndWriteFileCSV.writeEmployeeCSV(employeeList);
        System.out.println("File employee CSV updated new employee");
    }
    @Override
    public void edit(int employeeId) {
        boolean found = false;
        employeeList = EmployeeReadAndWriteFileCSV.readFile();
        for (int i = 0; i < employeeList.size(); i++) {
            if(employeeId == employeeList.get(i).getEmployeeId()){
                Employee temp = null;
                try {
                    temp = EmployeeInputAndValidData.inputEmployeeInfo();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                employeeList.remove(i);
                employeeList.add(i,temp);
                found = true;
                EmployeeReadAndWriteFileCSV.writeEmployeeCSV(employeeList);
            }
        }
        if (found == false){
            System.out.println("Not found");
        }
    }
    // End CRUD section
}
