package Test;
import java.text.ParseException;
import java.util.List;
import Model.Family;
import Model.Individual;

public class MarriageOfSiblings {
	public static boolean compare (Family fam, List<Family> families ) throws ParseException {
	List<Individual> childList = fam.getChildList();
	
	for (int k = 0; k < families.size(); k++) {
		String husbandId = families.get(k).getHusbandId();
		String wifeId = families.get(k).getWifeId();
		String child_husband =null;
		String child_hname =null;
		String child_wname =null;

		String child_wife =null;
		for (int j = 0; j < fam.getChildList().size(); j++) {
			childList.get(j).getId();
			if (childList.get(j).getId().equalsIgnoreCase(husbandId)){
				 child_husband = childList.get(j).getId();
				 child_hname = childList.get(j).getGivenName();
			}
			if (childList.get(j).getId().equalsIgnoreCase(wifeId)){
				 child_wife = childList.get(j).getId();
				 child_wname = childList.get(j).getGivenName();

			}
			
		}
		if (child_husband!=null && child_wife !=null){
			System.out.println("Anamoly US18: Siblings "+child_hname+" (" +child_husband+")" + " and " +child_wname+" (" +child_wife+")" + " should not marry");
		}
	}
	
	return true;
	}
	
}
