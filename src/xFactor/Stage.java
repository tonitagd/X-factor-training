package xFactor;

import java.util.ArrayList;

public class Stage {
	private int stageNumber;
	private int maxParticipants;
	private ArrayList<Participant> participantsInStage = new ArrayList<Participant>();
	private ArrayList<Participant> qualifiedParticipants = new ArrayList<Participant>();
	
	StageServiceImpl service = new StageServiceImpl();
	
	public Stage(int stageNum, int max) throws IllegalArgumentException {
		this.stageNumber = stageNum;
		Competition.stageCountInstances++;
		service.initializeInstance(max, stageNum, this);
	}
	
	public int getStageNumber() {
		return stageNumber;
	}

	public int getMaxParticipants() {
		return maxParticipants;
	}
	
	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}
	
	public ArrayList<Participant> getParticipantsInStage() {
		return participantsInStage;
	}
	
	public void setParticipantsInStage(ArrayList<Participant> participantsInStage) {
		this.participantsInStage = participantsInStage;
	}
	
	public ArrayList<Participant> getQualifiedParticipants() {
		if(qualifiedParticipants.size() == 1) {
			System.out.println("The winner of X-Factor is: " + qualifiedParticipants.get(0));
		}
		return qualifiedParticipants;
	}
}