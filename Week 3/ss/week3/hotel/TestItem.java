package ss.week3.hotel;

public class TestItem implements Bill.Item {
	
	private String text;
	private double amount;
	
	public TestItem(String text, double amount) {
		this.text = text;
		this.amount = amount;
	}

	@Override
	public double getAmount() {
		return amount;
	}
	
	@Override
	public String toString() {
		return String.format("%-10s %15.2f", text, amount);
	}
}
