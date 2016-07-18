package Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ChildBirthBeforeDeathOfParent {
    public static boolean compare(String birthDateString, String deathDateOfMotherString, String uid, String name, String fid) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");

        Date birthDate = format.parse(birthDateString);
        Date deathDate = format.parse(deathDateOfMotherString);

        if (birthDate.compareTo(deathDate) == 1) {
            System.out.println("Error US09: Birth date of " +name +" (" +uid +") "+"occurs after his/her mother's death date in Family "+fid);
            return false;
        } else {
            return true;
        }
    
    }
}
