package caseStudy.controllers;

import caseStudy.services.Implements.EmployeeServiceImpl;

import java.util.Scanner;

public class EmployeeController {
    static void processEmployeeController() {
        Scanner sc = new Scanner(System.in);
        int number ;
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        do {
            System.out.println("1.Display list employees\n" +
                    "2.Add new employee\n" +
                    "3.Edit employee\n" +
                    "4.Return main menu");
            System.out.print("Please input number you want: ");
            number = sc.nextInt();
            switch (number) {
                case 1:
                    employeeService.display();
                    break;
                case 2:
                    employeeService.add();
                    break;
                case 3:
                    System.out.println("Input id need to edit");
                    int id = Integer.parseInt(String.valueOf(sc.nextInt()));
                    employeeService.edit(id);
                    break;
            }
        }while (number<4);
    }
}
