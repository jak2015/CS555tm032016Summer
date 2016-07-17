package Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MarriageAfter14 {

    public static void compare(String birthDateString, String marriageDateString, String indId, String famId, String event, String entityType) {

        try {
            SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");

            Date birthDate = format.parse(birthDateString);
            Date marriageDate = format.parse(marriageDateString);

            long diff = marriageDate.getTime() - birthDate.getTime();
            long diffHours = diff / (60 * 60 * 1000);
            long diffDays = diffHours / 24; // 48
            long diffYear = diffDays / 365;
            if (diffYear < 14) {
                System.out.println("Error: " +event+ " before 14 years old for " +entityType+ " id " +indId+ " with Family id " +famId);
            }
        } catch (Exception ex) {

        }
    }
}
