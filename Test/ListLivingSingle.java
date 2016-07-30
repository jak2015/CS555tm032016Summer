package Test;

import Model.Individual;

public class ListLivingSingle 
{
    public static void list(Individual ind) 
    {
    	if (ind.getDeathDate() == null && ind.getSpouse() == null && ind.getAge() > 30.0) 
        {
    		System.out.println("Error US31: "+ ind.getGivenName() + " " + ind.getSurName() +" (" +ind.getId() +") " +"is over 30 years and has never been married");
        }
    }
}
