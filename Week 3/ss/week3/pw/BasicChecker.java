package ss.week3.pw;

public class BasicChecker implements Checker {
	
	public static final String INITIAL = "generated";
	
	/**
	 * Tests if the given password is an acceptable password by
	 * checking if it is longer than 6 characters and does not
	 * contain any spaces.
	 */
	@Override
	public boolean acceptable(String pass) {
		return pass.length() >= 6 && !pass.contains(" ");
	}
	
	@Override
	public String generatePassword() {
		return INITIAL;
	}

}