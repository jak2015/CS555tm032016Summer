package Test;

import Model.Individual;
import java.util.List;

public class UniqueNameBirth {
	 public static boolean checkUniqueNameBirth(Individual ind, List<Individual> individuals) {
	        String indGivenName = ind.getGivenName();
	        String indSurName = ind.getSurName();
	        String indBirth = ind.getBirthDate();
	        for (int i = 0; i < individuals.size(); i++) {
	            String givenName = individuals.get(i).getGivenName();
	            String surName = individuals.get(i).getSurName();
	            String birth = individuals.get(i).getBirthDate();
	            String id = individuals.get(i).getId();
	            if (indGivenName!= null && indSurName != null && indBirth != null && givenName!=null && surName!=null && birth!=null ){
	            if (!individuals.get(i).equals(ind) && indGivenName.equals(givenName) && indSurName.equals(surName)  && indBirth.equals(birth)) {
	                System.out.println("Error US23: Individual "+ ind.getGivenName() + " " + ind.getSurName() +" (" +ind.getId() +") " +"mathches with another Individual" +" (" +id +") " + "with same Name and Date of Birth: " + birth);

	                return false;
	            }
	        }
	        }
	        return true;
	    }
}
