package ss.week6;

import java.util.Scanner;

/**
 * The Hello class, uses a Scanner object to 
 * read a name, and then prints it.
 * @author Joep Huijts
 * @version 0.0
 *
 */
public class Hello {

	// Main method that creates and uses the Scanner object.
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		
		
		boolean value = true;
		
		while (value) {
			
			System.out.print("Enter a name: ");
			String name = ""; 
			
			if (in.hasNextLine()) {
				
				name = in.nextLine();
			} 

			value = !name.isEmpty();
			
			if (value) {
				System.out.printf("Hello \nName is %s \n", name);
			}
		} 
		in.close();
		
		
	}
}
