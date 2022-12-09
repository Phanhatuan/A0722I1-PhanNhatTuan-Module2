package caseStudy.services.InputAndValidData;

import caseStudy.models.Action.Booking;
import caseStudy.models.Action.Facility;
import caseStudy.models.Person.Customer;
import caseStudy.services.Implements.BookingComparator;
import caseStudy.utils.CustomerReadAndWriteFileCSV;
import caseStudy.utils.FacilityReadAndWriteFileCSV;

import java.util.*;

public class BookingInputAndValidData {
    Scanner sc = new Scanner(System.in);
    private static Set<Booking> bookingList = new TreeSet<>(new BookingComparator());
    private static ArrayList<Customer> customerList = CustomerReadAndWriteFileCSV.readFile();
    private static LinkedHashMap<Facility,Integer> facilityList = FacilityReadAndWriteFileCSV.readAllFile();
    // Begin input Booking info
    public static Booking inputBookingInfo(){
        Scanner sc = new Scanner(System.in);
        String beginDay;
        do {
            System.out.println("Input start day: ");
            beginDay = sc.nextLine();
        }while (!checkValidDate(beginDay));
        String endDay;
        do {
            System.out.println("Input end day: ");
            endDay = sc.nextLine();
        }while (!checkValidDate(endDay));
        displayCustomerList();
        int customerId;
        do {
            System.out.println("Input Customer Id: ");
            customerId = Integer.parseInt(sc.nextLine());
        }while (!checkValidCustomerId(customerId));
        displayFacilityList();
        String facilityId;
        do {
            System.out.println("Input Facility Id: ");
            facilityId = sc.nextLine();
        }while (!checkValidFacilityId(facilityId));
        String serviceName = returnFacility(facilityId).getServiceName();
        String typeService = returnFacility(facilityId).getClass().getSimpleName();
        return new Booking(beginDay,endDay,customerId,serviceName,typeService);
    }
    // End input Booking info
    // Begin validate data section and display info
    public static void displayCustomerList(){
        if(customerList.size() == 0){
            System.out.println("The list is empty");
        }
        else{
            for (Customer customer : customerList) {
                System.out.println(customer.toString());
            }
        }
    }
    public static void displayFacilityList() {
        facilityList = FacilityReadAndWriteFileCSV.readAllFile();
        for (Map.Entry<Facility, Integer> item : facilityList.entrySet()) {
            System.out.printf("%s - %s", item.getKey(), item.getValue());
            System.out.println();
        }
    }
    public static boolean checkValidCustomerId(int customerId){
        for (Customer customer : customerList) {
            if (customer.getCustomerId() == customerId){
                return true;
            }
        }
        return false;
    }
    public static boolean checkValidFacilityId(String facilityId){
        for(Map.Entry<Facility,Integer> item : facilityList.entrySet()){
            if(item.getKey().getServiceId().equals(facilityId)){
                return true;
            }
        }
        return false;
    }
    public static Facility returnFacility(String facilityId){
        Facility temp = null;
        for(Map.Entry<Facility,Integer> item : facilityList.entrySet()){
            if(item.getKey().getServiceId().equals(facilityId)){
                temp = item.getKey();
            }
        }
        return temp;
    }
    public static boolean checkValidDate(String day){
        DateValidatorImpl validator = new DateValidatorImpl();
        boolean check = validator.isValid(day);
        return check;
    }
    // End validate data section and display info

}
