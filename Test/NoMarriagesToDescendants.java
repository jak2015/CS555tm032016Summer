package Test;

import Model.*;

public class NoMarriagesToDescendants {
    public static boolean compare (Family fam) {
        for (int i = 0; i < fam.getChildIdList().size(); i++) {
            if (fam.getHusbandId().equals(fam.getChildIdList().get(i))) {
                System.out.println("Error: No marriage to descendants: Mother married her child.");
                return false;
            }
            if (fam.getWifeId().equals(fam.getChildIdList().get(i))) {
                System.out.println("Error: No marriage to descendants: Father married his child.");
                return false;
            }
        }
        return true;
    }
}
