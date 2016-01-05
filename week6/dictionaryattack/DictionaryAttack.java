package ss.week6.dictionaryattack;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class DictionaryAttack {
	private Map<String, String> passwordMap;
	private Map<String, String> hashDictionary;

	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled with the content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename
	 * @throws FileNotFoundException  - if the file with the input filename isn't found.
	 */
	public void readPasswords(String filename) {
		Scanner in;
		try {
			in = new Scanner(new FileReader(filename));
			
			passwordMap = new HashMap<String, String>();
		
			while (in.hasNextLine()) {
				String[] temp = in.nextLine().split(": ");

				passwordMap.put(temp[0], temp[1]);
			}

			in.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password
	 * @return
	 */
	public String getPasswordHash(String password) {
		byte[] passwordBytes = password.getBytes();
    	byte[] passwordMD5;
    	String passwordHex;
		MessageDigest md = null;
		
		try {
			md = MessageDigest.getInstance("MD5", new sun.security.provider.Sun());
			
		
		} catch (NoSuchAlgorithmException e) {
			System.out.println("I'm sorry the MD5 algorythm can't be used!");
			e.printStackTrace();
			System.exit(-1);
		}
		
		passwordMD5 = md.digest(passwordBytes);
		passwordHex = Hex.encodeHexString(passwordMD5);
		return passwordHex;
    		
	}
	/**
	 * Checks the password for the user the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
        
        return passwordMap.containsKey(user) && passwordMap.get(user).equals(getPasswordHash(password));
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
	 * @param filename filename of the dictionary.
	 */
    public void addToHashDictionary(String filename) {
        if (hashDictionary == null) {
        	hashDictionary = new HashMap<String, String>();
        }
        
    	Scanner in;
		try {
			in = new Scanner(new FileReader(filename));
			
			
	        
	        while (in.hasNextLine()) {
	        	String origPassword = in.nextLine();
	        	
	        	hashDictionary.put(getPasswordHash(origPassword), origPassword);
	        }
	        
	        in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
	/**
	 * Do the dictionary attack.
	 * @throws FileNotFoundException 
	 */
	public void doDictionaryAttack() {
		readPasswords("/Users/joep/Documents/Twente/SoftwareSystems/eclipse/workspace/"
						+ "SS/src/ss/week6/test/LeakedPasswords.txt");
		addToHashDictionary("/Users/joep/Documents/Twente/SoftwareSystems/eclipse/workspace/"
						+ "SS/src/ss/week6/dictionaryattack/password_dictionary.txt");
		
		for (String usrname : passwordMap.keySet()) {
			if (hashDictionary.get(passwordMap.get(usrname)) != null) {

				if (checkPassword(usrname, hashDictionary.get(passwordMap.get(usrname)))) {
					System.out.println(usrname + ": " 
									+ hashDictionary.get(passwordMap.get(usrname)));
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		DictionaryAttack da = new DictionaryAttack();
		// To implement
		da.doDictionaryAttack();
	}

}
