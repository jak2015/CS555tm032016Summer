package Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BirthBeforeMarriage {
    public static boolean compare (String birthDateString, String marriageDateString, String indId, String famId) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");

        Date birthDate = format.parse(birthDateString);
        Date marriageDate = format.parse(marriageDateString);

        if (birthDate.compareTo(marriageDate) == 1) {
            System.out.println("Error: Birth date should be before the marriage date for Individual: "+ indId + " in family " + famId);
            return true;
        } else {
            return false;
        }
    }
}
