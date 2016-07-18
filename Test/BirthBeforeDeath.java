package Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BirthBeforeDeath {
    public static boolean compare(String birthDateString, String deathDateString, String id, String Gname, String Sname) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");

        Date birthDate = format.parse(birthDateString);
        Date deathDate = format.parse(deathDateString);

        if (birthDate.compareTo(deathDate) == 1) {
            System.out.println("Error US03: Birth date of "+ Gname + " " + Sname +" (" +id +") " +"occurs after his/her death date");

            return false;
        } else {
            return true;
        }

    }
}
