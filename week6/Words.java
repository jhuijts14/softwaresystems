package ss.week6;

import java.util.Scanner;

/**
 * The class Words, uses a Scanner object to read and print a line until the 
 * word "end" is typed in. Each word is printed separately also.
 * @author Joep Huijts
 * @version 0.0
 *
 */
public class Words {

	
	// Create and use Scanner to read a line. Line and words in line are printed.
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Line (or \"end\"): ");
		
		while (in.hasNextLine()) { 
			if (in.hasNext("end")) {
				System.out.println("End of programme.");
				in.close();

			} else {
				String word;
				int index = 1;
				Scanner input = new Scanner(in.nextLine());

				while (input.hasNext()) {

					word = input.next();
					System.out.printf("Word %d: %s\n", index, word);
					index++;
				}

			}
		}

	}

}
