package Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChildBirthBeforeParentsMarriage {
	 public static boolean compareMarriage (String childBirthStr, String marriageDateString, String id ) throws ParseException {
	        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");

	        Date childBirthDate = format.parse(childBirthStr);
	        Date marriageDate = format.parse(marriageDateString);

	        if (marriageDate.compareTo(childBirthDate) == 1) {
	            System.out.println("Error: Birth Date of Child " + id+ " is before parents Marriage");
	            return true;
	        } else {
	            return false;
	        }

	    }
	 public static boolean compareDivorce (String childBirthStr, String divorceDateString, String id ) throws ParseException {
	        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");

	        Date childBirthDate = format.parse(childBirthStr);
	        Date divorceDate = format.parse(divorceDateString);

	        if (divorceDate.compareTo(childBirthDate) != 1) {
	            System.out.println("Error: Birth Date of Child " + id+ " is after parents Divorce");
	            return true;
	        } else {
	            return false;
	        }

	    }
}
