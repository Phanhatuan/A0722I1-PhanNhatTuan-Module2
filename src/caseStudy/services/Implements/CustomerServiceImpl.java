package caseStudy.services.Implements;

import caseStudy.models.Person.Customer;
import caseStudy.services.InputAndValidData.CustomerInputAndValidData;
import caseStudy.services.Interfaces.CustomerService;
import caseStudy.utils.CustomerReadAndWriteFileCSV;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    Scanner sc = new Scanner(System.in);
    // Customer list
    private static ArrayList<Customer> customerList = new ArrayList<>();

    // Begin CRUD section
    @Override
    public void display() {
        customerList = CustomerReadAndWriteFileCSV.readFile();
        if(customerList.size()==0){
            System.out.println("The list is empty");
        }
        else{
            for (Customer customer : customerList) {
                System.out.println(customer.toString());
            }
        }
    }
    @Override
    public void add() {
        Customer temp = CustomerInputAndValidData.inputCustomerInfo();
        customerList = CustomerReadAndWriteFileCSV.readFile();
        customerList.add(temp);
        CustomerReadAndWriteFileCSV.writeCustomerCSV(customerList);
        System.out.println("File customer CSV updated new customer");

    }
    @Override
    public void edit(int customerId) {
        boolean found = false;
        customerList = CustomerReadAndWriteFileCSV.readFile();
        for (int i = 0; i < customerList.size(); i++) {
            if(customerId == customerList.get(i).getCustomerId()){
                Customer temp = CustomerInputAndValidData.inputCustomerInfo();
                customerList.remove(i);
                customerList.add(i,temp);
                found = true;
                CustomerReadAndWriteFileCSV.writeCustomerCSV(customerList);
            }
        }
        if (found == false){
            System.out.println("Not found");
        }
    }
    // End CRUD section

}
