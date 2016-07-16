package Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateBeforeCurrentDate {
    public static boolean compare(String datesString, String id, String event, String entityType) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");

        Date dates = format.parse(datesString);

        Date currentDate = new Date();
        
        

        if (dates.compareTo(currentDate) == 1) {
            System.out.println("Error: " +event+ " date should be less than current date for " +entityType+ " : " +id);
            return false;
        } else {
            return true;
        }
    }
}
