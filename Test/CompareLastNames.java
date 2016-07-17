package Test;

import Model.Family;

import java.util.*;

public class CompareLastNames {
    public static boolean check(Family fam) {
        List<String> nameStringList = new ArrayList<String>();

        nameStringList.add(fam.getHusband().getGivenName());

        for (int i = 0; i < fam.getChildList().size(); i++) {
            if (fam.getChildList().get(i).getSex() == 'M')
                nameStringList.add(fam.getChildList().get(i).getGivenName());
        }
        
        for (int i = 0; i < nameStringList.size(); i++) {
            for (int j = i + 1; j < nameStringList.size(); j++) {
                if (!nameStringList.get(i).equals(nameStringList.get(j)))
                	System.out.println("Error: Male members " +nameStringList.get(i) + " and " +nameStringList.get(j) +" of family id " +fam.getId()+ " does not have same last names.");

                    return false;
            }
        }
        return true;
    }
}
