package ss.week3.hotel;

public class PricedSafe extends Safe implements Bill.Item {

	private double amount;
	
	public PricedSafe(double amount) {
		this.amount = amount;
	}
	
	@Override
	public double getAmount() {
		return amount;
	}
	
	@Override
	public String toString() {
		return String.format("%-5.2f", amount);
	}

}
