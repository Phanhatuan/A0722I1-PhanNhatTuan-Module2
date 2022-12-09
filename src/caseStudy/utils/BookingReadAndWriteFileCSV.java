package caseStudy.utils;

import caseStudy.models.Action.Booking;
import caseStudy.models.Person.Employee;
import caseStudy.services.Implements.BookingComparator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BookingReadAndWriteFileCSV {
    // File booking path
    private static final String FILE_BOOKING_PATH = "D:\\CodeGym\\Module_2\\src\\caseStudy\\data\\booking.csv";

    public static void writeEmployeeCSV(Set<Booking> bookingList)  {
        String data = "";
        for(Booking booking: bookingList){
            data += booking.getInfo();
        }
        try {
            writeFile(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeFile(String data) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_BOOKING_PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(data);
        bufferedWriter.close();
    }
    public static Set<Booking> readFile() {
        Set<Booking> bookingList = new TreeSet<>(new BookingComparator());
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(FILE_BOOKING_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        String temp[];
        Booking booking;
        while(true){
            try {
                if (!((line = bufferedReader.readLine())!=null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            temp = line.split(",");
            String beginDay = temp[0];
            String enDay = temp[1];
            int customerId= Integer.parseInt(temp[2]);
            String serviceName= temp[3];
            String typeService= temp[4];
            booking = new Booking(beginDay,enDay,customerId,serviceName,typeService);
            bookingList.add(booking);
        }
        return bookingList;
    }
}
