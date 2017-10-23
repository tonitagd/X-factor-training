package xFactor;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import xFactor.Person.Gender;

public class Application {
	private ArrayList<Judge> allJudges;
	private ArrayList<Judge> judges;
	private ArrayList<Participant> allParticipants;
	private ArrayList<Participant> participants;
	private Stage[] allStages;
	private ArrayList<String> qualities;
	
	private ParticipantServiceImpl participantService = new ParticipantServiceImpl();
	private PersonServiceImpl personService = new PersonServiceImpl();
	private StageServiceImpl stageService = new StageServiceImpl();

	private Random random = new Random();
	
	private Judge judge1;
	private Judge judge2;
	private Judge judge3;
	private Judge judge4;
	
	private Participant participant1;
	private Participant participant2;
	private Participant participant3;
	private Participant participant4;
	private Participant participant5;
	private Participant participant6;
	private Participant participant7;
	private Participant participant8;
	private Participant participant9;
	private Participant participant10;
	private Participant participant11;
	private Participant participant12;
	private Participant participant13;
	private Participant participant14;
	private Participant participant15;
	
	private Stage stage1;
	private Stage stage2;
	private Stage stage3;
	private Stage stage4;
	private Stage stage5;
	private Stage stage6;
	private Stage stage7;
	private Stage stage8;
	
	public Stage getStage(int stageNum) {
		return allStages[stageNum - 1];
	}
	
	private void addStages() {
		allStages = new Stage[8];
		allStages[0] = stage1;
		allStages[1] = stage2;
		allStages[2] = stage3;
		allStages[3] = stage4;
		allStages[4] = stage5;
		allStages[5] = stage6;
		allStages[6] = stage7;
		allStages[7] = stage8;
	}
	
	private void addJudges(){
		allJudges = new ArrayList<Judge>();
		allJudges.add(judge1 = new Judge("Martin", "Momov", 36, Gender.Male, "Sofia", 3));
		allJudges.add(judge2 = new Judge("Elena", "Marinova", 36, Gender.Female, "Sofia", 3));
		allJudges.add(judge3 = new Judge("Delyan", "Lilov", 36, Gender.Male, "Sofia", 3));
		allJudges.add(judge4 = new Judge("Stanislav", "Ovcharov", 36, Gender.Male, "Sofia", 3));
	}
	
	private void addParticipants(){
		allParticipants = new ArrayList<Participant>();
		allParticipants.add(participant1 = new Participant("Velina", "Kraeva", 25, Gender.Female, "Plovdiv"));
		allParticipants.add(participant2 = new Participant("Doroteya", "Mitova", 25, Gender.Female, "Varna"));
		allParticipants.add(participant3 = new Participant("Veliko", "Velichkov", 25, Gender.Male, "Petrich"));
		allParticipants.add(participant4 = new Participant("Elizabet", "Pavlova", 25, Gender.Female, "Sofia"));
		allParticipants.add(participant5 = new Participant("Yana", "Koleva", 25, Gender.Female, "Plovdiv"));
		allParticipants.add(participant6 = new Participant("Lachezar", "Balabanov", 25, Gender.Male, "Varna"));
		allParticipants.add(participant7 = new Participant("Martin", "Grigorov", 25, Gender.Male, "Sofia"));
		allParticipants.add(participant8 = new Participant("Nataliya", "Vasileva", 25, Gender.Female, "Burgas"));
		allParticipants.add(participant9 = new Participant("Desislava", "Petkova", 25, Gender.Female, "Vraca"));
		allParticipants.add(participant10 = new Participant("Yasen", "Gurvanov", 25, Gender.Male, "Blagoevgrad"));
		allParticipants.add(participant11 = new Participant("Grudi", "Radev", 25, Gender.Male, "Stara Zagora"));
		allParticipants.add(participant12 = new Participant("Dilyana", "Stolarova", 25, Gender.Female, "Varna"));
		allParticipants.add(participant13 = new Participant("Toni", "Ilieva", 25, Gender.Female, "Troyan"));
		allParticipants.add(participant14 = new Participant("Zdravko", "Kostadinov", 25, Gender.Male, "Sofia"));
		allParticipants.add(participant15 = new Participant("Kristiyan", "Srebrev", 25, Gender.Male, "Purvomay"));
	}
	
	private void fillQualities() {
		qualities = new ArrayList<String>();
		qualities.add("Dancing");
		qualities.add("Painting");
		qualities.add("Playing the guitar");
		qualities.add("Playing the piano");
		qualities.add("Playing the viola");
		qualities.add("Playing the drums");
	}
	
	public void createJudges(int number) {
		judges = new ArrayList<Judge>();
		addJudges();
		for(int i = 0; i < number; i++) {
			judges.add(allJudges.get(i));
		}
	}
	
	public void giveSpecialVote(String name) {
		for(Judge judge : Competition.getJudges()) {
			if(judge.getName() == name) {
				judge.setSpecial(true);
			}
		}
	}
	
	public void printSpecialJudge() {
		for(Judge judge : Competition.getJudges()) {
			if(judge.isSpecial()) {
				System.out.println(judge.getName());
				break;
			}
		}
		
	}
	
	public void createParticipants(int number) {
		participants = new ArrayList<Participant>();
		addParticipants();
		for(int i = 0; i < number; i++) {
			participants.add(allParticipants.get(i));
		}
	}
	
	public void createStage(int stageNum, int max) {
		addStages();
		allStages[stageNum - 1] = new Stage(stageNum, max);
	}
	
	public void printParticipantsInStage(Stage stage) {
		System.out.println("Participants in stage " + stage.getStageNumber() + ":\n" + stage.getParticipantsInStage());
	}
	
	public void addQualitiesForParticipants() {
		fillQualities();
		for(Participant participant : participants) {
			int i = random.nextInt(qualities.size() - 1);
			participant.addQuality(qualities.get(i));
		}
	}
	
	public void printParticipantsInfo() {
		for(Participant participant : participants) {
			participantService.printInfo(participant);
		}
	}
	
	public void printJudgesInfo() {
		for(Judge judge : judges) {
			personService.printInfo(judge);
		}
	}
	
	public void addJudgesFavourites(Stage stage) {
		for(Judge judge : judges) {
			for(int i = 1; i <= judge.getMaxFavourites(); i++) {
				int j = random.nextInt(participants.size());
				judge.addFavourite(participants.get(j), stage);
			}
		}
	}
	
	public void printFavourites(Stage stage) {
		System.out.println(stage.getJudgeFavourites());
	}
	
	public void judgesVote(Stage stage) {
		for(Participant participant : stage.getParticipantsInStage()) {
			for(Judge judge : judges) {
				stage.vote(participant, random.nextBoolean(), judge);
			}
		}
	}
	
	public void qualifyParticipants(Stage stage) {
		stageService.qualifyParticipants(stage);
	}
	
	public void checkForWinner(Stage stage) {
		stage.checkForWinner();
	}
	
	public void printQualifiedParticipants(Stage stage) {
		System.out.println("Qualified participants:\n" + stage.getQualifiedParticipants() + "\n");
	}
	
	public Set<Participant> getQualified(Stage stage) {
		return stage.getQualifiedParticipants();
	}
}
