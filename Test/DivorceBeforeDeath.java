package Test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DivorceBeforeDeath {
    public static boolean compare (String deathDateString, String divorceDateString, String indId, String famId) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");

        Date divorceDate = format.parse(divorceDateString);
        Date deathDate = format.parse(deathDateString);

        if (divorceDate.compareTo(deathDate) == 1) {
            System.out.println("Error: Divorce date is after the Death date for Individual ID " + indId + " Family ID " +famId);
            return true;
        } else {
            return false;
        }

    }
}
