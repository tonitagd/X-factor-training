package xFactor;

import java.util.ArrayList;

public class Stage {
	private static int numberOfStages;
	private static int countInstances;
	private int stageNumber;
	private int maxParticipants;
	private ArrayList<Participant> participantsInStage = new ArrayList<Participant>(maxParticipants);
	private ArrayList<Participant> qualifiedParticipants = new ArrayList<Participant>();
	private static ArrayList<Participant> tempArray = new ArrayList<Participant>();
	
	public Stage(int stageNum, int max) throws IllegalArgumentException {
		this.stageNumber = stageNum;
		countInstances++;
		initializeInstance(max, stageNum);
	}
	
	public int getStageNumber() {
		return stageNumber;
	}

	public int getMaxParticipants() {
		return maxParticipants;
	}

	public static int getNumberOfStages() {
		return numberOfStages;
	}

	public static void setNumberOfStages(int numberOfStages) {
		Stage.numberOfStages = numberOfStages;
	}
	
	public ArrayList<Participant> getParticipantsInStage() {
		return participantsInStage;
	}
	
	public ArrayList<Participant> getQualifiedParticipants() {
		if(qualifiedParticipants.size() == 1) {
			System.out.println("The winner of X-Factor is: " + qualifiedParticipants.get(0));
		}
		return qualifiedParticipants;
	}
	
	private void initializeInstance(int max, int stageNum) {
		if(stageNum < 1 || stageNum > numberOfStages) {
			throw new IllegalArgumentException("The number of stage must be between 1 and 12.");
		}
		
		if(countInstances == numberOfStages) {
			throw new IllegalArgumentException("Maximum number of stages reached! Cannot create a new one.");
		}
		if(countInstances == 1) {
			this.maxParticipants = Participant.getCountParticipants();
			this.participantsInStage.addAll(Participant.getAllParticipants());
		} else {
			this.maxParticipants = max;
			this.participantsInStage = tempArray;
		}
		for(Participant p : Participant.getAllParticipants()) {
			p.getPositiveVotes().clear();
		}
	}
	
	public ArrayList<Participant> qualifyParticipant(Participant participant) {
		for(Judge j : Judge.getJudges()) {
			j.vote(participant, j.getVote());
		}
		
		int size = participant.getPositiveVotes().size();
		
		if(size > 2) {
			qualifiedParticipants.add(participant);
		} else if(size == 2) {
			for(Judge j : participant.getPositiveVotes()) {
				if(j.isSpecial() == true) {
					qualifiedParticipants.add(participant);
					break;
				} else {
					System.out.println("Please set special rights to one of the judges!");
					break;
				}
			}
		}
		tempArray = qualifiedParticipants;
		return qualifiedParticipants;
	}
}