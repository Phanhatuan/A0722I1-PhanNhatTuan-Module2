package caseStudy.controllers;

import caseStudy.models.Action.Facility;
import caseStudy.services.Implements.FacilityServiceImpl;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FacilityController {
    static void processFacilityController() {
        Scanner sc = new Scanner(System.in);
        int number;
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        do {
            System.out.println("1.Display list facility\n" +
                    "2.Add new facility\n" +
                    "3.Display list facility maintenance\n" +
                    "4.Return main menu");
            System.out.print("Please input number you want: ");
            number = sc.nextInt();
            switch (number) {
                case 1:
                    facilityService.display();
                    break;
                case 2:
                    facilityService.add();
                    break;
                case 3:
                    facilityService.displayFacilityNeedRepair();
                    break;
                case 4:
                    System.exit(0);
                    break;

            }
        }while (number<5);
    }

}
