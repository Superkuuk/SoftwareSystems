package ss.week1.hotel;

public class Password {

	public static String INITIAL = "safePass";
	private String password;
	
	public Password() {
		password = Password.INITIAL;
	}

	public boolean acceptable(String suggestion) {
		return suggestion.length() > 6 && !suggestion.contains(" ");
	}
	
	public boolean testWord(String test) {
		return test.equals(password);
	}
	
	public boolean setWord(String oldpass, String newpass) {
		if (oldpass == password && acceptable(newpass)) {
			password = newpass;
		} else {
			return false;
		}
		return true;
	}
	
}
