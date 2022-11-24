package ss16.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) throws ParseException {
       /* Scanner sc = new Scanner(System.in);
        Pattern p = Pattern.compile("^[A-Z][a-z]{3,19}$");
        while(true){
            System.out.println("Input txt: ");
            String str = sc.nextLine();
            if(p.matcher(str).find()){
                System.out.println("ok");
            }
            else{
                System.out.println("not ok");
            }
        }*/
        String dateString = "27-11-2004";
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 18);
        System.out.printf("Date %s is older than 18? %s", dateString, calendar.getTime().after(date));
        System.out.println( calendar.getTime().after(date));
    }
}
