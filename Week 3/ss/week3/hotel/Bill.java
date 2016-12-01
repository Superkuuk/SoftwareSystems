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
	
	public void newItem(Bill.Item item) {
		sum += item.getAmount();
		
		if (outStream != null) {
			outStream.println(item.toString());
		}
	}
	
	public void close() {
		if (outStream != null) {
			outStream.println(sum);
		}
	}
	
	/*@ pure */public double getSum() {
		return sum;
	}
}