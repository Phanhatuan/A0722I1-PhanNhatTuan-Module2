package caseStudy.services.Implements;

import caseStudy.models.Person.Customer;
import caseStudy.services.Interfaces.CustomerService;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    Scanner sc = new Scanner(System.in);
    // Customer list
    private static ArrayList<Customer> customerList = new ArrayList<>();
    // File customer path
    private static final String FILE_CUSTOMER_PATH = "D:\\CodeGym\\Module_2\\src\\caseStudy\\data\\customer.csv";

    // Begin write read file section
    public void writeCustomerCSV()  {
        String data = "";
        for(Customer customer: customerList){
            data += customer.getInfo();
        }
        try {
            writeFile(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeFile(String data) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_CUSTOMER_PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(data);
        bufferedWriter.close();
    }
    public ArrayList<Customer> readFile() {
        ArrayList<Customer> customerList = new ArrayList<>();
        Customer.setIdOrder(0);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(FILE_CUSTOMER_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        String temp[];
        Customer customer;
        while(true){
            try {
                if (!((line = bufferedReader.readLine())!=null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            temp = line.split(",");
            String name = temp[0];
            String birthDay = temp[1];
            String gender= temp[2];
            String id= temp[3];
            String tel= temp[4];
            String email= temp[5];
            String typeCustomer= temp[6];
            String address= temp[7];
            customer = new Customer(name,birthDay,gender,id,tel,email,typeCustomer,address);
            customerList.add(customer);
        }
        return customerList;
    }
    // End write read file section

    // Begin CRUD section
    @Override
    public void display() {
        customerList = readFile();
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
        Customer temp = inputCustomerInfo();
        customerList = readFile();
        customerList.add(temp);
        writeCustomerCSV();
        System.out.println("File customer CSV updated new customer");

    }
    @Override
    public void edit(int customerId) {
        boolean found = false;
        customerList = readFile();
        for (int i = 0; i < customerList.size(); i++) {
            if(customerId == customerList.get(i).getCustomerId()){
                Customer temp = inputCustomerInfo();
                customerList.remove(i);
                customerList.add(i,temp);
                found = true;
                writeCustomerCSV();
            }
        }
        if (found == false){
            System.out.println("Not found");
        }
    }
    // End CRUD section

    // Begin validation section
    public boolean checkValidDate(String day){
        DateValidatorImpl validator = new DateValidatorImpl();
        boolean check = validator.isValid(day);
        return check;
    }
    // End validation section

    // Begin input customer info section
    public Customer inputCustomerInfo(){
        System.out.println("Input Name: ");
        String name = sc.nextLine();

        String birthDay;
        do {
            System.out.println("Input Date Of Birth (\"dd/MM/yyyy\"): ");
            birthDay = sc.nextLine();
        }while (!checkValidDate(birthDay));

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
    // End input customer info section

}
