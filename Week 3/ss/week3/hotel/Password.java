package ss.week3.hotel;
import ss.week3.pw.*;

public class Password {

	public static String INITIAL = "safePass";
	private String password;
	private Checker checker;
	private String factoryPassword;
	
	public Password() {
		this(new BasicChecker());
	}
	
	public Password(Checker checker) {
		this.checker = checker;
		factoryPassword = this.checker.generatePassword();
		password = factoryPassword;
	}

	public boolean acceptable(String suggestion) {
		return suggestion.length() > 6 && !suggestion.contains(" ");
	}
	
	public boolean testWord(String test) {
		return test.equals(password);
	}
	
	public boolean setWord(String oldpass, String newpass) {
		if (oldpass.equals(password) && acceptable(newpass)) {
			password = newpass;
		} else {
			return false;
		} 
		return true;
	}
	
	public Checker getChecker() {
		return checker;
	}
	
	public String getFactoryPassword() {
		return factoryPassword;
	}
	
}
