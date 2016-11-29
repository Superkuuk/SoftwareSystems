package ss.week3.hotel;

public class Format {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printLine("vla daksd", 12.45);
		printLine("vla asd", -122.45);
		printLine("vla asd", 83919.45);
	}
	
	public static void printLine(String text, double amount){ 
		System.out.println(String.format("%-10s %15.2f", text, amount ));
	}

}
