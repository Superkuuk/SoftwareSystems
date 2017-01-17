package ss.week6;

import java.util.Scanner;

public class Words {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Line (or 'end')");
		int i = 1;
		
		while (true) {
			String a = in.next();
			if (a.equals("end")) {
				break;
			}
			System.out.println("Word " + i + ": " + a);
			i++;
		}
		System.out.println("End of programme.");
		in.close();
	}
}