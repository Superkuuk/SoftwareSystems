package ss.week3.hotel;

public class Bill {

	public static interface Item {
		double getAmount();
		
		String toString();
	}

	private java.io.PrintStream outStream;
	private double sum;
	
	public Bill(java.io.PrintStream theOutStream) {
		outStream = theOutStream;
	}
	
	public Bill() {
		outStream = null;
	}
	
	public void newItem(Bill.Item item) {
		sum += item.getAmount();
		
		assert outStream != null;
		outStream.println(item.toString());
	}
	
	public void close() {
		assert outStream != null;
		outStream.println(sum);
	}
	
	/*@ pure */public double getSum() {
		return sum;
	}
}