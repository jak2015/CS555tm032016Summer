package Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ChildBirthBeforeDeathOfParent {
    public static boolean compare(String birthDateString, String deathDateOfMotherString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");

        Date birthDate = format.parse(birthDateString);
        Date deathDate = format.parse(deathDateOfMotherString);

        if (birthDate.compareTo(deathDate) == 1) {
            System.out.println("Error: Child Birth is after mother's death date.");
            return false;
        } else {
            return true;
        }

    }
}
