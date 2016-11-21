package ss.week1.DollarsAndCentsCounter;

public class DollarsAndCentsCounter {
	
	private int dollars;
	private int cents;
	
	public DollarsAndCentsCounter() {
		dollars = 0;
		cents = 0;
	}
	
	/**
	*	@ensure this.dollars() >= 0;
	*/
	
	public int dollars() {
		if(dollars < 0){
			dollars = 0;
		}
		return dollars;
	}
	
	/**
	*	@ensure 0 <= this.cents() && this.cents() <= 99;
	*/	
	public int cents() {
		if(cents < 0){
			dollars -= 1;
			cents = 100 + cents;
		}else if(cents > 99){
			dollars += 1;
			cents = cents - 100;
		}
		return cents;
	}
	
	public void add(int dollars, int cents) {
		this.dollars += dollars;
		this.cents += cents;
		this.dollars = dollars();
		this.cents = cents();
	}
	
	/**
	*	@ensure this.dollars() == 0 && this.cents() == 0;
	*/	
	public void reset() {
		dollars = 0;
		cents = 0;
	}
	
	// If we add subtract() we can no longer ensure that dollars() >= 0 or that cents() is between 0 and 99
	
}
