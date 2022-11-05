package caseStudy.services;

import caseStudy.models.Employee;

import java.util.List;

public interface EmployeeService extends Service{
    void display();

    void add();

    void edit(int employeeId);
}
