package xFactor;

import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Main {	
	public static void main(String[] args) {	
		Scanner scan = new Scanner(System.in);
		System.out.println("Hi there!" + "\n" + "This is X-Factor!" + "\n" + "Please choose one of the options below:" + "\n"
				+ "1 - 4 Judges, 15 Participants, 5 Stages" + "\n"
				+ "2 - 3 Judges, 8 Participants, 3 Stages"  + "\n"
				+ "To exit, press 0.");
		
		int input = scan.nextInt();
		scan.close();
		
		switch(input) {
			case 1: {
				Application app = new Application();
				
				System.out.println("4 Judges, 15 Participants, 5 Stages" + "\n");
				
				Competition.setNumberOfStages(5);
				
				app.createJudges(4);
				Competition.printJudges();
				
				app.giveSpecialVote("Elena Marinova");
				app.printSpecialJudge();
				
				app.createParticipants(15);
				
				app.createStage(1, 15);
				
				app.addQualitiesForParticipants();
				
				app.printParticipantsInfo();
				
				app.printJudgesInfo();
				
				app.addJudgesFavourites(app.getStage(1));
				
				app.printFavourites(app.getStage(1));
				
				app.printParticipantsInStage(app.getStage(1));
				
				app.judgesVote(app.getStage(1));
				
				app.qualifyParticipants(app.getStage(1));
				
				app.checkForWinner(app.getStage(1));
				
				app.printQualifiedParticipants(app.getStage(1));
				Set<Participant> participantsNext1 = app.getQualified(app.getStage(1));
				app.createStage(2, 10);
				app.getStage(2).setParticipantsInStage(participantsNext1);
				app.printParticipantsInStage(app.getStage(2));
				
				app.judgesVote(app.getStage(2));
				app.qualifyParticipants(app.getStage(2));
				app.checkForWinner(app.getStage(2));
				app.printQualifiedParticipants(app.getStage(2));
				
				Set<Participant> participantsNext2 = app.getQualified(app.getStage(2));
				app.createStage(3, 10);
				app.getStage(3).setParticipantsInStage(participantsNext2);
				app.printParticipantsInStage(app.getStage(3));
				
				app.judgesVote(app.getStage(3));
				app.qualifyParticipants(app.getStage(3));
				app.checkForWinner(app.getStage(3));
				app.printQualifiedParticipants(app.getStage(3));
				break;
			}
			case 2: {
				Application app = new Application();
				
				System.out.println("3 Judges, 8 Participants, 3 Stages" + "\n");
				
				Competition.setNumberOfStages(3);
				
				app.createJudges(3);
				Competition.printJudges();
				
				app.createParticipants(8);
				
				app.createStage(1, 8);
				
				app.addQualitiesForParticipants();
				
				app.printParticipantsInfo();
				
				app.printJudgesInfo();
				
				app.addJudgesFavourites(app.getStage(1));
				
				app.printFavourites(app.getStage(1));
				
				app.printParticipantsInStage(app.getStage(1));
				
				app.judgesVote(app.getStage(1));
				
				app.qualifyParticipants(app.getStage(1));
				
				app.checkForWinner(app.getStage(1));
				
				app.printQualifiedParticipants(app.getStage(1));
				Set<Participant> participantsNext1 = app.getQualified(app.getStage(1));
				app.createStage(2, 5);
				app.getStage(2).setParticipantsInStage(participantsNext1);
				app.printParticipantsInStage(app.getStage(2));
				
				app.judgesVote(app.getStage(2));
				app.qualifyParticipants(app.getStage(2));
				app.checkForWinner(app.getStage(2));
				app.printQualifiedParticipants(app.getStage(2));
				
				Set<Participant> participantsNext2 = app.getQualified(app.getStage(2));
				app.createStage(3, 2);
				app.getStage(3).setParticipantsInStage(participantsNext2);
				app.printParticipantsInStage(app.getStage(3));
				
				app.judgesVote(app.getStage(3));
				app.qualifyParticipants(app.getStage(3));
				app.checkForWinner(app.getStage(3));
				app.printQualifiedParticipants(app.getStage(3));
				break;
			}
			case 0:
				System.out.println("Exiting...");
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.print("Thank you for choosing X-Factor!");
				break;
			default:
				System.out.print("Incorrect option. Please try again.");
		}
	}
}