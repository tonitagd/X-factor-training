package xFactor;

import java.util.Scanner;

public class Main {
	public static void printJudges() {
		for(int i = 0; i < Competition.getJudgesSize(); i++) {
			System.out.println(Competition.getJudges().get(i));
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("How many number of stages would you like to have?");
		int num = scan.nextInt();
		Competition.setNumberOfStages(num);
		
		Judge judge1 = new Judge("Petur", "Ivanov", 36, "male", "Sofia", 3);
		Judge judge2 = new Judge("Elena", "Petrova", 36, "male", "Sofia", 3);
		Judge judge3 = new Judge("Sania", "Jekova", 42, "female", "Burgas", 3);
		Judge judge4 = new Judge("Milen", "Stoyanov", 50, "male", "Plovdiv", 3);
		judge2.setSpecial(true);
		
		Participant participant1 = new Participant("Galia", "Nikolova", 23, "female", "Plovdiv");
		Participant participant2 = new Participant("Nikolay", "Dimitrov", 26, "male", "Varna");
		Participant participant3 = new Participant("Ivan", "Dimitrov", 32, "male", "Petrich");
		Participant participant4 = new Participant("Milena", "Petrova", 20, "female", "Sofia");
		
		Stage stage1 = null;
		try {
			stage1 = new Stage(1, 40);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		participant1.setQuality("Playing the guitar.");
		participant2.setQuality("Dancing.");
		
		PersonServiceImpl person = new PersonServiceImpl();
		person.printInfo(participant2);
		
		System.out.println(participant3.getQuality());
		System.out.println(participant1.getQuality());
		System.out.println(participant2.getQuality());
	
		JudgeServiceImpl judge = new JudgeServiceImpl();
		judge.addFavourite(participant1, judge1);
		judge.addFavourite(participant2, judge1);
		judge.addFavourite(participant2, judge1);
		judge.addFavourite(participant4, judge1);
		judge.addFavourite(participant3, judge1);
		judge.printFavourites(judge1);
		judge.removeFavourite(participant1,judge1);
		judge.printFavourites(judge1);
		judge.clearFavourites(judge1);
		
		judge.vote(participant1, 1, judge1);
		judge.vote(participant1, 1, judge2);
		judge.vote(participant1, 1, judge3);
		judge.vote(participant1, 1, judge4);
		
		judge.vote(participant2, 1, judge1);
		judge.vote(participant2, 0, judge2);
		judge.vote(participant2, 0, judge3);
		judge.vote(participant2, 0, judge4);
		
		judge.vote(participant3, 0, judge1);
		judge.vote(participant3, 1, judge2);
		judge.vote(participant3, 0, judge3);
		judge.vote(participant3, 1, judge4);
		
		judge.vote(participant4, 1, judge1);
		judge.vote(participant4, 1, judge2);
		judge.vote(participant4, 1, judge3);
		judge.vote(participant4, 1, judge4);
	
		StageServiceImpl stage = new StageServiceImpl();
		
		stage.qualifyParticipant(participant1, stage1);
		stage.qualifyParticipant(participant2, stage1);
		stage.qualifyParticipant(participant3, stage1);
		stage.qualifyParticipant(participant4, stage1);
		System.out.println(stage1.getParticipantsInStage());
		
		ParticipantServiceImpl part = new ParticipantServiceImpl();
		part.printVotes(participant3);
		
		Stage stage2 = null;
		try {
			stage2 = new Stage(2, 40);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	
		judge.vote(participant1, 1, judge1);
		judge.vote(participant1, 0, judge2);
		judge.vote(participant1, 0, judge3);
		judge.vote(participant1, 0, judge4);
		
		judge.vote(participant3, 1, judge1);
		judge.vote(participant3, 0, judge2);
		judge.vote(participant3, 1, judge3);
		judge.vote(participant3, 1, judge4);
		
		judge.vote(participant4, 1, judge1);
		judge.vote(participant4, 1, judge2);
		judge.vote(participant4, 1, judge3);
		judge.vote(participant4, 1, judge4);
		
		stage.qualifyParticipant(participant1, stage2);
		stage.qualifyParticipant(participant2, stage2);
		stage.qualifyParticipant(participant3, stage2);
		stage.qualifyParticipant(participant4, stage2);
		System.out.println(stage2.getParticipantsInStage());
		
//		Stage stage3 = null;
//		try {
//			stage3 = new Stage(3, 26);
//		} catch (IllegalArgumentException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		judge.vote(participant3, 1, judge1);
//		judge.vote(participant3, 0, judge2);
//		judge.vote(participant3, 0, judge3);
//		judge.vote(participant3, 1, judge4);
//		stage.qualifyParticipant(participant3, stage3);
//		
//		judge.vote(participant4, 0, judge1);
//		judge.vote(participant4, 1, judge2);
//		judge.vote(participant4, 1, judge3);
//		judge.vote(participant4, 1, judge4);
//		stage.qualifyParticipant(participant4, stage3);
//		
//		System.out.println(stage3.getParticipantsInStage());
//		System.out.println(stage3.getQualifiedParticipants());
//		
		scan.close();
	}
}