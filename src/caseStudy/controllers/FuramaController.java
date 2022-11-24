package caseStudy.controllers;

import caseStudy.services.Implements.CustomerServiceImpl;
import caseStudy.services.Implements.EmployeeServiceImpl;

import java.util.Scanner;

public class FuramaController {
        public void displayMainMenu(){
            Scanner sc = new Scanner(System.in);
            int choice = -1;
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management ");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            do {
                System.out.println("Please enter your valid choice (1->6): ");
                choice = sc.nextInt();
            } while (choice > 6 || choice < 0);

            switch (choice){
                case 1 :
                    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
                    System.out.println("1 Display list employees");
                    System.out.println("2 Add new employee");
                    System.out.println("3 Edit employee");
                    System.out.println("4 Return main menu");
                    choice = sc.nextInt();
                    switch (choice){
                        case 1:
                            employeeService.display();
                            break;
                        case 2:
                            employeeService.add();
                            employeeService.display();
                            break;
                        case 3:
                            employeeService.display();
                            System.out.print("Input employee id: ");
                            int employeeId = sc.nextInt();
                            employeeService.edit(employeeId);
                            employeeService.display();
                            break;
                        default:
                            System.exit(0);

                    }
                    break;
                case 2 :
                    CustomerServiceImpl customerService = new CustomerServiceImpl();
                    System.out.println("1 Display list customers");
                    System.out.println("2 Add new customer");
                    System.out.println("3 Edit customer");
                    System.out.println("4 Return main menu");
                    choice = sc.nextInt();
                    switch (choice){
                        case 1:
                            customerService.display();
                            break;
                        case 2:
                            customerService.add();
                            customerService.display();
                            break;
                        case 3:
                            customerService.display();
                            System.out.print("Input customer id: ");
                            int employeeId = sc.nextInt();
                            customerService.edit(employeeId);
                            customerService.display();
                            break;
                        default:
                            System.exit(0);
                    }
                    break;
                case 3 :
                    System.out.println("1 Display list facility");
                    System.out.println("2 Add new facility");
                    System.out.println("3 Display list facility maintenance");
                    System.out.println("4 Return main menu");
                    break;
                case 4 :
                    System.out.println("1 Add new booking");
                    System.out.println("2 Display list booking");
                    System.out.println("3 Create new contracts");
                    System.out.println("4 Display list contracts");
                    System.out.println("5 Edit contracts");
                    System.out.println("6 Return main menu");
                    break;
                case 5 :
                    System.out.println("1 Display list customers use service");
                    System.out.println("2 Display list customers get voucher");
                    System.out.println("3 Return main menu");
                    break;
                case 6 :
                    System.exit(0);
            }
        }

    public static void main(String[] args) {
        FuramaController a = new FuramaController();
        a.displayMainMenu();
    }
}
