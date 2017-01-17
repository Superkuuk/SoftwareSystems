package ss.week6;

import java.util.Scanner;

public class Hello {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String answer = null;
		do {
			System.out.println("What is your name? ");
			if (in.hasNextLine()) {
				answer = in.nextLine();
				
			}
		} while (answer == null);
		System.out.println("Hello " + answer);
		in.close();
	}
}