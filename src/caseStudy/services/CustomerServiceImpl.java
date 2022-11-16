package caseStudy.services;

import caseStudy.models.Customer;
import caseStudy.models.Employee;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService{

    Scanner sc = new Scanner(System.in);
    private static ArrayList<Customer> customerList = new ArrayList<Customer>();
    static {
        customerList.add(new Customer("Nguyen Van A", "2/2/2002", "Man",
                "11223344", "0123456789", "customer@gmail.com",
                "Vip", "Viet Nam"));
        customerList.add(new Customer("Nguyen Van B", "22/12/2002", "Man",
                "11223344", "0123456789", "customer@gmail.com",
                "Vip", "Viet Nam"));
    }

    @Override
    public void display() {
        if(customerList.size()==0){
            System.out.println("The list is empty");
        }
        else{
            for (Customer customer : customerList) {
                System.out.println(customer.toString());
            }
        }
    }
    public boolean checkValidDate(String day){
        DateValidatorImpl validator = new DateValidatorImpl();
        boolean check = validator.isValid(day);
        return check;
    }
    public Customer inputCustomerInfo(){
        System.out.println("Input Name: ");
        String name = sc.nextLine();

        String birthDay;
        do {
            System.out.println("Input Date Of Birth (\"dd/MM/yyyy\"): ");
            birthDay = sc.nextLine();
        }while (checkValidDate(birthDay) == false);

        System.out.println("Input Gender: ");
        String gender = sc.nextLine();
        System.out.println("Input id: ");
        String id = sc.nextLine();
        System.out.println("Input phone number: ");
        String phone =sc.nextLine();
        System.out.println("Input Email: ");
        String email = sc.nextLine();
        System.out.println("Input type of customer: ");
        String type = sc.nextLine();
        System.out.println("Input Address: ");
        String address = sc.nextLine();
        return new Customer(name,birthDay,gender,id,phone,email,type,address);
    }
    @Override
    public void add() {
        Customer temp = inputCustomerInfo();
        customerList.add(temp);
    }

    @Override
    public void edit(int employeeId) {
        boolean found = false;
        for (int i = 0; i < customerList.size(); i++) {
            if(employeeId==customerList.get(i).getCustomerId()){
                Customer temp = inputCustomerInfo();
                customerList.remove(i);
                customerList.add(i,temp);
                found = true;
            }
        }
        if (found == false){
            System.out.println("Not found");
        }
    }

    public static void main(String[] args) {
       CustomerServiceImpl a = new CustomerServiceImpl();
       a.display();
       a.add();
        a.display();

    }
}
