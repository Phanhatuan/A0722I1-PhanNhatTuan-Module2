package caseStudy.services.Implements;

import caseStudy.models.Action.Booking;
import caseStudy.models.Action.Facility;
import caseStudy.models.Person.Customer;
import caseStudy.services.InputAndValidData.BookingInputAndValidData;
import caseStudy.services.InputAndValidData.DateValidatorImpl;
import caseStudy.services.Interfaces.BookingService;
import caseStudy.utils.BookingReadAndWriteFileCSV;
import caseStudy.utils.CustomerReadAndWriteFileCSV;
import caseStudy.utils.FacilityReadAndWriteFileCSV;

import java.util.*;

public class BookingServiceImpl implements BookingService{
    Scanner sc = new Scanner(System.in);
    private static Set<Booking> bookingList = new TreeSet<>(new BookingComparator());
    public void increaseQuantityFacility(){
        LinkedHashMap<Facility,Integer> facilityList =FacilityReadAndWriteFileCSV.readAllFile();
        for(Map.Entry<Facility,Integer> item : facilityList.entrySet()){

            System.out.printf("%s - %s",item.getKey(),item.getValue());
            System.out.println();
        }
    }
    @Override
    public void addNewBooking() {
        bookingList = BookingReadAndWriteFileCSV.readFile();
        Booking tempBooking = BookingInputAndValidData.inputBookingInfo();
        bookingList.add(tempBooking);
        BookingReadAndWriteFileCSV.writeEmployeeCSV(bookingList);
    }
    @Override
    public void displayBookingList() {
        bookingList = BookingReadAndWriteFileCSV.readFile();
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
        a.displayBookingList();
    }
}