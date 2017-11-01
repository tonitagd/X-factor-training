package xFactor;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import judge.Judge;
import participant.Participant;
import person.PersonServiceImpl;
import person.Person.Gender;
import stage.Stage;
import stage.StageServiceImpl;

public class Application {
	private ArrayList<Judge> allJudges;
	private ArrayList<Judge> judges;
	private ArrayList<Participant> allParticipants;
	private ArrayList<Participant> participants;
	private ArrayList<Stage> allStages = new ArrayList<Stage>();;
	private ArrayList<String> qualities;
	
	private int numberOfStages;
	
	private PersonServiceImpl personService = new PersonServiceImpl();
	private StageServiceImpl stageService = new StageServiceImpl();
			
	private Random random = new Random();

	public int getNumberOfStages() {
		return numberOfStages;
	}

	public void setNumberOfStages(int numberOfStages) {
		this.numberOfStages = numberOfStages;
	}
	
	public Stage getStage(int stageNum) {
		for(Stage stage : allStages) {
			if(stage.getStageNumber() == stageNum) {
				return stage;
			}
		}
		return new Stage();
	}
	
	private void addJudges(){
		allJudges = new ArrayList<Judge>();
		allJudges.add(new Judge("Martin", "Momov", 36,
				Gender.Male, "Sofia", 3, 1));
		allJudges.add(new Judge("Elena", "Marinova", 36,
				Gender.Female, "Sofia", 3, 2));
		allJudges.add(new Judge("Delyan", "Lilov", 36,
				Gender.Male, "Sofia", 3, 3));
		allJudges.add(new Judge("Stanislav", "Ovcharov", 36,
				Gender.Male, "Sofia", 3, 4));
	}
	
	private void addParticipants(){
		allParticipants = new ArrayList<Participant>();
		allParticipants.add(new Participant("Velina", "Kraeva", 25,
				Gender.Female, "Plovdiv", 11));
		allParticipants.add(new Participant("Doroteya", "Mitova", 25,
				Gender.Female, "Varna", 12));
		allParticipants.add(new Participant("Veliko", "Velichkov", 25,
				Gender.Male, "Petrich", 13));
		allParticipants.add(new Participant("Elizabet", "Pavlova", 25,
				Gender.Female, "Sofia", 14));
		allParticipants.add(new Participant("Yana", "Koleva", 25,
				Gender.Female, "Plovdiv", 15));
		allParticipants.add(new Participant("Lachezar", "Balabanov", 25,
				Gender.Male, "Varna", 16));
		allParticipants.add(new Participant("Martin", "Grigorov", 25,
				Gender.Male, "Sofia", 17));
		allParticipants.add(new Participant("Nataliya", "Vasileva", 25,
				Gender.Female, "Burgas", 18));
		allParticipants.add(new Participant("Desislava", "Petkova", 25,
				Gender.Female, "Vraca", 19));
		allParticipants.add(new Participant("Yasen", "Gurvanov", 25,
				Gender.Male, "Blagoevgrad", 20));
		allParticipants.add(new Participant("Grudi", "Radev", 25,
				Gender.Male, "Stara Zagora", 21));
		allParticipants.add(new Participant("Dilyana", "Stolarova", 25,
				Gender.Female, "Varna", 22));
		allParticipants.add(new Participant("Toni", "Ilieva", 25,
				Gender.Female, "Troyan", 23));
		allParticipants.add(new Participant("Zdravko", "Kostadinov", 25,
				Gender.Male, "Sofia", 24));
		allParticipants.add(new Participant("Kristiyan", "Srebrev", 25,
				Gender.Male, "Purvomay", 25));
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
	
	private void initializeStage(int stageNum, int max, Stage stage) {
		if(stageNum < 1 || stageNum > numberOfStages) {
			throw new IllegalArgumentException("The number of stage must be between 1 and " + numberOfStages);
		}
		
		if(allStages.size() - 1 == numberOfStages) {
			throw new IllegalArgumentException("Maximum number of stages reached! Cannot create a new one.");
		} else if(allStages.size() == 1) {
			stage.setMaxParticipants(allParticipants.size());
			stage.getParticipantsInStage().addAll(participants);
		} else {
			stage.setMaxParticipants(max);
		}
	}
	
	public void createJudges(int number) {
		judges = new ArrayList<Judge>();
		addJudges();
		for(int i = 0; i < number; i++) {
			judges.add(allJudges.get(i));
		}
	}

	public ArrayList<Judge> getJudges() {
		return judges;
	}

	public void setJudges(ArrayList<Judge> judges) {
		this.judges = judges;
	}
	
	public int getJudgesSize() {
		return judges.size();
	}
	
	public void giveSpecialVote(int id) {
		if(id > 0 && id < judges.size()) {
			for(Judge judge : judges) {
				if(judge.getId() == id) {
					judge.setSpecial(true);
				}
			}
		}
	}
	
	public void printSpecialJudge() {
		for(Judge judge : judges) {
			if(judge.isSpecial()) {
				System.out.println(judge.getName());
				break;
			}
		}
	}
	
	public void printJudges() {
		for(Judge judge : judges) {
			System.out.println(judge);
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
		Stage stage = new Stage(stageNum, max);
		allStages.add(stage);
		initializeStage(stageNum, max, stage);
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
			participant.printInfo();
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
				stage.addFavourite(participants.get(j), judge);
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
	
	public void qualifyParticipants(Stage stage, ArrayList<Judge> judges) {
		stageService.qualifyParticipants(stage, judges);
	}
	
	public void printQualifiedParticipants(Stage stage) {
		System.out.println("Qualified participants:\n" + stage.getQualifiedParticipants() + "\n");
	}
	
	public Set<Participant> getQualifiedParticipants(Stage stage) {
		return stage.getQualifiedParticipants();
	}
	
	public void checkForWinner(Stage stage) {
		stage.checkForWinner();
	}
}