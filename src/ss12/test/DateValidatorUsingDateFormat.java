package ss12.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class DateValidatorUsingDateFormat implements DateValidator {
    private String dateFormat = "dd/MM/yyyy";


    @Override
    public boolean isValid(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        DateValidatorUsingDateFormat validator = new DateValidatorUsingDateFormat();
        System.out.println(validator.isValid("29/2/2020"));

    }
}