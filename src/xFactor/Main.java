package xFactor;

public class Main {
	public static void printJudges() {
		for(int i = 0; i < Judge.getJudges().size(); i++) {
			System.out.println(Judge.getJudges().get(i));
		}
	}
	public static void main(String[] args) {
		Judge judge1 = new Judge("Petur", "Ivanov", 36, "male", "Sofia");
		Judge judge2 = new Judge("Elena", "Petrova", 36, "male", "Sofia");
		Judge judge3 = new Judge("Sania", "Jekova", 42, "female", "Burgas");
		Judge judge4 = new Judge("Milen", "Stoyanov", 50, "male", "Plovdiv");
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
		
//		participant1.setQuality("Playing the guitar.");
//		participant2.setQuality("Dancing.");
//		
//		participant2.printInfo();
//		System.out.println(participant3.getQuality());
//		
//		System.out.println(participant1.getQuality());
//		System.out.println(participant2.getQuality());
//	
//		judge1.addFavourite(participant1);
//		judge1.addFavourite(participant2);
//		judge1.addFavourite(participant2);
//		judge1.addFavourite(participant4);
//		judge1.printFavourites();
//		judge1.removeFavourite(participant1);
//		judge1.printFavourites();
//		judge1.clearFavourites();
		
		judge1.vote(participant1, 1);
		judge2.vote(participant1, 1);
		judge3.vote(participant1, 1);
		judge4.vote(participant1, 1);
		
		judge1.vote(participant2, 1);
		judge2.vote(participant2, 0);
		judge3.vote(participant2, 0);
		judge4.vote(participant2, 0);
		
		judge1.vote(participant3, 0);
		judge2.vote(participant3, 1);
		judge3.vote(participant3, 0);
		judge4.vote(participant3, 1);
		
		judge1.vote(participant4, 1);
		judge2.vote(participant4, 1);
		judge3.vote(participant4, 1);
		judge4.vote(participant4, 1);
	
		stage1.qualifyParticipant(participant1);
		stage1.qualifyParticipant(participant2);
		stage1.qualifyParticipant(participant3);
		stage1.qualifyParticipant(participant4);
		System.out.println(stage1.getParticipantsInStage());
		
		
		Stage stage2 = null;
		try {
			stage2 = new Stage(2, 40);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	
		judge1.vote(participant1, 1);
		judge2.vote(participant1, 0);
		judge3.vote(participant1, 0);
		judge4.vote(participant1, 0);
		
		judge1.vote(participant3, 1);
		judge2.vote(participant3, 0);
		judge3.vote(participant3, 1);
		judge4.vote(participant3, 1);
		
		judge1.vote(participant4, 1);
		judge2.vote(participant4, 1);
		judge3.vote(participant4, 1);
		judge4.vote(participant4, 1);
		
		stage2.qualifyParticipant(participant1);
		stage2.qualifyParticipant(participant2);
		stage2.qualifyParticipant(participant3);
		stage2.qualifyParticipant(participant4);
		System.out.println(stage2.getParticipantsInStage());
		
		Stage stage3 = null;
		try {
			stage3 = new Stage(3, 26);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		judge1.vote(participant3, 1);
		judge2.vote(participant3, 0);
		judge3.vote(participant3, 0);
		judge4.vote(participant3, 1);
		stage3.qualifyParticipant(participant3);
		
		judge1.vote(participant4, 0);
		judge2.vote(participant4, 1);
		judge3.vote(participant4, 1);
		judge4.vote(participant4, 1);
		stage3.qualifyParticipant(participant4);
		
		System.out.println(stage3.getParticipantsInStage());
		System.out.println(stage3.getQualifiedParticipants());
	}
}
