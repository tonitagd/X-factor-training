package xFactor;

import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Main {	
	public static void main(String[] args) {
		ParticipantServiceImpl participant = new ParticipantServiceImpl();
		JudgeServiceImpl judge = new JudgeServiceImpl();
		StageServiceImpl stage = new StageServiceImpl();
		PersonServiceImpl person = new PersonServiceImpl();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Hi there!" + "\n" + "This is X-Factor!" + "\n" + "Please choose one of the options below:" + "\n"
				+ "1 - 4 Judges, 15 Participants, 5 Stages" + "\n"
				+ "2 - 3 Judges, 8 Participants, 3 Stages"  + "\n"
				+ "To exit, press 0.");
		
		int input = scan.nextInt();
		
		switch(input) {
			case 1: {
				System.out.println("You chose option " + input + ": 4 Judges, 15 Participants, 5 Stages" + "\n");
				
				Competition.setNumberOfStages(5);
				
				//Create judges
				Judge judge1 = new Judge("Martin", "Momov", 36, "male", "Sofia", 3);
				Judge judge2 = new Judge("Elena", "Marinova", 36, "male", "Sofia", 3);
				Judge judge3 = new Judge("Delyan", "Lilov", 36, "female", "Sofia", 3);
				Judge judge4 = new Judge("Stanislav", "Ovcharov", 36, "male", "Sofia", 3);
				judge2.setSpecial(true);
				
				//Create participants
				Participant participant1 = new Participant("Velina", "Kraeva", 25, "Female", "Plovdiv");
				Participant participant2 = new Participant("Doroteya", "Mitova", 25, "Female", "Varna");
				Participant participant3 = new Participant("Veliko", "Velichkov", 25, "Male", "Petrich");
				Participant participant4 = new Participant("Elizabet", "Pavlova", 25, "Female", "Sofia");
				Participant participant5 = new Participant("Yana", "Koleva", 25, "Female", "Plovdiv");
				Participant participant6 = new Participant("Lachezar", "Balabanov", 25, "Male", "Varna");
				Participant participant7 = new Participant("Martin", "Grigorov", 25, "Male", "Sofia");
				Participant participant8 = new Participant("Nataliya", "Vasileva", 25, "Female", "Burgas");
				Participant participant9 = new Participant("Desislava", "Petkova", 25, "Female", "Vraca");
				Participant participant10 = new Participant("Yasen", "Gurvanov", 25, "Male", "Blagoevgrad");
				Participant participant11 = new Participant("Grudi", "Radev", 25, "Male", "Stara Zagora");
				Participant participant12 = new Participant("Dilyana", "Stolarova", 25, "Female", "Varna");
				Participant participant13 = new Participant("Toni", "Ilieva", 25, "Female", "Troyan");
				Participant participant14 = new Participant("Zdravko", "Kostadinov", 25, "Male", "Sofia");
				Participant participant15 = new Participant("Kristiyan", "Srebrev", 25, "Male", "Purvomay");
				
				//Set qualities for the participants
				participant1.setQuality("Playing the guitar");
				participant2.setQuality("Dancing");
				participant3.setQuality("Playing the piano");
				participant11.setQuality("Painting");
				participant5.setQuality("Playing the piano");
				participant12.setQuality("Dancing");
				participant15.setQuality("Playing the guitar");
				participant13.setQuality("Painting, Playing the guitar");
				participant6.setQuality("Playing the viola");
				participant10.setQuality("Dancing, Playing the piano");
				
				//Print information about participants
				System.out.println("Participants:" + "\n");
				for(Participant p : Competition.getParticipants()) {
					participant.printInfo(p);
				}
				
				//Print information about judges
				System.out.println("Judges:" + "\n");
				for(Judge j : Competition.getJudges()) {
					person.printInfo(j);
				}
				
				//Create stage 1
				Stage stage1 = null;
				try {
					stage1 = new Stage(1, 40);
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
				
				System.out.println("Participants in stage " + stage1.getStageNumber() + ":\n" + stage1.getParticipantsInStage());		
				
				//Add favourites
				judge.addFavourite(participant1, judge1);
				judge.addFavourite(participant13, judge1);
				judge.addFavourite(participant8, judge1);
				
				judge.addFavourite(participant4, judge2);
				judge.addFavourite(participant1, judge2);
				judge.addFavourite(participant13, judge2);
				
				judge.addFavourite(participant13, judge3);
				judge.addFavourite(participant4, judge3);
				judge.addFavourite(participant10, judge3);
				
				judge.addFavourite(participant2, judge4);
				judge.addFavourite(participant10, judge4);
				judge.addFavourite(participant12, judge4);
				
				//Print judges' favourites
				System.out.println();
				judge.printFavourites(judge1);
				judge.printFavourites(judge2);
				judge.printFavourites(judge3);
				judge.printFavourites(judge4);
				System.out.println();
				
				//Judges vote here
				judge.vote(participant1, 1, judge1, stage1);
				judge.vote(participant1, 1, judge2, stage1);
				judge.vote(participant1, 1, judge3, stage1);
				judge.vote(participant1, 1, judge4, stage1);
				
				judge.vote(participant2, 1, judge1, stage1);
				judge.vote(participant2, 0, judge2, stage1);
				judge.vote(participant2, 0, judge3, stage1);
				judge.vote(participant2, 0, judge4, stage1);
				
				judge.vote(participant3, 0, judge1, stage1);
				judge.vote(participant3, 1, judge2, stage1);
				judge.vote(participant3, 0, judge3, stage1);
				judge.vote(participant3, 1, judge4, stage1);
				
				judge.vote(participant4, 1, judge1, stage1);
				judge.vote(participant4, 1, judge2, stage1);
				judge.vote(participant4, 1, judge3, stage1);
				judge.vote(participant4, 1, judge4, stage1);
		
				judge.vote(participant5, 1, judge1, stage1);
				judge.vote(participant5, 1, judge2, stage1);
				judge.vote(participant5, 1, judge3, stage1);
				judge.vote(participant5, 1, judge4, stage1);
				
				judge.vote(participant6, 1, judge1, stage1);
				judge.vote(participant6, 0, judge2, stage1);
				judge.vote(participant6, 0, judge3, stage1);
				judge.vote(participant6, 0, judge4, stage1);
				
				judge.vote(participant7, 0, judge1, stage1);
				judge.vote(participant7, 1, judge2, stage1);
				judge.vote(participant7, 1, judge3, stage1);
				judge.vote(participant7, 1, judge4, stage1);
				
				judge.vote(participant8, 1, judge1, stage1);
				judge.vote(participant8, 0, judge2, stage1);
				judge.vote(participant8, 0, judge3, stage1);
				judge.vote(participant8, 1, judge4, stage1);
				
				judge.vote(participant9, 0, judge1, stage1);
				judge.vote(participant9, 0, judge2, stage1);
				judge.vote(participant9, 0, judge3, stage1);
				judge.vote(participant9, 0, judge4, stage1);
				
				judge.vote(participant10, 1, judge1, stage1);
				judge.vote(participant10, 0, judge2, stage1);
				judge.vote(participant10, 1, judge3, stage1);
				judge.vote(participant10, 1, judge4, stage1);
				
				judge.vote(participant11, 1, judge1, stage1);
				judge.vote(participant11, 0, judge2, stage1);
				judge.vote(participant11, 0, judge3, stage1);
				judge.vote(participant11, 1, judge4, stage1);
				
				judge.vote(participant12, 1, judge1, stage1);
				judge.vote(participant12, 1, judge2, stage1);
				judge.vote(participant12, 1, judge3, stage1);
				judge.vote(participant12, 1, judge4, stage1);
				
				judge.vote(participant13, 0, judge1, stage1);
				judge.vote(participant13, 1, judge2, stage1);
				judge.vote(participant13, 0, judge3, stage1);
				judge.vote(participant13, 1, judge4, stage1);
				
				judge.vote(participant14, 0, judge1, stage1);
				judge.vote(participant14, 0, judge2, stage1);
				judge.vote(participant14, 1, judge3, stage1);
				judge.vote(participant14, 1, judge4, stage1);
				
				judge.vote(participant15, 1, judge1, stage1);
				judge.vote(participant15, 1, judge2, stage1);
				judge.vote(participant15, 1, judge3, stage1);
				judge.vote(participant15, 1, judge4, stage1);
				
				//Qualify participants
				stage.qualifyParticipants(stage1);
				
				//Check if there is a winner
				if(stage1.getQualifiedParticipants().size() == 1) {
					System.out.println("Winner of X-Factor is:" + "\n" + stage1.getQualifiedParticipants());
				} else {
					System.out.println("Qualified participants:\n" + stage1.getQualifiedParticipants() + "\n");
				}
				
				//Create stage2
				Stage stage2 = null;
				try {
					stage2 = new Stage(2, 40);
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			
				//Set qualified participants form previous stage to participate in new stage
				Set<Participant> partsInStage2 = stage1.getParticipantsInStage();
				partsInStage2 = stage1.getQualifiedParticipants();
				System.out.println("Participants in stage " + stage2.getStageNumber() + ":\n" + partsInStage2);
				
				judge.vote(participant1, 0, judge1, stage2);
				judge.vote(participant1, 0, judge2, stage2);
				judge.vote(participant1, 1, judge3, stage2);
				judge.vote(participant1, 1, judge4, stage2);
				
				judge.vote(participant2, 0, judge1, stage2);
				judge.vote(participant2, 0, judge2, stage2);
				judge.vote(participant2, 0, judge3, stage2);
				judge.vote(participant2, 0, judge4, stage2);
				
				judge.vote(participant3, 0, judge1, stage2);
				judge.vote(participant3, 1, judge2, stage2);
				judge.vote(participant3, 0, judge3, stage2);
				judge.vote(participant3, 1, judge4, stage2);
				
				judge.vote(participant4, 1, judge1, stage2);
				judge.vote(participant4, 1, judge2, stage2);
				judge.vote(participant4, 1, judge3, stage2);
				judge.vote(participant4, 1, judge4, stage2);
		
				judge.vote(participant5, 1, judge1, stage2);
				judge.vote(participant5, 0, judge2, stage2);
				judge.vote(participant5, 0, judge3, stage2);
				judge.vote(participant5, 1, judge4, stage2);
				
				judge.vote(participant7, 0, judge1, stage2);
				judge.vote(participant7, 0, judge2, stage2);
				judge.vote(participant7, 1, judge3, stage2);
				judge.vote(participant7, 1, judge4, stage2);
				
				judge.vote(participant8, 1, judge1, stage2);
				judge.vote(participant8, 1, judge2, stage2);
				judge.vote(participant8, 0, judge3, stage2);
				judge.vote(participant8, 1, judge4, stage2);
				
				judge.vote(participant10, 1, judge1, stage2);
				judge.vote(participant10, 1, judge2, stage2);
				judge.vote(participant10, 0, judge3, stage2);
				judge.vote(participant10, 0, judge4, stage2);
				
				judge.vote(participant12, 0, judge1, stage2);
				judge.vote(participant12, 0, judge2, stage2);
				judge.vote(participant12, 1, judge3, stage2);
				judge.vote(participant12, 1, judge4, stage2);
				
				judge.vote(participant13, 0, judge1, stage2);
				judge.vote(participant13, 1, judge2, stage2);
				judge.vote(participant13, 0, judge3, stage2);
				judge.vote(participant13, 1, judge4, stage2);
				
				judge.vote(participant15, 1, judge1, stage2);
				judge.vote(participant15, 1, judge2, stage2);
				judge.vote(participant15, 1, judge3, stage2);
				judge.vote(participant15, 1, judge4, stage2);
				
				stage.qualifyParticipants(stage2);
				
				if(stage2.getQualifiedParticipants().size() == 1) {
					System.out.println("Winner of X-Factor is:" + "\n" + stage2.getQualifiedParticipants());
				} else {
					System.out.println("Qualified participants:\n" + stage2.getQualifiedParticipants() + "\n");
				}
				
				Stage stage3 = null;
				try {
					stage3 = new Stage(3, 26);
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
				
				Set<Participant> partsInStage3 = stage3.getParticipantsInStage();
				partsInStage3 = stage2.getQualifiedParticipants();
				System.out.println("Participants in stage " + stage3.getStageNumber() + ":\n" + partsInStage3);
				
				judge.vote(participant3, 0, judge1, stage3);
				judge.vote(participant3, 1, judge2, stage3);
				judge.vote(participant3, 0, judge3, stage3);
				judge.vote(participant3, 1, judge4, stage3);
				
				judge.vote(participant4, 1, judge1, stage3);
				judge.vote(participant4, 0, judge2, stage3);
				judge.vote(participant4, 0, judge3, stage3);
				judge.vote(participant4, 1, judge4, stage3);
				
				judge.vote(participant8, 1, judge1, stage3);
				judge.vote(participant8, 1, judge2, stage3);
				judge.vote(participant8, 0, judge3, stage3);
				judge.vote(participant8, 1, judge4, stage3);
				
				judge.vote(participant10, 1, judge1, stage3);
				judge.vote(participant10, 1, judge2, stage3);
				judge.vote(participant10, 0, judge3, stage3);
				judge.vote(participant10, 0, judge4, stage3);
				
				judge.vote(participant13, 0, judge1, stage3);
				judge.vote(participant13, 1, judge2, stage3);
				judge.vote(participant13, 0, judge3, stage3);
				judge.vote(participant13, 1, judge4, stage3);
				
				judge.vote(participant15, 1, judge1, stage3);
				judge.vote(participant15, 0, judge2, stage3);
				judge.vote(participant15, 0, judge3, stage3);
				judge.vote(participant15, 0, judge4, stage3);
				
				stage.qualifyParticipants(stage3);
				
				if(stage3.getQualifiedParticipants().size() == 1) {
					System.out.println("Winner of X-Factor is:" + "\n" + stage3.getQualifiedParticipants());
				} else {
					System.out.println("Qualified participants:\n" + stage3.getQualifiedParticipants() + "\n");
				}
				
				Stage stage4 = null;
				try {
					stage4 = new Stage(4, 26);
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
				
				Set<Participant> partsInStage4 = stage4.getParticipantsInStage();
				partsInStage4 = stage3.getQualifiedParticipants();
				System.out.println("Participants in stage " + stage4.getStageNumber() + ":\n" + partsInStage4);
				
				judge.vote(participant3, 0, judge1, stage4);
				judge.vote(participant3, 1, judge2, stage4);
				judge.vote(participant3, 0, judge3, stage4);
				judge.vote(participant3, 1, judge4, stage4);
				
				judge.vote(participant8, 0, judge1, stage4);
				judge.vote(participant8, 0, judge2, stage4);
				judge.vote(participant8, 0, judge3, stage4);
				judge.vote(participant8, 1, judge4, stage4);
				
				judge.vote(participant10, 0, judge1, stage4);
				judge.vote(participant10, 1, judge2, stage4);
				judge.vote(participant10, 0, judge3, stage4);
				judge.vote(participant10, 0, judge4, stage4);
				
				judge.vote(participant13, 0, judge1, stage4);
				judge.vote(participant13, 1, judge2, stage4);
				judge.vote(participant13, 0, judge3, stage4);
				judge.vote(participant13, 1, judge4, stage4);
				
				stage.qualifyParticipants(stage4);
				
				if(stage4.getQualifiedParticipants().size() == 1) {
					System.out.println("Winner of X-Factor is:" + "\n" + stage4.getQualifiedParticipants() + "\n");
				} else {
					System.out.println("Qualified participants:\n" + stage4.getQualifiedParticipants() + "\n");
				}
				
				Stage stage5 = null;
				try {
					stage5 = new Stage(5, 40);
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
				
				Set<Participant> partsInStage5 = stage5.getParticipantsInStage();
				partsInStage5 = stage4.getQualifiedParticipants();
				System.out.println("Participants in stage " + stage5.getStageNumber() + ":\n" + partsInStage5);
				
				judge.vote(participant3, 0, judge1, stage5);
				judge.vote(participant3, 1, judge2, stage5);
				judge.vote(participant3, 1, judge3, stage5);
				judge.vote(participant3, 1, judge4, stage5);
				
				judge.vote(participant13, 0, judge1, stage5);
				judge.vote(participant13, 1, judge2, stage5);
				judge.vote(participant13, 0, judge3, stage5);
				judge.vote(participant13, 0, judge4, stage5);
				
				stage.qualifyParticipants(stage5);
				
				if(stage5.getQualifiedParticipants().size() == 1) {
					System.out.println("Winner of X-Factor is:" + "\n" + stage5.getQualifiedParticipants());
				}
				
				scan.close();
				break;
			}
			case 2: {
				System.out.println("You chose option " + input + ": 3 Judges, 8 Participants, 3 Stages" + "\n");
				
				Competition.setNumberOfStages(3);
				
				Judge judge1 = new Judge("Martin", "Momov", 36, "male", "Sofia", 3);
				Judge judge2 = new Judge("Elena", "Marinova", 36, "male", "Sofia", 3);
				Judge judge3 = new Judge("Delyan", "Lilov", 36, "female", "Sofia", 3);
				
				Participant participant1 = new Participant("Velina", "Kraeva", 25, "Female", "Plovdiv");
				Participant participant2 = new Participant("Doroteya", "Mitova", 25, "Female", "Varna");
				Participant participant3 = new Participant("Veliko", "Velichkov", 25, "Male", "Petrich");
				Participant participant4 = new Participant("Elizabet", "Pavlova", 25, "Female", "Sofia");
				Participant participant5 = new Participant("Yana", "Koleva", 25, "Female", "Plovdiv");
				Participant participant6 = new Participant("Lachezar", "Balabanov", 25, "Male", "Varna");
				Participant participant7 = new Participant("Martin", "Grigorov", 25, "Male", "Sofia");
				Participant participant8 = new Participant("Nataliya", "Vasileva", 25, "Female", "Burgas");
				
				participant1.setQuality("Playing the guitar");
				participant2.setQuality("Dancing");
				participant3.setQuality("Playing the guitar");
				participant5.setQuality("Playing the piano");
				participant8.setQuality("Playing the viola");
				
				System.out.println("Participants:" + "\n");
				for(Participant p : Competition.getParticipants()) {
					participant.printInfo(p);
				}
				
				System.out.println("Judges:" + "\n");
				for(Judge j : Competition.getJudges()) {
					person.printInfo(j);
				}
				
				Stage stage1 = null;
				try {
					stage1 = new Stage(1, 10);
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
				
				System.out.println("Participants in stage " + stage1.getStageNumber() +  ":\n" + stage1.getParticipantsInStage());
				
				judge.addFavourite(participant1, judge1);
				judge.addFavourite(participant8, judge1);
				
				judge.addFavourite(participant4, judge2);
				judge.addFavourite(participant1, judge2);
				judge.addFavourite(participant2, judge2);
				
				judge.addFavourite(participant4, judge3);
				
				System.out.println();
				judge.printFavourites(judge1);
				judge.printFavourites(judge2);
				judge.printFavourites(judge3);
				System.out.println();
				
				judge.vote(participant1, 1, judge1, stage1);
				judge.vote(participant1, 1, judge2, stage1);
				judge.vote(participant1, 1, judge3, stage1);
				
				judge.vote(participant2, 1, judge1, stage1);
				judge.vote(participant2, 0, judge2, stage1);
				judge.vote(participant2, 0, judge3, stage1);
				
				judge.vote(participant3, 0, judge1, stage1);
				judge.vote(participant3, 1, judge2, stage1);
				judge.vote(participant3, 0, judge3, stage1);
				
				judge.vote(participant4, 1, judge1, stage1);
				judge.vote(participant4, 1, judge2, stage1);
				judge.vote(participant4, 1, judge3, stage1);
		
				judge.vote(participant5, 1, judge1, stage1);
				judge.vote(participant5, 1, judge2, stage1);
				judge.vote(participant5, 1, judge3, stage1);
				
				judge.vote(participant6, 1, judge1, stage1);
				judge.vote(participant6, 0, judge2, stage1);
				judge.vote(participant6, 0, judge3, stage1);
				
				judge.vote(participant7, 0, judge1, stage1);
				judge.vote(participant7, 1, judge2, stage1);
				judge.vote(participant7, 1, judge3, stage1);
				
				judge.vote(participant8, 1, judge1, stage1);
				judge.vote(participant8, 0, judge2, stage1);
				judge.vote(participant8, 0, judge3, stage1);
				
				stage.qualifyParticipants(stage1);

				if(stage1.getQualifiedParticipants().size() == 1) {
					System.out.println("Winner of X-Factor is:" + "\n" + stage1.getQualifiedParticipants());
				} else {
					System.out.println("Qualified participants:\n" + stage1.getQualifiedParticipants() + "\n");
				}
				
				Stage stage2 = null;
				try {
					stage2 = new Stage(2, 40);
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}

				Set<Participant> partsInStage2 = stage1.getParticipantsInStage();
				partsInStage2 = stage1.getQualifiedParticipants();
				System.out.println("Participants in stage " + stage2.getStageNumber() + ":\n" + partsInStage2);
				
				judge.vote(participant1, 0, judge1, stage2);
				judge.vote(participant1, 1, judge2, stage2);
				judge.vote(participant1, 1, judge3, stage2);
				
				judge.vote(participant4, 0, judge1, stage2);
				judge.vote(participant4, 0, judge2, stage2);
				judge.vote(participant4, 1, judge3, stage2);
		
				judge.vote(participant5, 1, judge1, stage2);
				judge.vote(participant5, 1, judge2, stage2);
				judge.vote(participant5, 0, judge3, stage2);
				
				judge.vote(participant7, 0, judge1, stage2);
				judge.vote(participant7, 0, judge2, stage2);
				judge.vote(participant7, 1, judge3, stage2);
				
				stage.qualifyParticipants(stage2);
				
				if(stage2.getQualifiedParticipants().size() == 1) {
					System.out.println("Winner of X-Factor is:" + "\n" + stage2.getQualifiedParticipants());
				} else {
					System.out.println("Qualified participants:\n" + stage2.getQualifiedParticipants() + "\n");
				}
				
				Stage stage3 = null;
				try {
					stage3 = new Stage(3, 26);
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}

				Set<Participant> partsInStage3 = stage2.getParticipantsInStage();
				partsInStage3 = stage2.getQualifiedParticipants();
				System.out.println("Participants in stage " + stage3.getStageNumber() + ":\n" + partsInStage3);
				
				judge.vote(participant1, 0, judge1, stage3);
				judge.vote(participant1, 0, judge2, stage3);
				judge.vote(participant1, 1, judge3, stage3);
		
				judge.vote(participant5, 1, judge1, stage3);
				judge.vote(participant5, 1, judge2, stage3);
				judge.vote(participant5, 1, judge3, stage3);
				
				stage.qualifyParticipants(stage3);

				if(stage3.getQualifiedParticipants().size() == 1) {
					System.out.println("Winner of X-Factor is:" + "\n" + stage3.getQualifiedParticipants());
				}

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