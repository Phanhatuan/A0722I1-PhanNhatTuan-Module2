package caseStudy.services.Implements;

import caseStudy.models.Action.Booking;
import caseStudy.models.Action.Facility;
import caseStudy.models.Person.Customer;
import caseStudy.services.Interfaces.BookingService;
import caseStudy.utils.CustomerReadAndWriteFileCSV;
import caseStudy.utils.FacilityReadAndWriteFileCSV;

import java.util.*;

public class BookingServiceImpl implements BookingService{
    Scanner sc = new Scanner(System.in);
    private static Set<Booking> bookingList = new TreeSet<>(new BookingComparator());
    private static ArrayList<Customer> customerList = CustomerReadAndWriteFileCSV.readFile();
    private static LinkedHashMap<Facility,Integer> facilityList = FacilityReadAndWriteFileCSV.readAllFile();

    public void displayCustomerList(){
        if(customerList.size() == 0){
            System.out.println("The list is empty");
        }
        else{
            for (Customer customer : customerList) {
                System.out.println(customer.toString());
            }
        }
    }
    public void displayFacilityList() {
        facilityList = FacilityReadAndWriteFileCSV.readAllFile();
        for (Map.Entry<Facility, Integer> item : facilityList.entrySet()) {
            System.out.printf("%s - %s", item.getKey(), item.getValue());
            System.out.println();
        }
    }
    public boolean checkValidCustomerId(int customerId){
        for (Customer customer : customerList) {
           if (customer.getCustomerId() == customerId){
               return true;
           }
        }
        return false;
    }
    public boolean checkValidFacilityId(String facilityId){
        for(Map.Entry<Facility,Integer> item : facilityList.entrySet()){
            if(item.getKey().getServiceId().equals(facilityId)){
                 return true;
            }
        }
        return false;
    }
    public Facility returnFacility(String facilityId){
        Facility a = null;
        for(Map.Entry<Facility,Integer> item : facilityList.entrySet()){
            if(item.getKey().getServiceId().equals(facilityId)){
                a = item.getKey();
            }
        }
        return a;
    }
    public Booking inputBookingInfo(){
        System.out.println("Input start day: "); // need valid
        String beginDay = sc.nextLine();
        System.out.println("Input end day: "); // need valid
        String endDay = sc.nextLine();
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
    @Override
    public void addNewBooking() {
        Booking tempBooking = inputBookingInfo();
        bookingList.add(tempBooking);
    }
    @Override
    public void displayBookingList() {
        for(Booking booking :bookingList){
            System.out.println(booking.toString());
        }
    }

    @Override
    public void creatNewContract() {

    }

    @Override
    public void displayContracts() {

    }

    @Override
    public void editContracts() {

    }

    public static void main(String[] args) {
        BookingServiceImpl a = new BookingServiceImpl();
        a.addNewBooking();
        a.displayBookingList();
    }

}
