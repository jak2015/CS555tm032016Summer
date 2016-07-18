import Model.Family;
import Model.Individual;
import Processor.ParseData;
import java.lang.Exception;
import java.util.Collections;
import java.util.*;
import java.util.List;
import Test.*;

public class readFile {

	public static void main(String[] args) {
		String filename = null;
		try { 
	    	// The name of the file to open.
	    	   filename = args[0];    	   
	       }
	       
	       catch (ArrayIndexOutOfBoundsException e){
	     	  System.out.println("File name not provided as argument");
	     	  System.exit(1);
	     	 }
	       
		ParseData p = new ParseData();
		try {
			p.readFile(filename);
			
			System.out.println("=== Individuals Information ===");
			for (int i = 0; i < p.individuals.size(); i++) {
				Individual ind = p.individuals.get(i);
				System.out.println("ID: " + ind.getId());
				System.out.println("Given Name: " + ind.getGivenName());
				System.out.println("Family Name: " + ind.getSurName());
				System.out.println("Sex: " + ind.getSex());
				System.out.println("Birth Date: " + ind.getBirthDate());
				if (ind.getDeathDate() != null) {
					System.out.println("Death Date: " + ind.getDeathDate());
				}
				System.out.println();
			}
			
			System.out.println("=== Families Information ===");
			for (int i = 0; i < p.families.size(); i++) {
				System.out.println("");
				Family fam = p.families.get(i);
				System.out.println("Family ID: " + fam.getId());
				System.out.println("Family HUSBAND: " + fam.getHusband().getName());
				System.out.println("Family Wife: " + fam.getWife().getName());
				System.out.println("Family Wedding Date: " + fam.getWeddingDate());
				System.out.println("Family Divorce Date: " + fam.getDivorceDate());
				
				for (int j = 0; j < fam.getChildList().size(); j++) {
					System.out.println("Family Child: " + fam.getChildList().get(j).getName());
				}
				
				List<Individual> childList = fam.getChildList();
				Collections.sort(childList);
				for (int j = 0; j < fam.getChildList().size(); j++) {
					System.out.println("Family Siblings: " + childList.get(j).getName() + " Age: " + childList.get(j).getAge());
				}		

			}
			System.out.println();
			
			System.out.println("=== Errors and Anomalies Information for Individuals ===");
			for (int i = 0; i < p.individuals.size(); i++) {
				Individual ind = p.individuals.get(i);
				
				Test.UniqueID.checkUniqueId(ind, p.individuals);

				if (ind.getDeathDate() != null) {
					Test.BirthBeforeDeath.compare(ind.getBirthDate(), ind.getDeathDate(), ind.getId(), "Birth", "Individual");
				}
				
				if (ind.getBirthDate() != null) {
					Test.DateBeforeCurrentDate.compare(ind.getBirthDate(), ind.getId(), "Birth", "Individual");
				}
				if (ind.getDeathDate() != null) {
					Test.DateBeforeCurrentDate.compare(ind.getDeathDate(), ind.getId(), "Death", "Individual");
				}	
			}
			System.out.println();
			
			System.out.println("=== Errors and Anomalies Information for Families ===");
			for (int i = 0; i < p.families.size(); i++) {
				Family fam = p.families.get(i);
			if (fam.getDivorceDate() != null && fam.getWeddingDate() != null) {
				Test.MarriageBeforeDivorce.compare(fam.getWeddingDate(), fam.getDivorceDate());
			}

			if (fam.getHusband() != null && fam.getWeddingDate() != null)
				Test.MarriageBeforeDeath.compare(fam.getHusband().getBirthDate(), fam.getWeddingDate());

			if (fam.getWife() != null && fam.getWeddingDate() != null)
				Test.MarriageBeforeDeath.compare(fam.getWife().getBirthDate(), fam.getWeddingDate());
			
			if (fam.getHusband() != null && fam.getWeddingDate() != null)
				Test.BirthBeforeMarriage.compare(fam.getHusband().getBirthDate(), fam.getWeddingDate(), fam.getHusbandId(), fam.getId());

			if (fam.getWife() != null && fam.getWeddingDate() != null)
				Test.BirthBeforeMarriage.compare(fam.getWife().getBirthDate(), fam.getWeddingDate(),  fam.getWifeId(), fam.getId());
			
			if (fam.getWeddingDate() != null) {
				Test.DateBeforeCurrentDate.compare(fam.getWeddingDate(), fam.getId(), "Wedding", "Family");
			}
			
			if (fam.getDivorceDate() != null) {
				Test.DateBeforeCurrentDate.compare(fam.getDivorceDate(), fam.getId(), "Divorce", "Family");
			}
			
			if (fam.getHusband() != null && fam.getWeddingDate() != null){
				Test.MarriageAfter14.compare(fam.getHusband().getBirthDate(), fam.getWeddingDate(), fam.getHusband().getId(),fam.getId(), "Marriage", "Individual");
			}

			if (fam.getWife() != null && fam.getWeddingDate() != null){
				Test.MarriageAfter14.compare(fam.getWife().getBirthDate(), fam.getWeddingDate(), fam.getWife().getId() ,fam.getId(), "Marriage", "Individual");
			}
			CompareLastNames.check(fam);
			
			if (fam.getHusband().getDeathDate() != null && fam.getDivorceDate() != null)
				Test.DivorceBeforeDeath.compare(fam.getHusband().getDeathDate(), fam.getDivorceDate(), fam.getHusbandId() ,fam.getId());

			if (fam.getWife().getDeathDate() != null && fam.getDivorceDate() != null)
				Test.DivorceBeforeDeath.compare(fam.getWife().getDeathDate(), fam.getDivorceDate(), fam.getWifeId() ,fam.getId());
			
			for (int j = 0; j < fam.getChildList().size(); j++) {
				if (fam.getChildList().get(j).getBirthDate() != null && fam.getDivorceDate() != null){
					Test.ChildBirthBeforeParentsMarriage.compareDivorce(fam.getChildList().get(j).getBirthDate(), fam.getDivorceDate(), fam.getChildList().get(j).getId());
				}
				if (fam.getChildList().get(j).getBirthDate() != null && fam.getWeddingDate() !=null){
					Test.ChildBirthBeforeParentsMarriage.compareMarriage(fam.getChildList().get(j).getBirthDate(), fam.getWeddingDate(), fam.getChildList().get(j).getId());
				}
			}
			
			for (int j = 0; j < fam.getChildList().size(); j++) {
				if (fam.getChildList().get(j).getBirthDate() != null && fam.getWife().getBirthDate() != null)
					Test.ChildBirthBeforeDeathOfParent.compare(fam.getChildList().get(j).getBirthDate(), fam.getWife().getBirthDate());
			}
			
			for (int j = 0; j < fam.getChildList().size(); j++) {
				if (fam.getChildList().get(j).getBirthDate() != null && fam.getWife().getBirthDate() != null && fam.getHusband().getBirthDate() != null)
					Test.ParentsNotTooOld.compare(fam.getChildList().get(j).getBirthDate(), fam.getHusband().getBirthDate(), fam.getWife().getBirthDate(), fam.getChildList().get(j).getId(),fam.getWife().getId(), fam.getHusband().getId());
			}
			
			Test.FewerThan15Siblings.compare(fam);
			Test.NoMarriagesToDescendants.compare(fam);
			Test.MarriageOfSiblings.compare(fam, p.families);
			Test.MultipleBirths.compare(fam.getChildList(), fam.getId());

		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}