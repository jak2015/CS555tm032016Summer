package Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BirthBeforeMarriage {
    public static boolean compare (String birthDateString, String marriageDateString, String id, String Gname, String Sname, String fid) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");

        Date birthDate = format.parse(birthDateString);
        Date marriageDate = format.parse(marriageDateString);

        if (birthDate.compareTo(marriageDate) == 1) {
            System.out.println("Error US02: Birth date of "+ Gname + " " + Sname +" (" +id +") " +"occurs after his/her marriage date in Family id "+fid);
            return true;
        } else {
            return false;
        }
    }
}
