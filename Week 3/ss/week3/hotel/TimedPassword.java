package ss.week3.hotel;

public class TimedPassword extends Password {
	private long validTime;
	
	public TimedPassword() {
		validTime = System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 365;	
	}
	
	public TimedPassword(long exp) {
		validTime = System.currentTimeMillis() + exp;
	}
	
	public boolean isExpired() {
		return System.currentTimeMillis() > validTime;
	}
	
	public boolean setWord(String oldPass, String newPass) {
		validTime = System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 365;
		return super.setWord(oldPass, newPass);
	}
}
