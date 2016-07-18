package Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BirthBeforeDeath {
    public static boolean compare(String birthDateString, String deathDateString, String id, String event, String entityType) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");

        Date birthDate = format.parse(birthDateString);
        Date deathDate = format.parse(deathDateString);

        if (birthDate.compareTo(deathDate) == 1) {
            System.out.println("Error: " +event+ " date is after the death date for " +entityType+ " with id " +id);
            return false;
        } else {
            return true;
        }

    }
}
