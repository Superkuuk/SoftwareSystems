package ss.week6.dictionaryattack;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
	 */
	public void readPasswords(String filename) {
		passwordMap = new HashMap<>();
		try {
        	BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
        	while ((line = reader.readLine()) != null) {
        		String username = line.split(": ")[0];
        		String password = line.split(": ")[1];
        		passwordMap.put(username, password);
        		
            }
        	reader.close();

        } catch (IOException e) {
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
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] digest = md.digest(password.getBytes());
			return Hex.encodeHexString(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * Checks the password for the user the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
        if (passwordMap.containsKey(user) && passwordMap.get(user).equals(getPasswordHash(password))) {
        	return true;
        } else {
        	return false;
        }
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
	 * @param filename filename of the dictionary.
	 */
    public void addToHashDictionary(String filename) {
    	hashDictionary = new HashMap<>();
		try {
        	BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
        	while ((line = reader.readLine()) != null) {
        		String password = line;
        		String hash = getPasswordHash(password);
        		hashDictionary.put(hash, password);
            }
        	reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }      
	}
    
	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		addToHashDictionary("Dictionary.txt");
		readPasswords("LeakedPasswords.txt");
        int i = 0;
		for (Map.Entry<String, String> entry : passwordMap.entrySet()) {
		    if (hashDictionary.containsKey(entry.getValue())) {
		    	System.out.println(entry.getKey() + " has password: "
		    			+ hashDictionary.get(entry.getValue()) + " (" + entry.getValue() + ")");
		    	i++;
		    } else {
		    	System.out.println(entry.getKey() + " cannot get password.");
		    }
		    System.out.println(i);
		}
		
	}
	public static void main(String[] args) {
		DictionaryAttack da = new DictionaryAttack();
		// To implement
		da.doDictionaryAttack();
	}

}
