package Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Model.Individual;

public class MultipleBirths {
	public static boolean compare (List<Individual> childList, String famId ) throws ParseException {
		ArrayList<String> birthDateList = new ArrayList<String>();
		
		for (int j = 0; j < childList.size(); j++) {
			if (childList.get(j).getBirthDate()!= null) {
			birthDateList.add(childList.get(j).getBirthDate());
		}
			}
		
		Set<String> birthDate = new HashSet<String>(birthDateList);
					
		for (String date : birthDate) {
			int count =0;
			for (int k = 0; k < childList.size(); k++) {
				if (date != null && childList.get(k).getBirthDate()!= null ){
					if (date.equalsIgnoreCase(childList.get(k).getBirthDate())){
						count= count+1;
					}
				}
			}
			if (count >5){
				System.out.println("Anamoly US14: "+count+" siblings are born at the same time: " + date+ " for Family Id: "+ famId);
			}
		}
		

		return true;

	}
}
