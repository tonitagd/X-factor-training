package xFactor;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {	
	public static void main(String[] args) {	
		Scanner scan = new Scanner(System.in);
		int input;
		
		do {
			System.out.println("Hi there!" + "\n" + "This is X-Factor!" + "\n" + "Please choose one of the options below:" + "\n"
					+ "1 - 4 Judges, 15 Participants, 5 Stages" + "\n"
					+ "2 - 3 Judges, 8 Participants, 3 Stages"  + "\n"
					+ "To exit, press 0.");
			
			input = scan.nextInt();
		} while(input != 0 && input != 1 && input != 2);
		
		scan.close();
		
		switch(input) {
		case 1:
			System.out.println("4 Judges, 15 Participants, 5 Stages" + "\n");
			
			MainServiceOne one = new MainServiceOne();
			one.doOptionOne();
			break;
		case 2:
			System.out.println("3 Judges, 8 Participants, 3 Stages" + "\n");
			
			MainServiceTwo two = new MainServiceTwo();
			two.doOptionTwo();
			break;
		case 0:
			System.out.println("Exiting...");
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.print("Thank you for choosing X-Factor!");
		}
	}
}