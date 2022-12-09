package caseStudy.controllers;

import caseStudy.services.Implements.CustomerServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerController {
    static void processCustomerController(){
        Scanner sc = new Scanner(System.in);
        int number =-1;
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        do {
            System.out.println("1.Display list customers\n" +
                    "2.Add new customer\n" +
                    "3.Edit customer\n" +
                    "4.Return main menu");
            System.out.print("Please input number you want: ");
            try {
                number = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Nhap lai");
            }
            switch (number) {
                case 1:
                    customerService.display();
                    break;
                case 2:
                    customerService.add();
                    break;
                case 3:
                    System.out.println("Input id need to edit");
                    int id = Integer.parseInt(String.valueOf(sc.nextInt()));
                    customerService.edit(id);
                    break;
                case 4:
                    System.exit(0);
                    break;

            }
        }while (number<5);
    }
}
