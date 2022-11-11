package ss11.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/M/yyyy");
        String date = sc.nextLine();     //yyyy-MM-dd

        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);
        String localDate1 = localDate.format(formatter);
        System.out.println(localDate1);
    }
}
