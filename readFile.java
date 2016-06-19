import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class readFile {
	public static void main(String[] args) {
		String filename = "My-Family-21-May-2016.ged";
		String line = null;		
		
		try {
			FileReader reader = new FileReader(filename);
			BufferedReader br = new BufferedReader(reader);
			
			if((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
			while ((line = br.readLine()) != null) {
				System.out.println("");
				
				// line1
				System.out.println(line);
				
				// Splitting the line into words
				String[] words = line.split(" ");
				
				//line 2 should print level
				System.out.println("Level is " + words[0]); 
				
				//line 3 should print tag
				System.out.print("Tag is ");
				if(Integer.parseInt(words[0]) == 0) {
					if(isValidTag(words[1]) == false) {
						if(isValidTag(words[2]) == false) {
							System.out.println("Invalid");	
						}
						else {
							System.out.println(words[2]);
						}	
					}
					else {
						System.out.println(words[1]);
					}	
				}
				else {
					System.out.println( (isValidTag(words[1]) ? words[1] : "Invalid") );
				}
			}
			br.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isValidTag(String tagName) {
		
		String validTags[] = {"SEX", "BIRT", "DEAT", "INDI","NAME","FAMC","FAMS","FAM","MARR","HUSB","WIFE","CHIL","DIV","DATE","HEAD","TRLR","NOTE"};
		
		if(Arrays.asList(validTags).contains(tagName)) {
			return true;
		}
		else {
			return false;
		}
		
	}

}