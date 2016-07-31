package Test;

import Model.*;

public class CorrectGenderForRole {
        public static boolean compare (Family fam, Individual husband, Individual wife){
            if (fam.getHusband().getSex() != 'M') {
                System.out.println("Error US21: Incorrect gender for husband " + husband.getGivenName() + " " + husband.getSurName() + "(" + husband.getId() + ") in Family " + fam.getId());
                return false; 
            }
            if (fam.getWife().getSex() != 'F') {
                System.out.println("Error US21: Incorrect gender for wife " + wife.getGivenName() + " " + wife.getSurName()+ "(" + wife.getId() + ") in Family " + fam.getId());
                return false; 
            }
            return true;
        }
    }

