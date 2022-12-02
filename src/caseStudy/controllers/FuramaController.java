package caseStudy.controllers;

import java.util.Scanner;

public class FuramaController {
    static Scanner sc = new Scanner(System.in);

    public static void mainMenu(){
        int number;
        do {
            System.out.println("1.Employee Management\n" +
                    "2.Customer Management\n" +
                    "3.Facility Management \n" +
                    "4.Booking Management\n" +
                    "5.Promotion Management\n" +
                    "6.Exit");
            System.out.print("Please input number you want: ");
            number = sc.nextInt();
            switch (number) {
                case 1:
                    EmployeeController.processEmployeeController();
                    break;
                case 2:
                    CustomerController.processCustomerController();
                    break;
                case 3:
                    FacilityController.processFacilityController();
                    break;
                case 4:
                    BookingController.processBookingController();
                    break;
                case 5:
                    PromotionController.processPromotionController();
                    break;
                case 6:
                    System.out.println("The system is stopped.");
                    System.exit(0);
            }
        }while (number<6);
    }
}
