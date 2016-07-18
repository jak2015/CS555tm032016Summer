package Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MarriageAfter14 {

    public static void compare(String birthDateString, String marriageDateString, String indId, String famId, String name) {

        try {
            SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");

            Date birthDate = format.parse(birthDateString);
            Date marriageDate = format.parse(marriageDateString);

            long diff = marriageDate.getTime() - birthDate.getTime();
            long diffHours = diff / (60 * 60 * 1000);
            long diffDays = diffHours / 24; // 48
            long diffYear = diffDays / 365;
            if (diffYear < 14) {
                System.out.println("Error US10: Marriage should occur after 14 years for "+ name +" (" +indId +") "+ "in Family " +famId);
            }
        } catch (Exception ex) {

        }
    }
}
