package ss.week3.pw;

public class StrongChecker extends BasicChecker implements Checker {
	
	public static final String INITIAL = "generated1";
	
	/**
	 * Tests if the given password is an acceptable password by
	 * checking if it is acceptable by it's superclass, i.e. BasicChecker,
	 * and also if the first letter is a character and the last a digit.
	 */
	@Override
	public boolean acceptable(String pass) {
		return super.acceptable(pass) && Character.isLetter(pass.charAt(0)) 
				&& Character.isDigit(pass.charAt(pass.length() - 1));
	}

	@Override
	public String generatePassword() {
		return INITIAL;
	}
}
