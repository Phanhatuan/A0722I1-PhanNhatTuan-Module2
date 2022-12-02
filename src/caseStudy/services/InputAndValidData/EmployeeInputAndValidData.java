package caseStudy.services.InputAndValidData;

import caseStudy.models.Person.Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class EmployeeInputAndValidData {
    // Begin Input employee info section
    public static Employee inputEmployeeInfo() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Name: ");
        String name = sc.nextLine();

        String birthDay;
        do {
            System.out.println("Age must be greater than 18");
            System.out.println("Input Date Of Birth (\"dd/MM/yyyy\"): ");
            birthDay = sc.nextLine();
        }while (!checkValidDate(birthDay) || !checkValidBirthDay(birthDay));

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
            System.out.println("Input Email (example: username@gmail.com): ");
            email = sc.nextLine();
        } while (!PersonConst.validEmail.matcher(email).find());
        String level;
        do {
            System.out.println("Input Level Education (College, University): ");
            level = sc.nextLine();
        }while (!PersonConst.validLevelEducation.matcher(level).find());
        String position;
        do {
            System.out.println("Input Position (Receptionist, Waiter, Specialist, Supervisor, Manager, Director): ");
            position = sc.nextLine();
        }while (!PersonConst.validPosition.matcher(position).find());

        double salary;
        do {
            System.out.println("Input Salary (>0):");
            salary = Double.parseDouble(sc.nextLine());
        }while(salary <= 0);

        return new Employee(name,birthDay,gender,id,phone,email,level,position,salary);
    }
    // End Input employee info section

    // Begin Validation section
    public static boolean checkValidBirthDay(String day)  {
        boolean check = true;
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 18);
        if(calendar.getTime().after(date)==false){
            check = false;
        }
        return check;
    }
    public static boolean checkValidDate(String day){
        DateValidatorImpl validator = new DateValidatorImpl();
        boolean check = validator.isValid(day);
        return check;
    }
    // End Validation section


}
