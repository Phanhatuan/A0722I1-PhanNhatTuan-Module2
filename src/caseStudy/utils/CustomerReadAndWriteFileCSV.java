package caseStudy.utils;

import caseStudy.models.Person.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerReadAndWriteFileCSV {
    // File customer path
    private static final String FILE_CUSTOMER_PATH = "D:\\Furama Management\\src\\Resort_Management\\data\\customer.csv";
    // Begin write read file section
    public static void writeCustomerCSV(List<Customer> list){
        String data = "";
        for(Customer customer: list){
            data += customer.getInfo();
        }
        try {
            writeFile(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeFile(String data) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_CUSTOMER_PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(data);
        bufferedWriter.close();
    }
    public static ArrayList<Customer> readFile() {
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
}
