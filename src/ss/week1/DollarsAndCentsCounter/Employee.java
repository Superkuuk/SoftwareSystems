package ss.week1.DollarsAndCentsCounter;

public class Employee {
	private int hours; 		// hours worked in the week
	private double rate;	// hourly pay rate
	
	public Employee(int hours, double rate) {
		this.hours = hours;
		this.rate = rate;
	}
	
	public double pay(){
		return hours > 40 ? (hours - 40) * rate * 1.5 + 40 * rate : hours * rate;
	}
}
