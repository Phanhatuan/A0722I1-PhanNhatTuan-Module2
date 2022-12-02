package caseStudy.services.InputAndValidData;

import caseStudy.models.Person.Customer;

import java.util.Scanner;

public class CustomerInputAndValidData {
    // Begin input customer info section
    public static Customer inputCustomerInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Name: ");
        String name = sc.nextLine();

        String birthDay;
        do {
            System.out.println("Input Date Of Birth (\"dd/MM/yyyy\"): ");
            birthDay = sc.nextLine();
        } while (!checkValidDate(birthDay));
        String gender;
        do {
            System.out.println("Input Gender (M|F|O): ");
            gender = sc.nextLine();
        } while (!PersonConst.validGender.matcher(gender).find());

        String id;
        do {
            System.out.println("Input id card (12 numbers): ");
            id = sc.nextLine();
        } while (id.length() != 12);

        String phone;
        do {
            System.out.println("Input phone number (10 numbers): ");
            phone = sc.nextLine();
        } while (!PersonConst.validPhoneNumber.matcher(phone).find());

        String email;
        do {
            System.out.println("Input Email (example: username@gmail.com):: ");
            email = sc.nextLine();
        } while (!PersonConst.validEmail.matcher(email).find());

        String type;
        do {
            System.out.println("Input type of customer (Diamond, Platinum, Gold, Silver, Member): ");
            type = sc.nextLine();
        } while (!PersonConst.validRank.matcher(type).find());

        System.out.println("Input Address: ");
        String address = sc.nextLine();
        return new Customer(name, birthDay, gender, id, phone, email, type, address);
    }
    // End input customer info section
    // Begin validation section
    public static boolean checkValidDate(String day){
        DateValidatorImpl validator = new DateValidatorImpl();
        boolean check = validator.isValid(day);
        return check;
    }
    // End validation section
}
